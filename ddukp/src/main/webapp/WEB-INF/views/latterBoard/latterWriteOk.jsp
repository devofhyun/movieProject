<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	int rnum = (Integer)request.getAttribute("rnum");

	out.println("<script type='text/javascript'>");
	if (rnum == 0) {
		out.println("alert('글쓰기에 실패');");
		out.println("history.back();");
	} else  {
		
		out.println("alert('글쓰기에 성공');");
		out.println("location.href='latterView.do?rnum="+rnum+"';");
	}
	

	out.println("</script>");
%>