package jcf.edu.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.user.model.FollowingVO;
import jcf.edu.user.model.TweetVO;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.FollowingService;
import jcf.edu.user.service.TweetService;
import jcf.edu.user.service.UserService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TweetController {

	@Autowired
	private TweetService tweetService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private FollowingService followingService;

	@RequestMapping("tweet")
	public void goTweet(MciRequest mciRequest, MciResponse mciResponse) throws RuntimeException{
		if (SessionUtil.getCurrentUser() == null) {
			mciResponse.setViewName("redirect:/login");
		} else {
			UserVO userVO = SessionUtil.getCurrentUser();
			mciResponse.set("currentUser", userVO);
							
			List<UserVO> findCustomer2 = userService.findCustomer2(userVO);
			FollowingVO f = new FollowingVO();
			f.setUserId(userVO.getUserId());
			List<FollowingVO> follwingList = followingService.findcustomer(f);
			List<TweetVO> tweetList = tweetService.selectTweet(f);
			mciResponse.setList("userList", findCustomer2);
			mciResponse.setList("followingList", follwingList);
			mciResponse.setList("tweetList", tweetList);			
			mciResponse.setViewName("twitter");
		}

	}

	@RequestMapping("/tweet/insert")
	public void insertTweet(MciRequest mciRequest, MciResponse mciResponse) {
		TweetVO t = new TweetVO();

		t.setTweets(mciRequest.getParam("tweets"));
		t.setRegister(SessionUtil.getCurrentUser().getUserId());

		tweetService.insertTweet(t);

		mciResponse.setViewName("redirect:/tweet");

	}
	@RequestMapping("/tweet/delete")
	public void deleteTweet(MciRequest mciRequest, MciResponse mciResponse) {
		
		int param = Integer.parseInt(mciRequest.getParam("id"));
		TweetVO tweetVO = new TweetVO();
		tweetVO.setId(param);
		
		tweetService.deleteTweet(tweetVO);
		mciResponse.setViewName("redirect:/tweet");
		
	}


}
