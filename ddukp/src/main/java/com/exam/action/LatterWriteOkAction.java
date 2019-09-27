package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.model.BoardDAO;
import com.exam.model.latterBoardTO;

public class LatterWriteOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		latterBoardTO lTO=new latterBoardTO();

		lTO.setRsubject(request.getParameter("rsubject"));
		System.out.println(request.getParameter("leditor"));
		//lTO.setRcontent(request.getParameter("leditor").replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
		lTO.setRcontent(request.getParameter("leditor"));
		lTO.setMsubject(request.getParameter("msubject"));
		lTO.setRip(request.getRemoteAddr());
		HttpSession session = request.getSession();
		lTO.setUid((String)session.getAttribute("sid"));
		lTO.setCtgname(request.getParameter("ctgname"));
		System.out.println("action:"+request.getParameter("ctgname"));
		
		BoardDAO lDAO=new BoardDAO();
		//int flag=lDAO.latterWrite(lTO);
		int rnum=lDAO.latterWrite(lTO);
		request.setAttribute("rnum", rnum);
	}

}
