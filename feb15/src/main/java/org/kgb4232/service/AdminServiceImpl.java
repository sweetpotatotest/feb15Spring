package org.kgb4232.service;

import java.util.List;

import org.kgb4232.dao.AdminDAO;
import org.kgb4232.dto.BoardDTO;
import org.kgb4232.dto.NoticeDTO;
import org.kgb4232.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl extends AbstractService implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public List<BoardDTO> boardList(SearchDTO searchDTO) {
		return adminDAO.boardList(searchDTO);
	}

	@Override
	public int totalRecordCount(SearchDTO searchDTO) {
		return adminDAO.totalRecordCount(searchDTO);
	}

	@Override
	public int postDel(int no) {
		return adminDAO.postDel(no);
	}

	@Override
	public List<NoticeDTO> noticeList(SearchDTO searchDTO) {
		return adminDAO.noticeList(searchDTO);
	}

	@Override
	public int totalCountNotice() {
		return adminDAO.totalCountNotice();
	}

	@Override
	public int postDelNotice(int no) {
		return adminDAO.postDelNotice(no);
	}

	@Override
	public BoardDTO detail(int no) {
		return adminDAO.detail(no);
	}

	
}
