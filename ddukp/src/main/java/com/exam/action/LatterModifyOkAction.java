package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.model.BoardDAO;
import com.exam.model.latterBoardTO;

public class LatterModifyOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		latterBoardTO lTO=new latterBoardTO();

		lTO.setRsubject(request.getParameter("rsubject"));
		System.out.println("modify : "+request.getParameter("leditor"));
		lTO.setRcontent(request.getParameter("leditor"));
		lTO.setMsubject(request.getParameter("msubject"));
		lTO.setRip(request.getRemoteAddr());
		lTO.setCtgname(request.getParameter("ctgname"));
		lTO.setRnum(Integer.parseInt(request.getParameter("rnum")));
		
		BoardDAO lDAO=new BoardDAO();
		int flag=lDAO.latterModifyOk(lTO);
		String cpage=request.getParameter("cpage");
		System.out.println("수정액션 : "+flag);
		int rnum=Integer.parseInt(request.getParameter("rnum"));
		request.setAttribute("flag", flag);
		request.setAttribute("cpage", cpage);
		request.setAttribute("rnum", rnum);
	}

}
