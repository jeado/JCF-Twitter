package jcf.edu.tweet.service;

import jcf.query.core.QueryExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

	@Autowired
	private QueryExecutor dao;

}
