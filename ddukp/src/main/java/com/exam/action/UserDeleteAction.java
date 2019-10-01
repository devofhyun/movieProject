package com.exam.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.tools.Tool;

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
		
		
		String opt = request.getParameter("opt");	
		String searchText = request.getParameter("searchText");
		
		
		UserDeleteListTO udListTO=new UserDeleteListTO();
		udListTO.setCpage(cpage);
		udListTO.setSearchKey(opt);
		udListTO.setSearchWord(searchText);
		
		UserDAO dao=new UserDAO();
		udListTO =dao.userDeleteList(udListTO);
		
		request.setAttribute("udListTO", udListTO);
	}

}
