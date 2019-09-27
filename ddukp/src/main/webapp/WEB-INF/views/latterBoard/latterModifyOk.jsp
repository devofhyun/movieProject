<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	int rnum = (Integer)request.getAttribute("rnum");
	 int flag= (Integer)request.getAttribute("flag");
	 String  cpage=(String)request.getAttribute("cpage");
	 System.out.print("write flag : "+flag);
	out.println("<script type='text/javascript'>");

	if (flag == 0) {
		out.println("alert('글수정에 성공');");
		out.println("location.href='latterView.do?cpage=" + cpage + "&rnum=" + rnum + "';");
	} else if (flag == 1) {
		out.println("alert('오류입니다.');");
		out.println("history.back();");
	} else if (flag == 2) {
		out.println("alert('글수정에 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>