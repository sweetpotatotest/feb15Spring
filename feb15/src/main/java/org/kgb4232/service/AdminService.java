package org.kgb4232.service;

import java.util.List;

import org.kgb4232.dto.BoardDTO;
import org.kgb4232.dto.NoticeDTO;
import org.kgb4232.dto.SearchDTO;

public interface AdminService {

	List<BoardDTO> boardList(SearchDTO searchDTO);

	int totalRecordCount(SearchDTO searchDTO);

	int postDel(int no);

	List<NoticeDTO> noticeList(SearchDTO searchDTO);

	int totalCountNotice();

	int postDelNotice(int no);

	BoardDTO detail(int str2Int);

}
