package jcf.edu.login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jcf.edu.twitter_tweet.model.TweetVO;
import jcf.edu.twitter_tweet.service.TweetService;
import jcf.edu.twitter_user_following.model.FollowingVO;
import jcf.edu.twitter_user_following.service.FollowingService;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;
import jcf.edu.login.service.LoginService;
import jcf.edu.login.util.SessionUtil;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private FollowingService followingService;
	@Autowired
	private TweetService tweetService;

	@RequestMapping("login")
	public void showLoginView(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("login");
	}

	@RequestMapping("loginHandle")
	public void loginHandle(MciRequest mciRequest, MciResponse mciResponse){
		String isId = mciRequest.getParam("userId");
//		System.out.println("isID : " + isId);

		if(!isId.isEmpty()){
			Map param = mciRequest.getParam();
			List<UserVO> findUser = userService.findUser(param);
//			List<UserVO> getAllUser = userService.getAllUser();
			if(!findUser.isEmpty()){
				SessionUtil.addUser(findUser.get(0));

				System.out.println("ID : " + findUser.get(0).getUserId());

				mciResponse.set("loginOK", findUser.get(0),UserVO.class);
//				mciResponse.setList("userList", findUser, UserVO.class);
//				mciResponse.setList("userList", getAllUser);
				mciResponse.setViewName("redirect:tweet");
			}
			else{
				mciResponse.set("loginFailed", "failed");
				mciResponse.setViewName("redirect:login");
			}

		}else{
			System.out.println("아뒤좀 넣고 로그인해줘라잉");
			mciResponse.setViewName("redirect:login");
		}

	}

	@RequestMapping("tweet")
	public void showTweetView(MciRequest mciRequest, MciResponse mciResponse){
		System.out.println("나 tweet 매핑");

		try{
			String crntUserId = SessionUtil.getCurrentUser().getUserId();
			System.out.println("crntUserId : " + crntUserId);
			Map param2 = new HashMap();
			param2.put("userId", crntUserId);

			List<UserVO> getAllUser = userService.getAllFollowerUser(param2);

			List<FollowingVO>findFollower = followingService.findFollower(param2);

			List<TweetVO>getAllTweet = tweetService.getAllTweet(param2);

			String uid = null;

			try{
				uid = SessionUtil.getCurrentUser().getUserId();
				System.out.println("로그인한 상태다잉 : "+ uid);

				mciResponse.setList("tweetList", getAllTweet);
				mciResponse.setList("followingList", findFollower);
				mciResponse.setList("userList", getAllUser);
				mciResponse.set("currentUser", SessionUtil.getCurrentUser());
				mciResponse.setViewName("twitter");
			}catch (Exception e1){
				System.out.println("로긴부터 해라잉~1");
				mciResponse.setViewName("login");
			}
		}catch (Exception e2){
			System.out.println("로긴부터 해라잉~2");
			mciResponse.setViewName("redirect:login");
		}
	}

}
