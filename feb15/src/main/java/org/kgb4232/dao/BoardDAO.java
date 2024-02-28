package org.kgb4232.dao;

import java.util.List;
import java.util.Map;

import org.kgb4232.dto.BoardDTO;
import org.kgb4232.dto.CommentDTO;
import org.kgb4232.dto.WriteDTO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO extends AbstractDAO{

	public List<Map<String, Object>> boardList(int pageNo) {
		return sqlSession.selectList("board.boardList", pageNo);
	}

	public BoardDTO detail(int no) {
		return sqlSession.selectOne("board.detail", no);
	}
	
	public int write(WriteDTO dto) {
		return sqlSession.insert("board.write", dto);
	}

	public int commentWrite(CommentDTO comment) {
		return sqlSession.insert("board.commentWrite", comment);
	}

	public List<CommentDTO> commentsList(int reNo) {
		return sqlSession.selectList("board.commentsList", reNo);
	}

	public int postDel(WriteDTO dto) {
		return sqlSession.update("board.postDel", dto);
	}

	public int totalRecordCount() {
		return sqlSession.selectOne("board.totalRecordCount");
	}

	public int deleteComment(CommentDTO dto) {
		return sqlSession.update("board.deleteComment", dto);
	}


	public void countUp(BoardDTO dto) {
		sqlSession.insert("board.countUP", dto);
	}

	public void likeUp(CommentDTO dto) {
		sqlSession.update("board.likeUp", dto);
	}

	/*
	 * public int alreadyRead(BoardDTO dto) { return
	 * sqlSession.selectOne("board.alreadyRead", dto); }
	 */
	
	
}
