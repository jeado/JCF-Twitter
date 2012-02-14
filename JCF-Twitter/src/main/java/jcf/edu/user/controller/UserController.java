package jcf.edu.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	UserService userService;



	@RequestMapping("login")
	public void login(MciRequest mciRequest, MciResponse mciResponse){
		//userService.findUser (userId);
		mciResponse.setViewName("login");
	}

	@RequestMapping("loginHandle")
	public void loginHandle (MciRequest mciRequest, MciResponse mciResponse){
		//SessionUtil session = new SessionUtil();
		//session.addUser(userVO
		mciResponse.setViewName("login");
	}

//----------------------------------유저 한사람 -------------------------------------
	@RequestMapping("user/info/{userId}")
	public void userDetail (MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId){

		Map<String, String> map = new HashMap<String, String> ();
		map.put("id", userId);
		UserVO user = userService.findUser(map);
		mciResponse.set("user", user, UserVO.class);
		mciResponse.setViewName("user/userDetail");
	}


//-----------------------------------모든유저-------------------------------------------------
	@RequestMapping("user/findUsers")
	public void getAllUser(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> allUser = userService.getAllUser(param);
		mciResponse.setList("userList", allUser, UserVO.class);
		mciResponse.setViewName("user/userList");
	}

	@RequestMapping("user/findUsers2")
	public void getUser(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		System.out.println("TEST________1111111"+param);
		List<UserVO> allUser = userService.getAllUser(param);
		mciResponse.setList("userList", allUser, UserVO.class);
		mciResponse.setViewName("user/userList");
	}

	@RequestMapping("user/create")
	public void joinUser (MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("user/userReg");
	}

	@RequestMapping("user/insertUser")
	public void regUser(MciRequest mciRequest, MciResponse mciResponse){

		//Customer param = mciRequest.getParam(Customer.class);
		//customerService.insertCustomer(param);
		//mciResponse.set("member", param);
		//mciResponse.setViewName("join_member_proc");

		UserVO param = mciRequest.getParam(UserVO.class);
		//SessionUtil session = new SessionUtil();
		//session.addUser(userVO);
		mciResponse.setViewName("user/userDetail");
	}
}
