package com.exam.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.exam.model.UserDAO;
import com.exam.model.UserTO;

public class FindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("FindIdAction 호출");

		String email = request.getParameter("email");
		UserDAO dao = new UserDAO();
		UserTO to = dao.findId(email);
		String id = to.getUid();

		String script = "";

		if (id == null) {
			// 아이디 조회 실패 script
			script = "<script>alert('해당 메일로 가입된 계정이 없습니다.'); history.go(-1);</script>";
		} else {
			System.out.println("id : " + id);
			try {
				/* id 정보 해당 메일로 보내기 */
				JavaMailSender mailSender = (JavaMailSender) request.getAttribute("mailSender");
				String setfrom = "zag9511@gmail.com";
				
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
				messageHelper.setTo(email); // 받는사람 이메일
				messageHelper.setSubject("[moviep] 아이디 찾기 안내 메일입니다.");
				messageHelper.setText("아이디 : " + id); // 메일 내용

				mailSender.send(message);

				// 아이디 조회 성공 script
				script = "<script>alert('메일로 아이디 정보가 전송되었습니다.'); location.href='login.do';</script>";

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
