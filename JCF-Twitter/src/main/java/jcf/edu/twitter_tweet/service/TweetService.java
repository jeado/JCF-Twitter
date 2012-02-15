package jcf.edu.twitter_tweet.service;

import java.util.List;
import java.util.Map;

import jcf.edu.twitter_tweet.model.TweetVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

	@Autowired
	private QueryExecutor excutor;

	public List<TweetVO> getAllTweet(Map<String, String> map){
		return excutor.queryForList("tweet.select", map, TweetVO.class);
	}

	public void insertTweet(TweetVO tweetvo){
		excutor.update("tweet.insert", tweetvo);
	}

	public void deleteTweet(TweetVO tweetvo){
		excutor.update("tweet.delete", tweetvo);
	}

}
