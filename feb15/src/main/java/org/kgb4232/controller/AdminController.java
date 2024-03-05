package org.kgb4232.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kgb4232.dto.BoardDTO;
import org.kgb4232.dto.NoticeDTO;
import org.kgb4232.dto.SearchDTO;
import org.kgb4232.service.AdminService;
import org.kgb4232.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private Util util;
	
	@Resource(name="adminService")
	private AdminService adminService;

	@GetMapping("/")
	public String index() {
		return "admin/index";
	}

	@GetMapping("/index")
	public String index2() {
		return "admin/index";
	}
	
	//20240304
	@GetMapping("/board")
	public String board(
			@RequestParam(name="pageNo", defaultValue = "1") String pageNo, 
			@RequestParam(name="perPage", defaultValue = "1", required =false) String perPage, 
			@RequestParam(name="search", required =false) String search, 
			@RequestParam(name="searchTitle", required =false) String searchTitle, 
			Model model) {
		//페이징 + 검색 + 한 화면에 보이는 게시글 수 변경
		
		//전체 글 수 뽑기(DTO보내기)
		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setSearch(search);
		searchDTO.setSearchTitle(searchTitle);
		
		//전체 글 수 뽑기
		int totalRecordCount = adminService.totalRecordCount(searchDTO);
		
		//전자정부 페이징
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(util.str2Int(pageNo));
		paginationInfo.setRecordCountPerPage(util.str2Int(perPage) * 10);//1, 2, 3, 4, 5, 10
		paginationInfo.setPageSize(10);
		paginationInfo.setTotalRecordCount(totalRecordCount);
		
		//검색에서 사용할 값 추가
		searchDTO.setPageNo(paginationInfo.getFirstRecordIndex());
		searchDTO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<BoardDTO> list = adminService.boardList(searchDTO);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("perPage", perPage);
		model.addAttribute("search", search);
		model.addAttribute("searchTitle", searchTitle);
		return "admin/board";
	}
	
	//삭제하기
	@GetMapping("postDel")
	public String postDel(@RequestParam("no") int no) {
		int result = adminService.postDel(no);
		return "redirect:/admin/board";
	}
	
	//공지사항 스스로 하기
	@GetMapping("/notice")
	public String notice(
			@RequestParam(name="pageNo", defaultValue = "1") String pageNo,
			Model model) {
		
		//페이징 1.전체 글수 뽑기
		int totalCountNotice = adminService.totalCountNotice();
		
		//2. 전자정부 페이징
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(util.str2Int(pageNo));
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		paginationInfo.setTotalRecordCount(totalCountNotice);
		
		//3.페이징 변수 집어넣어서 리스트 뽑기
		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setPageNo(paginationInfo.getFirstRecordIndex());
		
		List<NoticeDTO> list = adminService.noticeList(searchDTO);
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		return "admin/notice";
	}
	
	//공지사항 삭제, 복구 하기
	@GetMapping("/postDelNotice")
	public String postDelNotice(@RequestParam("no") int no) {
		int result = adminService.postDelNotice(no);
		return "redirect:/admin/notice";
	}
	
	
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	
	@GetMapping("/join")
	public String join() {
		return "admin/join";
	}
	
	@GetMapping("/member")
	public String member() {
		return "admin/member";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("no") String no, Model model) {
		// 데이터 베이스에서 받아오세요.
		BoardDTO detail = adminService.detail(util.str2Int(no));
		model.addAttribute("detail", detail);
		return "admin/detail";
	}
	
	/*
	 * 24-03-05
	 * 				세션	쿠키
	 * 사용 예)		로그인	쇼핑 정보, 장바구니, 자동 로그인
	 * 저장위치		서버	브라우져
	 * 속도			느림	빠름
	 * 보안			높음	낮음
	 * 
	 * 쿠키/세션은 캐쉬와 다릅니다.
	 * 
	 * 쿠키는 이름, 값, 유효시간, 도메인, 경로등을 저장합니다.
	 * 클라이언트에 총 300개의 쿠키를 저장할 수 있습니다.
	 * 쿠키는 도메인당 20개만 가질 수 있습니다.
	 * 쿠키 크기는 4096byte(4KB)까지만 저장할 수 있습니다.
	 */
	
	
	
	
	
}
