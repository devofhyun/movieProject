package com.exam.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.model.UserDAO;
import com.exam.model.UserTO;

public class UserEditAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserEditAction 호출");

		UserTO to = new UserTO();
		to.setUid((String) request.getParameter("id"));
		to.setUpwd((String) request.getParameter("pwd"));
		to.setUname((String) request.getParameter("name"));

		if (request.getParameter("phone") == null) {
			to.setUphone("");
		} else {
			to.setUphone((String) request.getParameter("phone"));
		}

		if (request.getParameter("birth") == null) {
			to.setUbirth("");
		} else {
			to.setUbirth((String) request.getParameter("birth"));
		}

		System.out.println("id : " + to.getUid());
		System.out.println("pwd : " + to.getUpwd());
		System.out.println("name : " + to.getUname());
		System.out.println("birth : " + to.getUbirth());
		System.out.println("phone : " + to.getUphone());

		UserDAO dao = new UserDAO();
		int flag = 1;
		String script = "";

		flag = dao.LoginOk(to);
		if (flag == 0) {
			// 비밀번호 같음
			flag = dao.userEdit(to);
			if (flag == 0) {
				// 계정 생성 성공 script
				script = "<script>alert('나의 정보가 수정되었습니다.'); location.href='memberInfo.do';</script>";

			} else {
				// 계정 생성 실패 script
				script = "<script>alert('나의 정보 수정에 실패하였습니다.'); history.go(-1);</script>";
			}
		} else {
			// 비밀번호 다름 script
			script = "<script>alert('비밀번호가 다릅니다.'); history.go(-1);</script>";
		}

		// alert
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(script);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("flag", flag);
	}

}
