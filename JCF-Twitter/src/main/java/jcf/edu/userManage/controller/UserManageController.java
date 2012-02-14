package jcf.edu.userManage.controller;

import java.util.List;
import java.util.Map;

import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jcf.edu.user.model.UserVO;
import jcf.edu.userManage.service.UserManageService;

@Controller
public class UserManageController {

	@Autowired
	private UserManageService userManageService;

	@RequestMapping("user/findUsers")
	public void showManageView(MciRequest mciRequest, MciResponse mciResponse) {
		mciResponse.setViewName("user/userList");
	}

	 @SuppressWarnings("unchecked")
	 @RequestMapping("user/findUsers2")
	 public void findCustomer(MciRequest mciRequest, MciResponse mciResponse){
		 Map param = mciRequest.getParam();
		 List<UserVO> findCustomer = userManageService.findCustomer(param);
		 System.out.println("컨트롤러단:findCustomer호출");
		 mciResponse.setList("userList", findCustomer, UserVO.class);
		 mciResponse.setViewName("user/userList");
	 }
	//
	// @RequestMapping("JoinMember")
	// public void joinMember(MciRequest mciRequest, MciResponse mciResponse){
	// Customer param = mciRequest.getParam(Customer.class);
	// System.out.println("환영합니다 " + param.getName()+"님");
	//
	// customerService.insertCustomer(param);
	//
	// mciResponse.set("member",param);
	// mciResponse.setViewName("join_member_proc");
	// }

	 @RequestMapping("loginHandle")
	public void loginHandle(MciRequest mciRequest, MciResponse mciResponse){
		UserVO param = mciRequest.getParam(UserVO.class);
//		System.out.println("환영합니다 " + param.getName()+"님");

//		customerService.insertCustomer(param);

		mciResponse.set("member",param);
		mciResponse.setViewName("join_member_proc");
	}

}
