package jcf.edu.user.controller;

import java.util.List;
import java.util.Map;

import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jcf.edu.user.model.UserVO;
import jcf.edu.login.service.LoginService;

@Controller
public class UserController {

	@Autowired
	private LoginService loginService;
//
//	@RequestMapping("join")
//	public void showJoinView(MciRequest mciRequest, MciResponse mciResponse){
//		mciResponse.setViewName("join_member");
//	}
//
//	@SuppressWarnings("unchecked")
//	@RequestMapping("findCustomer")
//	public void findCustomer(MciRequest mciRequest, MciResponse mciResponse){
//		Map param = mciRequest.getParam();
//		List<UserVO> findCustomer = loginService.findCustomer(param);
//		mciResponse.setList("pp", findCustomer, UserVO.class);
//		mciResponse.setViewName("customer_list");
//	}

//	@RequestMapping("JoinMember")
//	public void joinMember(MciRequest mciRequest, MciResponse mciResponse){
//		UserVO param = mciRequest.getParam(UserVO.class);
//		System.out.println("환영합니다 " + param.getUserName()+"님");
//
//		loginService.insertCustomer(param);
//
//		mciResponse.set("member",param);
//		mciResponse.setViewName("join_member_proc");
//	}

}
