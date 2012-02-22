package jcf.edu.user.controller;

import java.util.List;
import java.util.Map;

import jcf.edu.user.model.UserVO;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.web.bind.annotation.RequestMapping;

public class TwitterController {

	@SuppressWarnings("unchecked")
	@RequestMapping("/twitter")
	public void twitter(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> t = usersService.findUsers(param);
		mciResponse.setList("userList", findUsers);
		mciResponse.setViewName("user/userList");


	}
}
