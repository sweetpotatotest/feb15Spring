package org.kgb4232.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class FileController {

	@GetMapping("/file")
	public String file() {
		return "file";
	}
	
	@PostMapping("/file")
	public String file(@RequestParam("file1") MultipartFile upFile, HttpServletRequest request) {
		System.err.println(upFile.getOriginalFilename());
		System.err.println(upFile.getSize());
		System.err.println(upFile.getContentType());
		
		//경로
		String root = request.getSession().getServletContext().getRealPath("/");
		System.err.println(root);
		String upfile = root + "resources\\upfile\\";
		System.err.println(upfile);
		
		//UUID생성 - 랜덤숫자? 	bab6aa25-1cf3-4846-bb3c-2d4d26e5e3d5
		UUID uuid = UUID.randomUUID();
		String newFileName = uuid.toString() + "-" + upFile.getOriginalFilename();
		//5a489650-f067-4ba4-88e4-1d297a856a37-like.png
		
		//Real upload
		File f = new File(upfile, newFileName);
		try {
			//썸네일 만들기
			FileOutputStream thumbnail = new FileOutputStream(new File(upfile, "s_" +newFileName));
			Thumbnailator.createThumbnail(upFile.getInputStream(), thumbnail, 100, 100);
			thumbnail.close();
			
			upFile.transferTo(f);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/file";
	}
}
