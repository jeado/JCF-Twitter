package jcf.edu.user.controller;

import java.util.Date;
import java.util.List;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.model.ExceptionLogin;
import jcf.edu.model.TwitterTweet;
import jcf.edu.model.TwitterUserFollowing;
import jcf.edu.service.FollowingService;
import jcf.edu.service.TweetService;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	// -----------------회원관리페이지------------------------------------
	// 사용자쿼리객체
	@Autowired
	private UserService userService;
	@Autowired
	private TweetService tweetService;
	@Autowired
	private FollowingService followingService;
	
	// 사용자관리페이지
	@RequestMapping("user/findUsers")
	public void userManager(MciRequest mciRequest, MciResponse mciResponse) {

		List<UserVO> list = userService.getUser(null);

		mciResponse.setList("userList", list, UserVO.class);
		mciResponse.setViewName("user/userList");
	}

	// 사용자 검색
	@RequestMapping("user/findUsers2")
	public void userList(MciRequest mciRequest, MciResponse mciResponse) {
		String id = mciRequest.getParam("userId");
		String name = mciRequest.getParam("userName");
		UserVO userVO = new UserVO();
		userVO.setUserId(id);
		userVO.setUserName(name);
		List<UserVO> list = userService.getUser(userVO);
		mciResponse.setList("userList", list, UserVO.class);
		mciResponse.setViewName("user/userList");
	}

	// 사용자등록페이지
	@RequestMapping("user/create.action")
	public void userReg(MciRequest mciRequest, MciResponse mciResponse) {
		mciResponse.setViewName("user/userReg");
	}

	// 회원가입문 --파일미완성
	@RequestMapping("user/insertUser")
	public void insertUser(MciRequest mciRequest, MciResponse mciResponse) {
		UserVO userVo = mciRequest.getParam(UserVO.class);
		userService.insertUser(userVo);
		mciResponse.setViewName("login");
	}

	// ----------------개인 상세정보------------------------------------------------

	// 사용자 상세조회
	@RequestMapping("user/info/{userId}")
	public void userDetail(MciRequest mciRequest, MciResponse mciResponse,
			@PathVariable String userId) {
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		List<UserVO> list = userService.getUser(userVO);
		mciResponse.set("user", list.get(0), UserVO.class);
		mciResponse.setViewName("user/userDetail");
	}

	// 개인정보삭제
	@RequestMapping("user/deleteUser")
	public void userDelete(MciRequest mciRequest, MciResponse mciResponse) {
		UserVO userVO = mciRequest.getParam(UserVO.class);
		if (!userVO.equals(SessionUtil.getCurrentUser())) {
			ExceptionLogin exceptionLogin = new ExceptionLogin("사용자가 아닙니다..");
			mciResponse.set("exception", exceptionLogin, ExceptionLogin.class);
			mciResponse.setViewName("error");
		} else {
			userService.deleteUser(userVO);
			mciResponse.setViewName("user/userList");
		}
	}

	// 개인정보수정
	@RequestMapping("user/updateUser")
	public void userUpdate(MciRequest mciRequest, MciResponse mciResponse) {
		UserVO userVO = mciRequest.getParam(UserVO.class);
		if (!userVO.equals(SessionUtil.getCurrentUser())) {
			ExceptionLogin exceptionLogin = new ExceptionLogin("사용자가 아닙니다..");
			mciResponse.set("exception", exceptionLogin, ExceptionLogin.class);
			mciResponse.setViewName("error");
		} else {
			userService.updateUser(userVO);
			mciResponse.setViewName("user/userList");
		}
	}

	// -------------------로그인페이지----------------------------------
	// 로그인페이지
	@RequestMapping("login")
	public void showLoginView(MciRequest mciRequest, MciResponse mciResponse) {
		mciResponse.setViewName("login");
	}

	// 로그인처리페이지
	@RequestMapping("loginHandle")
	public void loginHandle(MciRequest mciRequest, MciResponse mciResponse) {
		String id = mciRequest.getParam("userId");
		UserVO userVO = new UserVO();
		userVO.setUserId(id);
		List<UserVO> list = userService.getUser(userVO);
		System.out.println(list.size());
		if (list.size() < 1) {
			ExceptionLogin exceptionLogin = new ExceptionLogin("사용자가 없습니다.");
			mciResponse.set("exception", exceptionLogin, ExceptionLogin.class);
			mciResponse.setViewName("error");
		} else {
			SessionUtil.addUser(list.get(0));
			List<TwitterTweet> tweetlist = tweetService.getAllTweet();
			List<UserVO> userList =userService.getUserList(SessionUtil.getCurrentUser());
			mciResponse.set("currentUser", SessionUtil.getCurrentUser(),UserVO.class );
			mciResponse.setList("userList", userList, UserVO.class);
			mciResponse.setList("tweetList", tweetlist, TwitterTweet.class);
			mciResponse.setViewName("twitter");
		}
	}

	// ------------------------트윗페이지--------------------------------
	// 트윗페이지
	@RequestMapping("tweet")
	public void showTweetView(MciRequest mciRequest, MciResponse mciResponse) {
		if (SessionUtil.getCurrentUser() == null){ 
			List<TwitterTweet> tweetlist = tweetService.getAllTweet();
			List<UserVO> userList =userService.getUserList(null);
			mciResponse.setList("userList", userList, UserVO.class);
			mciResponse.setList("tweetList", tweetlist, TwitterTweet.class);
			mciResponse.setViewName("twitter");
		}else{
			List<TwitterTweet> tweetlist = tweetService.getAllTweet();
			List<UserVO> userList =userService.getUserList(SessionUtil.getCurrentUser());
			mciResponse.set("currentUser", SessionUtil.getCurrentUser(),UserVO.class );
			mciResponse.setList("userList", userList, UserVO.class);
			mciResponse.setList("tweetList", tweetlist, TwitterTweet.class);
			mciResponse.setViewName("twitter");
		}
		
	}

	// 트윗글쓰기저장
	@RequestMapping("tweet/insert")
	public void TweetWrite(MciRequest mciRequest, MciResponse mciResponse) {
		TwitterTweet tweet = new TwitterTweet();
		String message = mciRequest.getParam("tweets");
		Date date = new Date();
		tweet.setRegister(SessionUtil.getCurrentUser().getUserId());
		tweet.setTweets(message);
		tweet.setRegDate(date);
		if (SessionUtil.getCurrentUser() == null) {
			ExceptionLogin exceptionLogin = new ExceptionLogin("권한이 없습니다.");
			mciResponse.set("exception", exceptionLogin, ExceptionLogin.class);
			mciResponse.setViewName("error");
		} else {
			tweetService.insertTweet(tweet);
			List<TwitterTweet> tweetlist = tweetService.getAllTweet();
			List<UserVO> userList =userService.getUserList(SessionUtil.getCurrentUser()); 
			//현재사용자정보
			mciResponse.set("currentUser", SessionUtil.getCurrentUser(),UserVO.class );
			//사용자목록
			mciResponse.setList("userList", userList, UserVO.class);
			//팔로워한 트윗글
			mciResponse.setList("tweetList", tweetlist, TwitterTweet.class);
			mciResponse.setViewName("twitter");
		}
	}
	
	//팔로윙
	@RequestMapping("follow/{userId}")
	public void Following(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId) {
	
			//트위터팔로윙
			TwitterUserFollowing twitterUserFollowing = new TwitterUserFollowing();
			twitterUserFollowing.setUserId(SessionUtil.getCurrentUser().getUserId());
			twitterUserFollowing.setFollowingId(userId);
			//현재사용자정보
			followingService.insertFollowing(twitterUserFollowing);
			mciResponse.setViewName("redirect:/tweet");
	
	}
	
	@RequestMapping("unfollow/{userId}")
	public void unFollowing(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId){
		if(SessionUtil.getCurrentUser() == null){
		
		}else{
			//트위터팔로윙
			TwitterUserFollowing twitterUserFollowing = new TwitterUserFollowing();
			twitterUserFollowing.setUserId(SessionUtil.getCurrentUser().getUserId());
			twitterUserFollowing.setFollowingId(userId);
			List<TwitterTweet> tweetlist = tweetService.getAllTweet();
			List<UserVO> userList =userService.getUserList(SessionUtil.getCurrentUser()); 
			followingService.deleteFollowing(twitterUserFollowing);
			
			//현재사용자정보
			mciResponse.set("currentUser", SessionUtil.getCurrentUser(),UserVO.class );
			//사용자목록
			mciResponse.setList("userList", userList, UserVO.class);
			//팔로워한 트윗글
			mciResponse.setList("tweetList", tweetlist, TwitterTweet.class);
			mciResponse.setViewName("twitter");
		}
	}
	
}
