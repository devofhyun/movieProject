package com.exam.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.model.UserDAO;
import com.exam.model.UserTO;

public class UserRegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserRegisterAction 호출");
		
		UserTO to = new UserTO();
		to.setUid(request.getParameter("id"));
		to.setUname(request.getParameter("name"));
		to.setUpwd(request.getParameter("pwd"));
		to.setUemail(request.getParameter("email"));
		to.setUbirth(request.getParameter("birth"));
		to.setUphone(request.getParameter("phone"));
		
		System.out.println("액션아이디: " + request.getParameter("id"));

		int flag = 1;
		UserDAO dao = new UserDAO();
		flag = dao.userRegister(to);
		
		System.out.println("userRegister flag: " + flag);

		String script = "";
		if (flag == 0) {
			// 계정 생성 성공 script
			script = "<script>alert('회원가입 되셨습니다.'); location.href='login.do';</script>";

		} else {
			// 계정 생성 실패 script
			script = "<script>alert('회원가입에 실패하셨습니다.'); history.go(-1);</script>";
		}
		
		try {
			// alert
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(script);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("flag", flag);
	}


}
