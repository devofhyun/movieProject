package com.exam.action;

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

		flag = dao.LoginOk(to);
		if (flag == 0) {
			// 비밀번호 같음
			flag = dao.userEdit(to);
			if (flag == 0) {
				// 계정 생성 성공
				flag = 0;
			} else {
				// 계정 생성 실패 
				flag = 1;
			}
		} else {
			// 비밀번호 다름 
			flag = 2;
		}
		request.setAttribute("flag", flag);
	}

}
