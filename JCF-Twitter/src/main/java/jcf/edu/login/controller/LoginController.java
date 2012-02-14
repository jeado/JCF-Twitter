package jcf.edu.login.controller;

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
public class LoginController {

	@Autowired
	private LoginService LoginService;

	@RequestMapping("login")
	public void showJoinView(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("login");
	}

//	@SuppressWarnings("unchecked")
//	@RequestMapping("findCustomer")
//	public void findCustomer(MciRequest mciRequest, MciResponse mciResponse){
//		Map param = mciRequest.getParam();
//		List<Customer> findCustomer = customerService.findCustomer(param);
//		mciResponse.setList("pp", findCustomer, Customer.class);
//		mciResponse.setViewName("customer_list");
//	}
//

}
