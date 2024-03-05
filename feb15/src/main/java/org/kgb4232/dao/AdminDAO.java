package org.kgb4232.dao;

import java.util.List;

import org.kgb4232.dto.BoardDTO;
import org.kgb4232.dto.NoticeDTO;
import org.kgb4232.dto.SearchDTO;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO extends AbstractDAO {

	public List<BoardDTO> boardList(SearchDTO searchDTO) {
		return sqlSession.selectList("admin.boardList", searchDTO);
	}

	public int totalRecordCount(SearchDTO searchDTO) {
		return sqlSession.selectOne("admin.totalRecordCount", searchDTO);
	}

	public int postDel(int no) {
		return sqlSession.update("admin.postDel", no);
	}

	public List<NoticeDTO> noticeList(SearchDTO searchDTO) {
		return sqlSession.selectList("admin.noticeList", searchDTO);
	}

	public int totalCountNotice() {
		return sqlSession.selectOne("admin.totalCountNotice");
	}

	public int postDelNotice(int no) {
		return sqlSession.update("admin.postDelNotice", no);
	}

	public BoardDTO detail(int no) {
		return sqlSession.selectOne("admin.detail", no);
	}

	
}
