package org.kgb4232.service;

import java.util.List;

import org.kgb4232.dto.NoticeDTO;

public interface NoticeService {

	public List<NoticeDTO> noticeList(int no);
	
	public NoticeDTO detail(int no);
	
	public int noticeWrite(NoticeDTO dto);
	
	public int noticeDel(int no);
	
	public int noticeUpdate(NoticeDTO dto);
	
	public int noticeTotalPage();
	
}
