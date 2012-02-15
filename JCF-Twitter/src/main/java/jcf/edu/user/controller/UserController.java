package jcf.edu.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@Autowired
	private UserService userservice;

	@RequestMapping("/login")
	public void login(MciRequest mciRequest, MciResponse mciResponse) {

		mciResponse.setViewName("login");

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("loginHandle")
	public void loginProcess(MciRequest mciRequest, MciResponse mciResponse) {
		Map param = mciRequest.getParam();

		List<UserVO> findCustomer = userservice.findCustomer(param);

		UserVO userVO = findCustomer.get(0);
		System.out.println(userVO.getUserName());
		SessionUtil.addUser(userVO);
		mciResponse.set("currentUser", userVO);
		mciResponse.setViewName("twitter");

	}

	@RequestMapping("/user/findUsers")
	public void selectAll(MciRequest mciRequest, MciResponse mciResponse) {
		Map param = mciRequest.getParam();

		List<UserVO> findCustomer = userservice.findCustomer(param);
		
		mciResponse.setList("userList", findCustomer);
		mciResponse.setViewName("user/userList");
	}
	
	@RequestMapping("/user/findUsers2")
	public void selectUser(MciRequest mciRequest, MciResponse mciResponse) {
		Map param = mciRequest.getParam();

		@SuppressWarnings("unchecked")
		List<UserVO> findCustomer = userservice.findCustomer(param);
		mciResponse.setList("userList", findCustomer);
		mciResponse.setViewName("user/userList");
	
	}
	
	@RequestMapping("/user/info/{userId}")
	public void intfo(MciRequest mciRequest, MciResponse mciResponse,
			@PathVariable String userId) {
		Map<String, String> map= new HashMap<String, String>();
		map.put("userId", userId);

		List<UserVO> findCustomer = userservice.findCustomer(map);
		UserVO u = findCustomer.get(0);
		mciResponse.set("user", u);
		mciResponse.setViewName("/user/userDetail");
	}
	
	@RequestMapping("/user/deleteUser")
	public void deleteUser(MciRequest mciRequest, MciResponse mciResponse) {
		UserVO param = mciRequest.getParam(UserVO.class);	
		userservice.deleteUser(param);
		mciResponse.setViewName("redirect:../");
	}
	@RequestMapping("/user/create.action")
	public void goInsertUser(MciRequest mciRequest, MciResponse mciResponse) {
		mciResponse.setViewName("/user/userReg");
		
	}
	@RequestMapping("/user/insertUser")
	public void insertUser(MciRequest mciRequest, MciResponse mciResponse) {
		UserVO param = mciRequest.getParam(UserVO.class);
		userservice.insertUser(param);
		mciResponse.setViewName("redirect:../");
		
	}
		
}
