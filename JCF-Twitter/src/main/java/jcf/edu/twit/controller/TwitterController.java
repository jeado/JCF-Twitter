package jcf.edu.twit.controller;

import java.util.List;
import java.util.Map;

import jcf.edu.user.model.UserVO;
import jcf.edu.twit.service.TwitterService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwitterController {

	@Autowired
	private TwitterService twitService;

	//트위터 페이지
	@RequestMapping("/tweet")
	public void twitter(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> findUsers = twitService.findUsers(param);
		mciResponse.setList("userList", findUsers);

		mciResponse.setViewName("twitter");

	}

	//리스트 삽입
	@RequestMapping("/tweet/insert")
	public void twitList(MciRequest mciRequest, MciResponse mciResponse) {
		Map param = mciRequest.getParam();
		List<UserVO> tList = twitService.getAllProduct();

		mciResponse.setList("tweetList", tList);
		mciResponse.setViewName("redirect:/tweet");
	}
}
