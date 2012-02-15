package jcf.edu.tweet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


//-----------------------------------------트위터 페이지 열람 ---------------------------------
	@RequestMapping ("tweet")
	public void tweetRedirect (MciRequest mciRequest, MciResponse mciResponse){
		System.out.println("타나?");
		TweetVO param = mciRequest.getParam(TweetVO.class);
		if (SessionUtil.getCurrentUser().getUserId().isEmpty()){
			System.out.println("세션이 없어요");
			mciResponse.setViewName("login");
		}else{
			param.setRegister(SessionUtil.getCurrentUser().getUserId());
			mciResponse.set("currentUser", SessionUtil.getCurrentUser());

			List<TweetVO> tweet = tweetService.getTweet(param);
			List<UserVO> userList = userService.getUserList(SessionUtil.getCurrentUser());
			mciResponse.setList("userList", userList, UserVO.class);
			mciResponse.setList("tweetList", tweet, TweetVO.class);
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
		mciResponse.setViewName("twitter");
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
		mciResponse.setViewName("twitter");
	}
}
