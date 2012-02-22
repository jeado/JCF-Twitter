package jcf.edu.twit.controller;

import java.util.List;
import java.util.Map;

import jcf.edu.follow.model.FollowVO;
import jcf.edu.follow.service.FollowService;
import jcf.edu.login.util.SessionUtil;
import jcf.edu.twit.model.TwitVO;
import jcf.edu.twit.service.TwitterService;
import jcf.edu.user.model.UserVO;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwitterController {

	@Autowired
	private TwitterService twitService;
	@Autowired
	private FollowService followService;

	//트위터 페이지
	@RequestMapping("/tweet")
	public void twitter(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> findUsers = twitService.findUsers(param);
		mciResponse.setList("userList", findUsers);

		List<FollowVO> followUsers = followService.getAllProduct();
		mciResponse.setList("followingList", followUsers);

		UserVO userVO = new UserVO();
		userVO.setUserId(SessionUtil.getCurrentUser().getUserId());
		List<TwitVO> total = twitService.tweetList(userVO);
		mciResponse.setList("tweetList", total);


		mciResponse.setViewName("twitter");

	}

	//리스트 삽입
	@RequestMapping("/tweet/insert")
	public void insertTwit(MciRequest mciRequest, MciResponse mciResponse) {
		String param2 = mciRequest.getParam("tweets");
		TwitVO param = new TwitVO();
		param.setTweets(param2);
		param.setRegister(SessionUtil.getCurrentUser().getUserId());

		twitService.insertTwit(param);
		mciResponse.setViewName("redirect:/tweet");


	}

}
