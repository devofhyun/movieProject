package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.model.UserDAO;
import com.exam.model.UserTO;

public class MemberDeleteOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("MemberDeleteOkAction 호출");
		
		UserTO to = new UserTO();
		UserDAO dao = new UserDAO();
		HttpSession session = request.getSession();
		
		to.setUid((String) session.getAttribute("sid"));
		to.setUpwd(request.getParameter("pwd"));
		System.out.println(request.getParameter("pwd"));
		int flag = dao.memberDeleteOk(to);
		request.setAttribute("flag", flag);
		
		System.out.println("액션 flag : " + flag);

	}

}
