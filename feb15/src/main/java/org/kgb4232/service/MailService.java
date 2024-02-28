package org.kgb4232.service;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	// Mail send
	public void sendTextMail(String email, String title, String content) throws EmailException {
		String emailAddr = "kgb4232@outlook.kr"; // 보내는 사람
		String name = "전자 메일"; // 보내는 사람 이름
		String pw = "01020304bs!"; // 보내는 사람 비번
		String host = "smtp-mail.outlook.com";
		int port = 587;

		SimpleEmail simpleEmail = new SimpleEmail(); // 전송할 메일
		simpleEmail.setCharset("UTF-8");
		simpleEmail.setDebug(true);
		simpleEmail.setHostName(host); // 보내는 서버 설정 = 고정
		simpleEmail.setAuthentication(emailAddr, pw); // 보내는 사람 인증 = 고정
		simpleEmail.setSmtpPort(port); // 사용할 port = 고정
		simpleEmail.setStartTLSEnabled(true); // 인증방법 = 고정
		simpleEmail.setFrom(emailAddr, name); // 보내는 사람 email, 보내는 사람 이름 = 고정
		simpleEmail.addTo(email); // 받는 사람
		simpleEmail.setSubject(title);// 제목
		simpleEmail.setMsg(content); // 본문내용 text
		simpleEmail.send();
	}

	public void sendHTMLMail(String email, String title, String content) throws EmailException {
		String emailAddr = "kgb4232@outlook.kr"; // 보내는 사람
		String name = "전자 메일"; // 보내는 사람 이름
		String pw = "01020304bs!"; // 보내는 사람 비번
		String host = "smtp-mail.outlook.com";
		int port = 587;
		
		HtmlEmail mail = new HtmlEmail();
		mail.setCharset("UTF-8");
		mail.setDebug(true);
		mail.setHostName(host); // 보내는 서버 설정 = 고정
		mail.setAuthentication(emailAddr, pw); // 보내는 사람 인증 = 고정
		mail.setSmtpPort(port); // 사용할 port = 고정
		mail.setStartTLSEnabled(true); // 인증방법 = 고정
		mail.setFrom(emailAddr, name); // 보내는 사람 email, 보내는 사람 이름 = 고정
		mail.addTo(email); // 받는 사람
		mail.setSubject(title);// 제목
		mail.setMsg(content); // 본문내용 text
		
		//첨부파일
		EmailAttachment file = new EmailAttachment();
		file.setPath("c:\\temp\\img.png");
		mail.attach(file);
		
		mail.send();
	}

}
