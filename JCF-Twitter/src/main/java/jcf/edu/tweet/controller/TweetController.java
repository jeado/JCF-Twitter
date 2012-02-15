package jcf.edu.tweet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TweetController {
	@Autowired
	TweetService tweetService;

	@Autowired
	UserService userService;

	@Autowired
	FollowService followService;


//-----------------------------------------트위터 페이지 열람 ---------------------------------
	@RequestMapping ("tweet")
	public void tweetRedirect (MciRequest mciRequest, MciResponse mciResponse){

		if ((SessionUtil.getCurrentUser())==null){
			System.out.println("세션이 없어요");
			mciResponse.setViewName("login");
		}else{
			TweetVO tweet = new TweetVO();
			tweet.setTweets(mciRequest.getParam("tweets"));
			tweet.setRegister(SessionUtil.getCurrentUser().getUserId());

			FollowVO follow = new FollowVO();
			follow.setUserId(SessionUtil.getCurrentUser().getUserId());
			mciResponse.set("currentUser", SessionUtil.getCurrentUser());

			List<TweetVO> tweetList = tweetService.getTweet(tweet);
			List<UserVO> userList = userService.getUserList(SessionUtil.getCurrentUser());
			List<FollowVO> followList = followService.getFollows(follow);

			System.out.println("--------FOLLOW LIST----------"+followList);
			mciResponse.setList("followingList", followList, FollowVO.class);
			mciResponse.setList("userList", userList, UserVO.class);
			mciResponse.setList("tweetList", tweetList, TweetVO.class);
			mciResponse.setViewName("twitter");
		}
	}

//-----------------------------------------트위터 게시물 등록 ---------------------------------
	@RequestMapping ("tweet/insert")
	public void insertTweet (MciRequest mciRequest, MciResponse mciResponse){
		TweetVO param = mciRequest.getParam(TweetVO.class);
		param.setRegister(SessionUtil.getCurrentUser().getUserId());
		mciResponse.set("currentUser", SessionUtil.getCurrentUser());
		tweetService.insertTweet(param);
		List<TweetVO> tweet = tweetService.getTweet(param);
		List<UserVO> userList = userService.getUserList(SessionUtil.getCurrentUser());
		mciResponse.setList("userList", userList, UserVO.class);
		mciResponse.setList("tweetList", tweet, TweetVO.class);
		mciResponse.setViewName("redirect:/tweet");
	}

//-----------------------------------------트위터 게시물 삭제 ---------------------------------
	@RequestMapping ("tweet/delete")
	public void deleteTweet (MciRequest mciRequest, MciResponse mciResponse){
		TweetVO param = mciRequest.getParam(TweetVO.class);
		String id = mciRequest.getParam("id");
		param.setId(id);
		tweetService.deleteTweet(param);


		param.setRegister(SessionUtil.getCurrentUser().getUserId());
		mciResponse.set("currentUser", SessionUtil.getCurrentUser());

		List<TweetVO> tweetList =  tweetService.getTweet(param);
		List<UserVO> userList = userService.getUserList(SessionUtil.getCurrentUser());

		mciResponse.setList("userList", userList, UserVO.class);
		mciResponse.setList("tweetList", tweetList, TweetVO.class);
		mciResponse.setViewName("redirect:/tweet");
	}
}
