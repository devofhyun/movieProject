package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.model.BoardDAO;
import com.exam.model.latterBoardTO;

public class LatterModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		latterBoardTO lTO=new latterBoardTO();
		lTO.setRnum(Integer.parseInt(request.getParameter("rnum")) );
		BoardDAO dao=new BoardDAO();
		lTO=dao.latterModify(lTO);
		
		request.setAttribute("lTO", lTO);
	}

}
