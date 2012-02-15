package jcf.edu.follow.controller;

import java.util.List;

import jcf.edu.follow.model.FollowVO;
import jcf.edu.follow.service.FollowService;
import jcf.edu.login.util.SessionUtil;
import jcf.edu.tweet.model.TweetVO;
import jcf.edu.tweet.service.TweetService;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FollowController {

	@Autowired
	FollowService followService;

	@Autowired
	TweetService tweetService;

	@Autowired
	UserService userService;

	@RequestMapping("/follow")
	public void followUser (MciRequest mciRequest, MciResponse mciResponse){
		String followingId = mciRequest.getParam("id");
		String userId = SessionUtil.getCurrentUser().getUserId();

		FollowVO follow = new FollowVO();
		follow.setFollowingId(followingId);
		follow.setUserId(userId);

		followService.insertFollow(follow);

		mciResponse.set("currentUser", SessionUtil.getCurrentUser());

		List<FollowVO> followList = followService.getFollows(follow);
		mciResponse.set("followList", followList);

		//List<TweetVO> tweet = mciRequest.getParam("tweetList");
		//mciResponse.setList("tweetList", tweet, TweetVO.class);

		List<UserVO> userList = userService.getUserList(SessionUtil.getCurrentUser());
		mciResponse.setList("userList", userList, UserVO.class);

		mciResponse.setViewName("twitter");
	}
}
