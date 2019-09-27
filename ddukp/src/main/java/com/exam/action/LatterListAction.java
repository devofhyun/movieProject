package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.model.BoardDAO;
import com.exam.model.latterBoardListTO;

public class LatterListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int cpage=1;
		if (request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) {
			cpage = Integer.parseInt(request.getParameter("cpage"));
		}
		
		latterBoardListTO lLTO=new latterBoardListTO();
		System.out.println("cpge="+cpage);
		lLTO.setCpage(cpage);
		
		
		BoardDAO dao=new BoardDAO();
		lLTO=dao.latterList(lLTO);
		
		request.setAttribute("lLTO", lLTO);
	}

}
