package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.model.UserDAO;
import com.exam.model.UserTO;

public class UserChangePwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("UserEditAction 호출");

		UserTO to = new UserTO();
		HttpSession session = request.getSession();
		to.setUid((String) session.getAttribute("sid"));
		to.setUpwd((String) request.getParameter("pwd"));

		UserDAO dao = new UserDAO();
		int flag = dao.LoginOk(to);

		if (flag == 0) {
			// 로그인 성공 => 비밀번호 바꾸기 => 성공 alert
			to.setUpwd((String) request.getParameter("new_pwd"));
			flag = dao.userChangePwd(to);
			if (flag == 0) {
				// 비밀번호가 변경되었습니다.
				flag = 0;
			} else {
				// 새 비밀번호 설정에 실패하였습니다.
				flag = 1;
			}
		} else {
			// 현재 비밀번호가 다릅니다.
			flag = 2;
		}
		
		request.setAttribute("flag", flag);
	}

}
