package jcf.edu.tweet.controller;

import java.util.HashMap;
import java.util.Map;

import jcf.edu.tweet.service.TweetService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TweetController {
	@Autowired
	TweetService tweetService;

	@RequestMapping ("tweet")
	public void tweetRedirect (MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("twitter");
	}
}
