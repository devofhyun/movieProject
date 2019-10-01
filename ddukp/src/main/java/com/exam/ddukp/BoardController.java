package com.exam.ddukp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exam.action.Action;
import com.exam.action.ColumnDeleteAction;
import com.exam.action.ColumnListAction;
import com.exam.action.ColumnModifyAction;
import com.exam.action.ColumnModifyOkAction;
import com.exam.action.ColumnViewAction;
import com.exam.action.ColumnWriteOkAction;
import com.exam.action.CustomerListAction;
import com.exam.action.FreeDeleteAction;
import com.exam.action.FreeListAction;
import com.exam.action.FreeModifyAction;
import com.exam.action.FreeModifyOkAction;
import com.exam.action.FreeViewAction;
import com.exam.action.FreeWriteOkAction;
import com.exam.action.InfoDeleteAction;
import com.exam.action.InfoListAction;
import com.exam.action.InfoModifyAction;
import com.exam.action.InfoModifyOkAction;
import com.exam.action.InfoViewAction;
import com.exam.action.InfoWriteOkAction;
import com.exam.action.LatterDeleteAction;
import com.exam.action.MovieListAction;
import com.exam.action.UploadAction;
import com.google.gson.JsonObject;
import com.exam.action.LatterListAction;
import com.exam.action.LatterModifyAction;
import com.exam.action.LatterModifyOkAction;
import com.exam.action.LatterUploadAction;
import com.exam.action.LatterViewAction;
import com.exam.action.LatterWriteOkAction;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	Action movieAction = null;

	@RequestMapping(value = "/movieList.do",produces ="application/text; charset=utf8")
	@ResponseBody
	public ResponseEntity movieList(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new MovieListAction();
		movieAction.execute(request, response);
		JSONArray jsonArray=(JSONArray) request.getAttribute("movielist");
		return new ResponseEntity(jsonArray.toString(), HttpStatus.CREATED);
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
		movieAction=new LatterListAction();
		movieAction.execute(request, response);
		modelAndView.setViewName("./latterBoard/latterList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/latterView.do")
	public ModelAndView latterView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		movieAction=new LatterViewAction();
		movieAction.execute(request, response);
		modelAndView.setViewName("./latterBoard/latterView");
		return modelAndView;
	}
	
	@RequestMapping(value = "/latterModify.do")
	public ModelAndView latterModify(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		movieAction=new LatterModifyAction();
		movieAction.execute(request, response);
		modelAndView.setViewName("./latterBoard/latterModify");
		return modelAndView;
	}
	
	@RequestMapping(value = "/latterModifyOk.do")
	public ModelAndView latterModifyOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		movieAction=new LatterModifyOkAction();
		movieAction.execute(request, response);
		modelAndView.setViewName("./latterBoard/latterModifyOk");
		return modelAndView;
	}
	
	@RequestMapping(value = "/latterWriteOk.do")
	public ModelAndView latterWrtieOk(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new LatterWriteOkAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./latterBoard/latterWriteOk");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/latterDelete.do")
	public ModelAndView latterDelete(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new LatterDeleteAction();
		movieAction.execute(request, response);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./latterBoard/latterDelete");
		
		return modelAndView;
	}
	
	@RequestMapping(value="fileupload.do", method=RequestMethod.POST)
	@ResponseBody
	public String fileUpload(HttpServletRequest request, HttpServletResponse response, 
         MultipartHttpServletRequest multiFile) throws Exception {
		UploadAction upAction=new LatterUploadAction();
		upAction.execute(request, response, multiFile);
		return null;
	}	

	@RequestMapping(value = "/freeList.do")
	public ModelAndView freeList(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new FreeListAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/freeWrite.do")
	public ModelAndView freeWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeWrite");
		return modelAndView;
	}
	
	@RequestMapping(value = "/freeWriteOk.do")
	public ModelAndView freeWriteOk(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new FreeWriteOkAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeWriteOk");
		return modelAndView;
	}
	
	@RequestMapping(value = "/freeView.do")
	public ModelAndView freeView(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new FreeViewAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeView");
		return modelAndView;
	}
	
	@RequestMapping(value = "/freeModify.do")
	public ModelAndView freeModify(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new FreeModifyAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeModify");
		return modelAndView;
	}
	
	@RequestMapping(value = "/freeModifyOk.do")
	public ModelAndView freeModifyOk(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new FreeModifyOkAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeModifyOk");
		return modelAndView;
	}
	
	@RequestMapping(value = "/freeDelete.do")
	public ModelAndView freeDelete(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new FreeDeleteAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./freeBoard/freeDelete");
		return modelAndView;
	}
	
	@RequestMapping(value = "/columnList.do")
	public ModelAndView columnList(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new ColumnListAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/columnWrite.do")
	public ModelAndView columnWrite(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnWrite");
		return modelAndView;
	}
	
	@RequestMapping(value = "/columnWriteOk.do")
	public ModelAndView columnWriteOk(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new ColumnWriteOkAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnWriteOk");
		
		return modelAndView;
	}

	@RequestMapping(value = "/columnView.do")
	public ModelAndView columnView(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new ColumnViewAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnView");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/columnModify.do")
	public ModelAndView columnModify(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new ColumnModifyAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnModify");
		return modelAndView;
	}
	
	@RequestMapping(value = "/columnModifyOk.do")
	public ModelAndView columnModifyOk(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new ColumnModifyOkAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnModifyOk");
		return modelAndView;
	}
	
	@RequestMapping(value = "/columnDelete.do")
	public ModelAndView columnDelete(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new ColumnDeleteAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./columnBoard/columnDelete");
		return modelAndView;
	}
	
	@RequestMapping(value = "/infoBoard.do")
	public ModelAndView infoBoard(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new InfoListAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoBoard");
		return modelAndView;
	}
	
	@RequestMapping(value = "/infoWrite.do")
	public ModelAndView infoBoardWrite(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoWrite");
		return modelAndView;
	}
	
	@RequestMapping(value = "/infoWriteOk.do")
	public ModelAndView infoWriteOk(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new InfoWriteOkAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoWriteOk");
		return modelAndView;
	}
	
	@RequestMapping(value = "/infoView.do")
	public ModelAndView infoView(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new InfoViewAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoView");
		return modelAndView;
	}
	
	@RequestMapping(value = "/infoModify.do")
	public ModelAndView infoModify(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new InfoModifyAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoModify");
		return modelAndView;
	}
	
	@RequestMapping(value = "/infoModifyOk.do")
	public ModelAndView infoModifyOk(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new InfoModifyOkAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoModifyOk");
		return modelAndView;
	}
	
	@RequestMapping(value = "/infoDelete.do")
	public ModelAndView infoDelete(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new InfoDeleteAction();
		movieAction.execute(request, response);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./info/infoDelete");
		return modelAndView;
	}
	@RequestMapping(value = "/customerCenter.do")
	public ModelAndView customerCenter(HttpServletRequest request, HttpServletResponse response) {
		movieAction = new CustomerListAction();
		movieAction.execute(request, response);
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
}


