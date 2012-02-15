package jcf.edu.twitter_user_following.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.login.util.SessionUtil;

import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jcf.edu.twitter_user_following.model.FollowingVO;
import jcf.edu.twitter_user_following.service.FollowingService;
import jcf.edu.user.service.UserService;
import jcf.edu.userManage.service.UserManageService;

@Controller
public class FollowingController {

	@Autowired
	private FollowingService followingService;

	 @RequestMapping("follow")
	 public void follow(MciRequest mciRequest, MciResponse mciResponse){
		 String followId = mciRequest.getParam("id");
		 String crntUser = SessionUtil.getCurrentUser().getUserId();

		 FollowingVO followingvo = new FollowingVO(crntUser, followId);

		 followingService.insertFollower(followingvo);

		 mciResponse.setViewName("redirect:tweet");
	 }

	 @RequestMapping("unfollow")
	 public void unfollow(MciRequest mciRequest, MciResponse mciResponse){
		 String followId = mciRequest.getParam("id");
		 String crntUser = SessionUtil.getCurrentUser().getUserId();

		 FollowingVO followingvo = new FollowingVO(crntUser, followId);

		 followingService.deleteFollower(followingvo);

		 mciResponse.setViewName("redirect:tweet");
	 }
}
