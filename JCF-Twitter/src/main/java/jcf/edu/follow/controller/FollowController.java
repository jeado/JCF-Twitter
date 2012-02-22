package jcf.edu.follow.controller;

import jcf.edu.follow.model.FollowVO;
import jcf.edu.follow.service.FollowService;
import jcf.edu.login.util.SessionUtil;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FollowController {

	@Autowired
	private FollowService followService;

	//팔로우
	@RequestMapping("follow")
	public void follow(MciRequest mciRequest, MciResponse mciResponse) {

		String param2 = mciRequest.getParam("id");//follow아이디
		FollowVO param = new FollowVO(SessionUtil.getCurrentUser().getUserId(), param2);

		followService.insertFollow(param);
		mciResponse.setViewName("redirect:/tweet");


	}

}
