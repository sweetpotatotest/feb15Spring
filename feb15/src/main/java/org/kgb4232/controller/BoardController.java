package org.kgb4232.controller;

import java.util.List;

import org.kgb4232.dto.BoardDTO;
import org.kgb4232.dto.CommentDTO;
import org.kgb4232.dto.WriteDTO;
import org.kgb4232.service.BoardService;
import org.kgb4232.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {
	//1.엔터키 처리 / 글쓰기 / 댓글쓰기
	//2. 로그인 처리
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private Util util;

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	//페이징 추가하기 24-02-20 psd
	@GetMapping("/board")
	public String board(@RequestParam(value = "pageNo", required = false) String no, Model model) {
		//pageNo가 오지 않는다면
		int currentPageNo = 1;
		if (util.str2Int(no) > 0) {
			currentPageNo = Integer.parseInt(no);
		}
		
		//전체 글 수 totalPageCount
		int totalPageCount = boardService.totalPageCount();
		System.err.println(totalPageCount);
		//pagination
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo);// 현재 페이지 번호
		paginationInfo.setRecordCountPerPage(10); //한 페이지에 게시되는 게시물 건 수
		paginationInfo.setPageSize(10); //페이징 리스트의 사이즈
		paginationInfo.setTotalRecordCount(totalPageCount); //전체 게시물 건 수
		
		model.addAttribute("list", boardService.boardList(paginationInfo.getFirstRecordIndex()));
		//페이징 관련 정보가 있는 PaginationInfo 객체를 모델에 반드시 넣어준다.
		model.addAttribute("paginationInfo", paginationInfo);
		return "board";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(value = "no", defaultValue = "10", required = true) String no, Model model) {
		//System.out.println(util.str2Int(no));
		//System.out.println(no);
		int reNo = util.str2Int(no);
		if (reNo != 0) {
			//0이 아니야 = 정상 : DB에 물어보기 + 값 가져오기 / 붙이기 / 이동하기
			BoardDTO detail = boardService.detail(reNo);
			model.addAttribute("detail", detail);
			
			//2024-02-19 psd 댓글도 뽑기
			//System.out.println("댓글 수 : " +detail.getComment());
			if (detail.getComment() > 0) {
				List<CommentDTO> commentsList = boardService.commentsList(reNo);
				model.addAttribute("commentsList", commentsList);
				
				//System.err.println(commentsList.get(0).getMid());
			}
			
			return "detail";
		} else {
			//0이야 = 비정상 : 에러로 페이지 이동하기
			//return "error/error";
			return "redirect:/error"; //controller에 있는 error매핑을 실행해
		}
	}
	
	@GetMapping("/write")
	public String write() {
		//return "write";
		return "redirect:/login?error=2024";
	}
	
	
	@PostMapping("/write")
	public String write(WriteDTO dto) {
		if (util.getSession().getAttribute("mid") != null) {
			int result = boardService.write(dto);
			if (result == 1) {
				return "redirect:/detail?no="+dto.getBoard_no();
			} else {
				return "redirect:/error";
			}
		} else {
			return "redirect:/login?error=2048";
		}
	}
	
	//댓글쓰기 2024-02-19 psd == 글번호 no, 댓글내용 comment, 글쓴이 = 세션
	@PostMapping("/commentWrite")
	public String commentWrite(CommentDTO comment) {
		//HttpSession session = request.getSession();
		//comment.setMid((String) session.getAttribute("mid"));
		//로그인 여부 검사
		if (util.getSession().getAttribute("mid") != null) {
			int result = boardService.commentWrite(comment);
			System.err.println("댓글쓰기 결과 " +result);
			return "redirect:/detail?no="+comment.getNo();
		} else {
			return "redirect:/login";
		}
		
	}
	
	@PostMapping("/postDel")
	public String postDel(@RequestParam("no") int no) {
		//로그인 여부
		if (util.getSession().getAttribute("mid") != null) {
			//System.out.println("no : " + no);
			int result = boardService.postDel(no);
			System.err.println("result : " + result);
			return "redirect:/board";
		} else {
			return "redirect:/login";
		}
	}
	//댓글삭제 2024-02-21 psd == 댓글 번호 + mid + 글번호
	@GetMapping("/deleteComment")
	public String deleteComment(@RequestParam("no") int no, @RequestParam("cno") int cno) {
		//System.err.println(no);
		//System.err.println(cno);
		int result = boardService.deleteComment(no, cno);
		System.err.println(result);
		return "redirect:/detail?no="+no;
	}
	
	//24-02-22 요구사항 확인
	@GetMapping("/likeUp")
	public String likeUp(@RequestParam("no") String no, @RequestParam("cno") String cno) {
		if (util.intCheck(no) && util.intCheck(cno)) {
			CommentDTO dto = new CommentDTO();
			dto.setBoard_no(Integer.parseInt(no));
			dto.setNo(Integer.parseInt(cno));
			
			boardService.likeUp(dto);
			return "redirect:/detail?no="+dto.getBoard_no();
		} else {
			return "redirect:/error";
		}
	}
	
}
