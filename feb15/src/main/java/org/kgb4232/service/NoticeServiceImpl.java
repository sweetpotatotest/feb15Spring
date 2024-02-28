package org.kgb4232.service;

import java.util.List;

import org.kgb4232.dao.NoticeDAO;
import org.kgb4232.dto.NoticeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl extends AbstractService implements NoticeService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeDTO> noticeList(int no) {
		return noticeDAO.noticeList(no);
	}

	@Override
	public NoticeDTO detail(int no) {
		return noticeDAO.detail(no);
	}

	@Override
	public int noticeWrite(NoticeDTO dto) {
		return noticeDAO.noticeWrite(dto);
	}

	@Override
	public int noticeDel(int no) {
		return noticeDAO.noticeDel(no);
	}

	@Override
	public int noticeUpdate(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeTotalPage() {
		return noticeDAO.noticeTotalPage();
	}

}
