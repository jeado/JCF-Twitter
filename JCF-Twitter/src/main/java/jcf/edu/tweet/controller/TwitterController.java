package jcf.edu.tweet.controller;

import java.util.List;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.tweet.model.FollowingVO;
import jcf.edu.tweet.model.TweetVO;
import jcf.edu.tweet.service.TwitterService;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwitterController {

	@Autowired
	private TwitterService twitterService;

	@RequestMapping("tweet")
	public void showLoginView(MciRequest mciRequest, MciResponse mciResponse){

		UserVO current = SessionUtil.getCurrentUser();
		if(current==null){
			mciResponse.setViewName("redirect:/login");
		}
		else{
			List<UserVO> getUser = twitterService.getUsers(current);
			List<FollowingVO> follwerUsers = twitterService.follwerUsers(current);
			List<TweetVO> selectTweet = twitterService.selectTweet(current);

			mciResponse.setList("tweetList",selectTweet,TweetVO.class);
			mciResponse.setList("followingList", follwerUsers,FollowingVO.class);
			mciResponse.setList("userList", getUser,UserVO.class);
			mciResponse.set("currentUser",current,UserVO.class);
			mciResponse.setViewName("twitter");
		}
	}

	@RequestMapping("follow")
	public void followUser(MciRequest mciRequest, MciResponse mciResponse){
		String param = mciRequest.getParam("id");
		FollowingVO follow = new FollowingVO(SessionUtil.getCurrentUser().getUserId(),param);

		twitterService.insertFollower(follow);
		mciResponse.setViewName("redirect:/tweet");
	}

	@RequestMapping("unfollow")
	public void unfollowUser(MciRequest mciRequest, MciResponse mciResponse){
		String param = mciRequest.getParam("id");
		FollowingVO follow = new FollowingVO(SessionUtil.getCurrentUser().getUserId(),param);

		twitterService.deleteFollower(follow);
		mciResponse.setViewName("redirect:/tweet");
	}

	@RequestMapping("tweet/insert")
	public void insertTweet(MciRequest mciRequest, MciResponse mciResponse){
		TweetVO tweetVO = new TweetVO();
		tweetVO.setRegister(SessionUtil.getCurrentUser().getUserId());
		tweetVO.setTweets(mciRequest.getParam("tweets"));

		twitterService.insertTweet(tweetVO);
		mciResponse.setViewName("redirect:/tweet");
	}

	@RequestMapping("tweet/delete")
	public void deleteTweet(MciRequest mciRequest, MciResponse mciResponse){
		int param = Integer.parseInt(mciRequest.getParam("id"));
		TweetVO tweetVO = new TweetVO();
		tweetVO.setId(param);

		twitterService.deleteTweet(tweetVO);
		mciResponse.setViewName("redirect:/tweet");

	}


}
