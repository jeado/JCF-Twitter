package jcf.edu.tweet.service;

import java.util.List;
import java.util.Map;

import jcf.edu.tweet.model.TweetVO;
import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

	@Autowired
	private QueryExecutor dao;

	public void insertTweet(TweetVO param) {
		//System.out.println("SERVICE TEST ______"+param);
		dao.update("tweet.insert", param);
	}

	public List<TweetVO> getTweet(TweetVO param) {
		//System.out.println("SERVICE GET TWEET TEST ______"+param);
		return dao.queryForList("tweet.find", param, TweetVO.class);
	}

	public void deleteTweet(TweetVO param) {
		dao.update("tweet.delete", param);
	}

}
