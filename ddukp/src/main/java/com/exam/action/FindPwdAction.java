package com.exam.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.exam.model.UserDAO;
import com.exam.model.UserDeleteListTO;
import com.exam.model.UserTO;

public class FindPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("FindPwdAction 호출");

		String email = request.getParameter("email");
		String id = request.getParameter("id");

		System.out.println("email : " + email + ", id : " + id);

		UserDAO dao = new UserDAO();
		UserTO to = dao.findPwd(id, email);
		String pwd = to.getUpwd();

		String script = "";

		System.out.println("임시 비밀번호 : " + pwd);
		if (pwd != null) {
			/* 이메일에 임시 비밀번호 전송하기! */
			JavaMailSender mailSender = (JavaMailSender) request.getAttribute("mailSender");
			String setfrom = "zag9511@gmail.com";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
				messageHelper.setTo(email); // 받는사람 이메일
				messageHelper.setSubject("[moviep] 임시 비밀번호 안내 메일입니다.");
				messageHelper.setText("임시 비밀번호 : " + pwd); // 메일 내용

				mailSender.send(message);

				// 임시 비밀번호 전송 후 script
				script = "<script>alert('메일로 임시 비밀번호가 전송되었습니다.'); location.href='login.do';</script>";

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 계정 조회 실패 script
			script = "<script>alert('해당 메일과 아이디로 가입된 계정이 없습니다.'); history.go(-1);</script>";
		}
		// alert
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(script);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
