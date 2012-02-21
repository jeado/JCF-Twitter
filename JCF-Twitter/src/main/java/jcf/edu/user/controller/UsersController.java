package jcf.edu.user.controller;

import java.util.List;
import java.util.Map;

import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UsersService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping("/user/create.action")
	public void showJoinView(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("/user/userReg");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/user/findUsers")
	public void findUsers(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> findUsers = usersService.findUsers(param);
		mciResponse.setList("userList", findUsers);
		mciResponse.setViewName("user/userList");



	}
	@RequestMapping("/user/insertUser")
	public void joinMember(MciRequest mciRequest, MciResponse mciResponse){

		//Map<String, Object> param = mciRequest.getParam();
		UserVO param = mciRequest.getParam(UserVO.class);
		System.out.println("환영합니다. : " +param.getUserName());

		usersService.insertUsers(param);



		mciResponse.setViewName("redirect:/user/findUsers");

	}
	@RequestMapping("/user/info/{userId}")
	public void info(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId ){
}
}