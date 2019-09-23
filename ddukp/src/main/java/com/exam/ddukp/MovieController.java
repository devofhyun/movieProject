package com.exam.ddukp;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.action.Action;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	Action movieAction = null;

	@RequestMapping(value = "/main.do")
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		return modelAndView;
	}

	@RequestMapping(value = "/introduceMoviep.do")
	public ModelAndView introduceMoviep(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("introduceMoviep");
		return modelAndView;
	}

	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./login/login");
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

	@RequestMapping(value = "/customerCenter.do")
	public ModelAndView customerCenter(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./qna/customerCenter");
		return modelAndView;
	}

	@RequestMapping(value = "/customerCenterWrite.do")
	public ModelAndView customerCenterWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./qna/customerCenterWrite");
		return modelAndView;
	}

	@RequestMapping(value = "/customerCenterEdit.do")
	public ModelAndView customerCenterEdit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./qna/customerCenterEdit");
		return modelAndView;
	}

	@RequestMapping(value = "/customerCenterView.do")
	public ModelAndView customerCenterView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./qna/customerCenterView");
		return modelAndView;
	}

	@RequestMapping(value = "/infoBoard.do")
	public ModelAndView infoBoard(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoBoard");
		return modelAndView;
	}
	@RequestMapping(value = "/infoView.do")
	public ModelAndView infoBoardView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoView");
		return modelAndView;
	}
	@RequestMapping(value = "/infoWrite.do")
	public ModelAndView infoBoardWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoWrite");
		return modelAndView;
	}	
	@RequestMapping(value = "/infoEdit.do")
	public ModelAndView infoBoardEdit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoEdit");
		return modelAndView;
	}	
	@RequestMapping(value = "/latterWrite.do")
	public ModelAndView latterWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./latterBoard/latterWrite");
		return modelAndView;
	}
	
	@RequestMapping(value = "/latterList.do")
	public ModelAndView latterList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./latterBoard/latterList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/latterView.do")
	public ModelAndView latterView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./latterBoard/latterView");
		return modelAndView;
	}
	
	@RequestMapping(value = "/latterModify.do")
	public ModelAndView latterModify(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./latterBoard/latterModify");
		return modelAndView;
	}
	
	@RequestMapping(value = "/columnWrite.do")
	public ModelAndView columnWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnWrite");
		return modelAndView;
	}
	@RequestMapping(value = "/columnList.do")
	public ModelAndView columnList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/columnView.do")
	public ModelAndView columnView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnView");
		return modelAndView;
	}
	
	@RequestMapping(value = "/columnModify.do")
	public ModelAndView columnModify(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnModify");
		return modelAndView;
	}
	
	@RequestMapping(value = "/freeWrite.do")
	public ModelAndView freeWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeWrite");
		return modelAndView;
	}
	@RequestMapping(value = "/freeList.do")
	public ModelAndView freeList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/freeView.do")
	public ModelAndView freeView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeView");
		return modelAndView;
	}
	
	@RequestMapping(value = "/freeModify.do")
	public ModelAndView freeModify(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeModify");
		return modelAndView;
	}

	@RequestMapping(value = "/movieSortList.do")
	public ModelAndView movieSortList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./movieSortBoard/movieSortList");
		return modelAndView;
	}

	@RequestMapping(value = "/movieSortView.do")
	public ModelAndView movieSortView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./movieSortBoard/movieSortView");
		return modelAndView;
	}

	@RequestMapping(value = "/movieEnglishList.do")
	public ModelAndView movieEnglishList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./movieEnglishBoard/movieEnglishList");
		return modelAndView;
	}

	@RequestMapping(value = "/movieEnglishView.do")
	public ModelAndView movieEnglishView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./movieEnglishBoard/movieEnglishView");
		return modelAndView;
	}
}


