package jcf.edu.tweet.service;

import java.util.List;

import jcf.edu.tweet.model.FollowingVO;
import jcf.edu.tweet.model.TweetVO;
import jcf.edu.user.model.UserVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {

	@Autowired
	private QueryExecutor executor;

	public List<UserVO> getUsers(UserVO user){
		return executor.queryForList("user.follower", user, UserVO.class);
	}

	public List<FollowingVO> follwerUsers(UserVO userVO){
		return executor.queryForList("twitter.followerList", userVO, FollowingVO.class);
	}

	public void insertFollower(FollowingVO followingVO){
		executor.update("twitter.insertFollower", followingVO);
	}

	public void deleteFollower(FollowingVO followingVO){
		executor.update("twitter.deleteFollower", followingVO);
	}

	public void insertTweet(TweetVO tweetVO){
		executor.update("twitter.insertTweet", tweetVO);
	}

	public List<TweetVO> selectTweet(UserVO userVO){
		return executor.queryForList("twitter.selectTweets", userVO, TweetVO.class);
	}

	public void deleteTweet(TweetVO tweetVO){
		executor.update("twitter.deleteTweet", tweetVO);
	}

}
