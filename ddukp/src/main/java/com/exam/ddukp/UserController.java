package com.exam.ddukp;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.action.Action;
import com.exam.action.LoginAction;
import com.exam.action.LoginOkAction;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	Action userAction = null;
	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		userAction = new LoginAction();
		System.out.println("login");
		modelAndView.setViewName("./login/login");
		return modelAndView;
	}

	@RequestMapping(value = "/login_ok.do")
	public ModelAndView login_ok(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();

		userAction = new LoginOkAction();
		HttpSession session = request.getSession();
		session.setAttribute("sid", request.getParameter("id"));

		userAction.execute(request, response);

		if (session != null) {
			modelAndView.setViewName("main");
		} else {
			modelAndView.setViewName("./login/login");
			System.out.println("sid : " + request.getParameter("id"));
		}
		return modelAndView;
	}

	@RequestMapping(value = "/logout_ok.do")
	public ModelAndView logout_ok(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		System.out.println("로그아웃");
		session.invalidate();
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping(value = "/register.do")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./login/register");
		return modelAndView;
	}

	@RequestMapping(value = "/findPwd.do")
	public ModelAndView findPwd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./login/findPwd");
		return modelAndView;
	}

	@RequestMapping(value = "/findId.do")
	public ModelAndView findId(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./login/findId");
		return modelAndView;
	}

	@RequestMapping(value = "/memberInfo.do")
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./mypage/memberInfo");
		return modelAndView;
	}

	@RequestMapping(value = "/memberEdit.do")
	public ModelAndView memberEdit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./mypage/memberEdit");
		return modelAndView;
	}

	@RequestMapping(value = "/memberDelete.do")
	public ModelAndView memberDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./mypage/memberDelete");
		return modelAndView;
	}

	@RequestMapping(value = "/memberWrite.do")
	public ModelAndView memberWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./mypage/memberWrite");
		return modelAndView;
	}

	@RequestMapping(value = "/memberScrap.do")
	public ModelAndView memberScrap(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./mypage/memberScrap");
		return modelAndView;
	}
	@RequestMapping(value = "/changePwd.do")
	public ModelAndView changePwd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./mypage/changePwd");
		return modelAndView;
	}
	@RequestMapping(value = "/userDelete.do")
	public ModelAndView userDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./admin/userDelete");
		return modelAndView;
	}
}


