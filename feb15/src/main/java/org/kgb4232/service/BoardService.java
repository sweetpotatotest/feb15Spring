package org.kgb4232.service;

import java.util.List;
import java.util.Map;

import org.kgb4232.dao.BoardDAO;
import org.kgb4232.dto.BoardDTO;
import org.kgb4232.dto.CommentDTO;
import org.kgb4232.dto.WriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService extends AbstractService{

	@Autowired
	private BoardDAO boardDAO;
	
	
	public List<Map<String, Object>> boardList(int pageNo){
		return boardDAO.boardList(pageNo);
	}

	public BoardDTO detail(int no) {
		//2024-02-22 psd 요구사항 확인
		//로그인 했어? -> 읽음 수 올리기
		if (util.getSession().getAttribute("mid") != null) {
			BoardDTO dto = new BoardDTO();
			dto.setBoard_no(no);
			dto.setMid((String) util.getSession().getAttribute("mid"));
			//int result = boardDAO.alreadyRead(dto);
			//if (result == 0) { //이미 읽었는지 검사하기
				boardDAO.countUp(dto);
			//}
		}
		return boardDAO.detail(no);
	}

	public int write(WriteDTO dto) {
		//엔터키 처리
		dto.setContent(dto.getContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		dto.setMid((String) util.getSession().getAttribute("mid"));
		dto.setIp(util.getIP());
		return boardDAO.write(dto);
	}

	public int commentWrite(CommentDTO comment) {
		//comment.setMid("hahaha");
		comment.setComment(comment.getComment().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		comment.setMid((String) util.getSession().getAttribute("mid"));
		comment.setCip(util.getIP());
		return boardDAO.commentWrite(comment);
	}

	public List<CommentDTO> commentsList(int reNo) {
		return boardDAO.commentsList(reNo);
	}

	public int postDel(int no) { // 글번호 + mid = 자신의 글만 삭제하기 위해서
		WriteDTO dto = new WriteDTO();
		dto.setBoard_no(no);
		dto.setMid((String) util.getSession().getAttribute("mid"));
		
		return boardDAO.postDel(dto);
	}

	public int totalPageCount() {
		return boardDAO.totalRecordCount();
	}

	public int deleteComment(int no, int cno) {
		CommentDTO dto = new CommentDTO();
		dto.setNo(cno);
		dto.setBoard_no(no);
		dto.setMid((String) util.getSession().getAttribute("mid"));
		return boardDAO.deleteComment(dto);
	}

	public void likeUp(CommentDTO dto) {
		boardDAO.likeUp(dto);
	}
}
