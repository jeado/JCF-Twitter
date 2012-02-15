package jcf.edu.twitter_user_pic.controller;

import java.util.List;
import java.util.Map;

import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;
import jcf.upload.FileInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jcf.edu.user.model.UserVO;
import jcf.edu.login.service.LoginService;

@Controller
public class PicController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("file/viewFile")
	public void viewFile(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId){
		String param = mciRequest.getParam("pid");
		String param2 = mciRequest.getParam("photo");
		mciResponse.setDownloadFile(new FileInfo("product", param2));
		System.out.println("<viewFile>param :" + param + "param2 :" + param2);
	}
}
