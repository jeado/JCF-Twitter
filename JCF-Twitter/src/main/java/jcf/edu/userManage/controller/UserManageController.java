package jcf.edu.userManage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;
import jcf.edu.userManage.service.UserManageService;

@Controller
public class UserManageController {

	@Autowired
	private UserService userService;

	@RequestMapping("user/findUsers")
	public void showManageView(MciRequest mciRequest, MciResponse mciResponse) {
		mciResponse.setViewName("user/userList");
	}

	 @SuppressWarnings("unchecked")
	 @RequestMapping("user/findUsers2")
	 public void findCustomer(MciRequest mciRequest, MciResponse mciResponse){
		 Map param = mciRequest.getParam();
		 List<UserVO> findCustomer = userService.findUser(param);
		 mciResponse.setList("userList", findCustomer, UserVO.class);
		 mciResponse.setViewName("user/userList");
	 }

	 @RequestMapping("user/info/{userId}")
	 public void info(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId){
		 Map param2 = new HashMap();
		 param2.put("userId", userId);
		 List<UserVO> findCustomer = userService.findUser(param2);

		 mciResponse.set("user", findCustomer.get(0), UserVO.class);
		 mciResponse.setViewName("user/userDetail");
	 }

	 @RequestMapping("user/updateUser")
	 public void updateUser(MciRequest mciRequest, MciResponse mciResponse){
		 UserVO param = mciRequest.getParam(UserVO.class);
		 userService.updateUser(param);
		 mciResponse.setViewName("redirect:/user/findUsers");
	 }

	 @RequestMapping("user/deleteUser")
	 public void deleteUser(MciRequest mciRequest, MciResponse mciResponse){
		 UserVO param = mciRequest.getParam(UserVO.class);
		 userService.deleteUser(param);
		 mciResponse.setViewName("redirect:/user/findUsers");
	 }

	 @RequestMapping("user/create.action")
	 public void crateUser(MciRequest mciRequest, MciResponse mciResponse){
		 mciResponse.setViewName("user/userReg");
	 }

	 @RequestMapping("user/insertUser")
	 public void joinMember(MciRequest mciRequest, MciResponse mciResponse){
		 UserVO param = mciRequest.getParam(UserVO.class);

		 userService.insertUser(param);

		 mciResponse.set("user",param);
		 mciResponse.setViewName("redirect:/user/findUsers");
	 }
}
