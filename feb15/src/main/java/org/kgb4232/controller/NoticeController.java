package org.kgb4232.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import org.kgb4232.dto.NoticeDTO;
import org.kgb4232.service.NoticeService;
import org.kgb4232.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeController {

	@Autowired
	private Util util;
	
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	//24-02-27 요구사항 확인!
	@GetMapping("/notice")
	public String noticeList(@RequestParam(value = "pageNo", required = false) String no, Model model) {
		int currentPageNo = 1;
		if (util.str2Int(no) > 0) {
			currentPageNo = Integer.parseInt(no);
		}
			
		int totalPageCount = noticeService.noticeTotalPage();
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo);// 현재 페이지 번호
		paginationInfo.setRecordCountPerPage(10); //한 페이지에 게시되는 게시물 건 수
		paginationInfo.setPageSize(10); //페이징 리스트의 사이즈
		paginationInfo.setTotalRecordCount(totalPageCount); //전체 게시물 건 수
		
		List<NoticeDTO> list = noticeService.noticeList(paginationInfo.getFirstRecordIndex());
		
		model.addAttribute("list", list);
		model.addAttribute("paginationInfo", paginationInfo);
		
		//현재 시간 표시
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("sdf", sdf.format(currentDate));
		return "notice";
	}
	
	//공지 글쓰기 -> admin관리자 화면으로 이동
	@GetMapping("/admin/noticeWrite")
	public String noticeWrite() {
		return "admin/noticeWrite";
	}
	
	@PostMapping("/admin/noticeWrite")
	public String noticeWrite(NoticeDTO dto) {
		//System.err.println(dto.getNtitle());
		//System.err.println(dto.getNcontent());
		int result = noticeService.noticeWrite(dto);
		return "redirect:/notice";
	}
	
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(value = "no", defaultValue = "0", required = true) int no, Model model) {
		if (no == 0) {
			return "redirect:/error";
		} else {
			NoticeDTO dto = noticeService.detail(no);
			if (dto.getNno() == 0) {
				return "redirect:/error";
				
			} else {
				model.addAttribute("dto", dto);
				return "noticeDetail";
			}
		}
	}
	
	//noticeDel
	@GetMapping("/noticeDel{no}")
	public String noticeDel(@PathVariable("no") int no) {
		//System.out.println("@PathVariable :" + no);
		noticeService.noticeDel(no);
		return "redirect:/notice";
	}
	
	
	
}
