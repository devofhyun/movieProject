package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.model.UserDAO;
import com.exam.model.UserDeleteListTO;
import com.exam.model.UserTO;

public class UserDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserDeleteAction 호출");
		int cpage=1;
		
		if (request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) {
			cpage = Integer.parseInt(request.getParameter("cpage"));
		}
		
		UserDeleteListTO udListTO=new UserDeleteListTO();
		udListTO.setCpage(cpage);
		
		UserDAO dao=new UserDAO();
		udListTO =dao.userDeleteList(udListTO);
		
		request.setAttribute("udListTO", udListTO);
	}

}
