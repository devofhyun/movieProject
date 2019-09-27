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
import com.exam.action.LatterDeleteAction;
import com.exam.action.MovieListAction;
import com.google.gson.JsonObject;
import com.exam.action.LatterListAction;
import com.exam.action.LatterModifyAction;
import com.exam.action.LatterModifyOkAction;
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

	@RequestMapping(value = "/movieList.do")
	public  String movieList(HttpServletRequest request, HttpServletResponse response) {
		movieAction=new MovieListAction();
		movieAction.execute(request, response);
		JSONArray jsonArray=(JSONArray) request.getAttribute("movielist");
		System.out.println(jsonArray.toString());
		return jsonArray.toString();
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

	@RequestMapping(value = "/upload.do", method=RequestMethod.POST)
	public void ImageUpload(HttpServletRequest request, HttpServletResponse response,@RequestParam MultipartFile upload) {
		 OutputStream out = null;
	        PrintWriter printWriter = null;
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        System.out.println("fileuploa");
	        JsonObject json = new JsonObject();
	       

	        try{
	        	
	            String fileName = upload.getOriginalFilename();
	            byte[] bytes = upload.getBytes();
	           // String uploadPath = "C:/Users/kitcoop/Desktop/09-26/ddukp_0925_user/src/main/webapp/upload/" + fileName;//저장경로
	           String uploadPath= request.getSession().getServletContext().getRealPath("/upload");
	            uploadPath=uploadPath+"/"+fileName;
	            out = new FileOutputStream(new File(uploadPath));
	            out.write(bytes);
	 
	            printWriter = response.getWriter();
	            String fileUrl = request.getContextPath()+ "/upload/"+ fileName;//url경로
	 

	            json.addProperty("uploaded", 1);
	            json.addProperty("fileName", fileName);
	            json.addProperty("url", fileUrl);

	            printWriter.println(json);
	        }catch(IOException e){
	            e.printStackTrace();
	        } finally {
	            try {
	                if (out != null) {
	                    out.close();
	                }
	                if (printWriter != null) {
	                    printWriter.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	 
	        return;
		
		
	}
	
	@RequestMapping(value="fileupload.do", method=RequestMethod.POST)
	@ResponseBody
	public String fileUpload(HttpServletRequest req, HttpServletResponse resp, 
                 MultipartHttpServletRequest multiFile) throws Exception {
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		MultipartFile file = multiFile.getFile("upload");
		if(file != null){
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())){
				System.out.println("context"+file.getContentType());
				if(file.getContentType().toLowerCase().startsWith("image/")){
					try{
						String fileName = file.getOriginalFilename();
						byte[] bytes = file.getBytes();
						String uploadPath = req.getSession().getServletContext().getRealPath("/img");
						System.out.println("uppath: "+uploadPath);
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()){
							uploadFile.mkdirs();
							System.out.println("노존재");
						}
						fileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
						uploadPath = uploadPath + "/" + fileName;
						out = new FileOutputStream(new File(uploadPath));
                        out.write(bytes);
                        
                        printWriter = resp.getWriter();
                        resp.setContentType("text/html");
                        String fileUrl = req.getContextPath() + "/img/" + fileName;
                        
                        // json 데이터로 등록
                        // {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/img/test.jpg"}
                        // 이런 형태로 리턴이 나가야함.
                        json.addProperty("uploaded", 1);
                        json.addProperty("fileName", fileName);
                        json.addProperty("url", fileUrl);
                        
                        printWriter.println(json);
                    }catch(IOException e){
                        e.printStackTrace();
                    }finally{
                        if(out != null){
                            out.close();
                        }
                        if(printWriter != null){
                            printWriter.close();
                        }		
					}
				}
			}
		}
		return null;
	}	



}


