package org.kgb4232.dao;

import java.util.List;

import org.kgb4232.dto.NoticeDTO;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO extends AbstractDAO{

	public List<NoticeDTO> noticeList(int no) {
		return sqlSession.selectList("notice.noticeList", no);
	}

	public int noticeWrite(NoticeDTO dto) {
		return sqlSession.insert("notice.noticeWrite", dto);
	}

	public NoticeDTO detail(int no) {
		return sqlSession.selectOne("notice.detail", no);
	}

	public int noticeDel(int no) {
		return sqlSession.update("notice.noticeDel", no);
	}

	public int noticeTotalPage() {
		return sqlSession.selectOne("notice.noticeTotalPage");
	}

	
}
