package jcf.edu.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.pic.model.PicVO;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;
import jcf.upload.FileInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	UserService userService;

//-------------------------------------회원가입--------------------------------------
	@RequestMapping("user/create")
	public void joinUser (MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("user/userReg");
	}

	@RequestMapping("user/insertUser")
	public void regUser(MciRequest mciRequest, MciResponse mciResponse){
		UserVO param = mciRequest.getParam(UserVO.class);
		userService.insertUser(param);
		mciResponse.setViewName("redirect:/user/findUsers");
	}

//--------------------------------------로그인-------------------------------------------
	@RequestMapping("login")
	public void login(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("login");
	}

	@RequestMapping("loginHandle")
	public void loginHandle (MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> user = userService.getUser(param);

		if(!user.isEmpty()){
			SessionUtil.addUser(user.get(0));
			mciResponse.setViewName("twitter");
		}else {
			mciResponse.setViewName("login");
		}
	}

//-----------------------------------모든유저------------------------------------------
	@RequestMapping("user/findUsers")
	public void getAllUser(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> allUser = userService.getUser(param);
		mciResponse.setList("userList", allUser, UserVO.class);
		mciResponse.setViewName("user/userList");
	}

//-----------------------------------유저검색-------------------------------------------
	@RequestMapping("user/findUsers2")
	public void getUser(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> allUser = userService.getUser(param);
		mciResponse.setList("userList", allUser, UserVO.class);
		mciResponse.setViewName("user/userList");
	}

//----------------------------------유저 디테일 ------------------------------------------
	@RequestMapping("user/info/{userId}")
	public void userDetail (MciRequest mciRequest, MciResponse mciResponse,
												@PathVariable String userId){
		Map<String, String> map = new HashMap<String, String> ();
		map.put("userId", userId);
		UserVO user = userService.findUser(map);
		mciResponse.set("user", user, UserVO.class);
		mciResponse.setViewName("user/userDetail");
	}

//-------------------------------------회원수정---------------------------------------
	@RequestMapping("user/updateUser")
	public void updUser(MciRequest mciRequest, MciResponse mciResponse){
		UserVO user = mciRequest.getParam(UserVO.class);
		userService.updateUser(user);
		mciResponse.set("user", user, UserVO.class);
		mciResponse.setViewName("redirect:/user/findUsers");
	}

//-------------------------------------회원탈퇴---------------------------------------
	@RequestMapping("user/deleteUser")
	public void delUser(MciRequest mciRequest, MciResponse mciResponse){
		UserVO param = mciRequest.getParam(UserVO.class);
		userService.deleteUser(param);
		mciResponse.setViewName("redirect:/user/findUsers");
	}


}
