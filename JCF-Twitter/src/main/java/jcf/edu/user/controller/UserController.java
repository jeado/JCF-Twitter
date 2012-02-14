package jcf.edu.user.controller;

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

		List<UserVO> findCustomer = userservice.findCustomer(param);
		mciResponse.setList("userList", findCustomer);
		mciResponse.setViewName("user/userList");
	
	}
	
	
	@RequestMapping("/user/info/{userId}")
	public void intfo(MciRequest mciRequest, MciResponse mciResponse,
			@PathVariable String userId) {
		// userservice.findCustomer(map);
	}
}
