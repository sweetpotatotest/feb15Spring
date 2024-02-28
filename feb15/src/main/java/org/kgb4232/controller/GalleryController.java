package org.kgb4232.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kgb4232.dto.GalleryDTO;
import org.kgb4232.service.GalleryService;
import org.kgb4232.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GalleryController {

	@Resource(name="galleryService")
	private GalleryService galleryService;

	@Autowired
	private Util util;

	@GetMapping("/gallery")
	public String gallery(Model model) {
		List<GalleryDTO> list = galleryService.galleryList();
		model.addAttribute("list", list);
		return "gallery";
	}

	@GetMapping("/galleryInsert")
	public String galleryInsert() {
		if (util.getSession().getAttribute("mid") != null) {
			return "galleryInsert";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping("/galleryInsert")
	public String galleryInsert(GalleryDTO dto, @RequestParam("file1") MultipartFile upFile) {
		if (util.getSession().getAttribute("mid") != null) {
			// System.out.println(dto.getGtitle());
			// System.out.println(dto.getGcontent());
			// System.out.println(upFile.getOriginalFilename());
			// 파일 업로드 -> util
			String newFileName = util.fileUpload(upFile);
			dto.setGfile(newFileName);// UUID+

			int result = galleryService.galleryInsert(dto);
			return "redirect:/gallery";
		} else {
			return "redirect:/login";
		}
	}
	
	//galleryDetail
	//24-02-26 요구사항 확인 psd
	@GetMapping("/galleryDetail@{no}")
	public String galleryDetail(@PathVariable("no") String no, Model modal) {
		System.err.println(no);
		GalleryDTO detail = galleryService.detail(no);
		modal.addAttribute("detail", detail);
		return "galleryDetail";
	}
	

}
