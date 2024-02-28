package org.kgb4232.controller;

import org.apache.commons.mail.EmailException;
import org.kgb4232.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//24-02-23
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MailController {

	@Autowired
	private MailService mailService;
	
	//제작순서
	//menu에다가 추가 -> Controller -> jsp 화면구성 -> db(서비스...쭉)
	@GetMapping("/mail")
	public String mail() {
		//로그인 한 사용자만 접근가능합니다.
		return "mail";
	}
	//jsp -> Controller -> **Service메일발송**
	@PostMapping("/mail")
	public String mail(@RequestParam("email") String email, @RequestParam("title") String title, @RequestParam("content") String content) throws EmailException {
		//System.out.println(email);
		//System.out.println(title);
		//System.out.println(content);
		
		//mailService.sendTextMail(email, title, content);
		mailService.sendHTMLMail(email, title, content);
		return "redirect:/mail";
	}
}
