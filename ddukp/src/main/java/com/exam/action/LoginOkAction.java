package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.model.UserDAO;
import com.exam.model.UserTO;

public class LoginOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("LoginOkAction 호출");
		
		UserTO to = new UserTO();
		to.setUid(request.getParameter("id"));
		to.setUpwd(request.getParameter("pwd"));
		
		System.out.println("액션아이디: " + request.getParameter("id"));
		
		UserDAO dao = new UserDAO();
		
		int flag = dao.LoginOk(to);
		System.out.println("액션플래그: " + flag);
		
		request.setAttribute("flag", flag);
	}

}
