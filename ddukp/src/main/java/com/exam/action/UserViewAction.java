package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.model.UserDAO;
import com.exam.model.UserTO;

public class UserViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserViewAction 호출");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sid");
		UserDAO dao = new UserDAO();
		UserTO to = dao.userView(id);
		System.out.println("세션아이디 : " + id);
		request.setAttribute("to", to);
	}

}
