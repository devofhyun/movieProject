package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.model.UserDAO;
import com.exam.model.UserTO;

public class UserDeleteOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserDeleteOkAction 호출");

		HttpSession session = request.getSession();
		session.getAttribute("sid");

		System.out.println(session.getAttribute("sid"));
		
		UserTO to = new UserTO();
		UserDAO dao = new UserDAO();		
		String id = request.getParameter("userid");
		System.out.println("액션 아이디 : " + id);
		int flag = dao.userDeleteOk(id);

		request.setAttribute("flag", flag);
		System.out.println("액션1 flag : " + flag);
		System.out.println(session.getAttribute("sid"));
	}

}
