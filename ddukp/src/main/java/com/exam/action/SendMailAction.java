package com.exam.action;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.exam.model.UserDAO;

public class SendMailAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("SendMailAction 호출");
		
		String email = request.getParameter("email");
		int flag = 1;
		
		/* 이메일 중복 확인 */
		UserDAO dao = new UserDAO();
		flag = dao.checkEmail(email);
		
		if(flag == 0) {
			/* 이메일 인증 메일 보내기 */
			String setfrom = "zag9511@gmail.com";
			String code = RandomStringUtils.randomAlphabetic(10);
			
			JavaMailSender mailSender = (JavaMailSender)request.getAttribute("mailSender");
			
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
				messageHelper.setTo(email); // 받는사람 이메일
				messageHelper.setSubject("[moviep] 회원가입 인증메일입니다."); // 메일제목은 생략이 가능하다
				messageHelper.setText("인증코드 : " + code); // 메일 내용

				mailSender.send(message);
				
				request.setAttribute("code", code);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			request.setAttribute("code", "0");
		}
	}

}
