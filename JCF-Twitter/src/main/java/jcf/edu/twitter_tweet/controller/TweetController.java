package jcf.edu.twitter_tweet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.twitter_tweet.model.TweetVO;
import jcf.edu.twitter_tweet.service.TweetService;
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
	private TweetService tweetService;

	@Autowired
	private UserService userService;

	 @RequestMapping("tweet/insert")
	 public void tweetInsert(MciRequest mciRequest, MciResponse mciResponse){
		 String tweetWritting = mciRequest.getParam("tweets");
		 String crntUser = SessionUtil.getCurrentUser().getUserId();

		 TweetVO tweetvo = new TweetVO(crntUser, tweetWritting);

		 tweetService.insertTweet(tweetvo);

		 mciResponse.setViewName("redirect:/tweet");
	 }

	 @RequestMapping("tweet/delete")
	 public void tweetDelete(MciRequest mciRequest, MciResponse mciResponse){
		 TweetVO tweetvo = new TweetVO();
		 int id = Integer.parseInt(mciRequest.getParam("id"));
		 tweetvo.setId(id);
		 System.out.println("tweet/delete/{id} id : " + id);
		 tweetService.deleteTweet(tweetvo);
		 mciResponse.setViewName("redirect:/tweet");
	 }

	 @RequestMapping("tweet/{userId}")
	 public void info(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId){
		 Map param2 = new HashMap();
		 param2.put("userId", userId);

		 String crntUser = SessionUtil.getCurrentUser().getUserId();
		 System.out.println("@Map(user/info/) crntUser : " + crntUser + " userId : " + userId);
		 if(crntUser.equals(userId)){
			 List<UserVO> findCustomer = userService.findUser(param2);

			 mciResponse.set("user", findCustomer.get(0), UserVO.class);
			 mciResponse.setViewName("user/userDetail");
		 }else{
			 mciResponse.setViewName("redirect:/user/findUsers");
		 }
	 }
}
