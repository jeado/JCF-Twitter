package jcf.edu.user.controller;

import java.util.Date;
import java.util.List;
import jcf.edu.login.util.SessionUtil;
import jcf.edu.manage.model.TweetVO;
import jcf.edu.manage.service.TweetService;
import jcf.edu.user.model.FollowingVO;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.FollowingService;
import jcf.edu.user.service.UserService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private TweetService tweetService;	

	@Autowired
	private FollowingService followingService;	
	
	
	// 게시글 지우기
	@RequestMapping("/tweet/delete")
	public void deleteBoard(MciRequest mciRequest, MciResponse mciResponse){
		
		int id = Integer.parseInt(mciRequest.getParam("id"));
		TweetVO t = new TweetVO();
		t.setId(id);
		
		tweetService.deleteTweet(t);
		
		mciResponse.setViewName("redirect:/tweet");
	}
	
	
	// 팔로잉
	@RequestMapping("follow")
	public void follow(MciRequest mciRequest, MciResponse mciResponse){
		
		UserVO user1 = SessionUtil.getCurrentUser();
		
		
		FollowingVO f1 = new FollowingVO();
		
		String my_Id = user1.getUserId();   // 내 아이디
		String your_id = mciRequest.getParam("id"); // 니아이디
		
		f1.setUserId(my_Id);
		f1.setFollowingId(your_id);
		
		followingService.insertFollowing(f1);	
		
		
		FollowingVO follower = new FollowingVO();
		follower.setUserId(my_Id);				
		List<FollowingVO> findUser = followingService.findUser(follower);
		mciResponse.setList("followingList", findUser, FollowingVO.class);
		
		mciResponse.setViewName("redirect:/tweet");
	}
	
	
	// 언 팔로잉
	@RequestMapping("unfollow")
	public void unfollow(MciRequest mciRequest, MciResponse mciResponse){
		
		UserVO user1 = SessionUtil.getCurrentUser();		
		
		FollowingVO f1 = new FollowingVO();
		
		String my_Id = user1.getUserId();   // 내 아이디
		String your_id = mciRequest.getParam("id"); // 니아이디
		
		
		f1.setFollowingId(your_id);		
		followingService.deleteCustomer(f1);
		
		
		FollowingVO follower = new FollowingVO();
		follower.setUserId(my_Id);				
		List<FollowingVO> findUser = followingService.findUser(follower);
		mciResponse.setList("followingList", findUser, FollowingVO.class);
		
		mciResponse.setViewName("redirect:/tweet");
	
	}
	
	
	
	//-------------------------------------------------------------------------------//
	// 로그인페이지로
	@RequestMapping("login")
	public void showJoinView(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("login");
	}

	// 로그인하기
	@RequestMapping("loginHandle")
	public void showloginView(MciRequest mciRequest, MciResponse mciResponse){

		UserVO user = new UserVO();
		String id = mciRequest.getParam("userId");
		user.setUserId(id);

		List<UserVO> findUser = userService.findUser2(user);		
		String userId="";

		UserVO user2 = new UserVO();
		for(UserVO u: findUser){
			userId= u.getUserId();
			user2=u;
		}



		if(userId.equals(id)){

			SessionUtil.addUser(user2);
			mciResponse.set("currentUser", user2, UserVO.class);



			// 사용자 세션얻어오기
			UserVO user3 = SessionUtil.getCurrentUser();


			// 나를 제외한 사람들 보여주기
			UserVO user4 = new UserVO();
			user4.setUserId(user.getUserId());
			List<UserVO> allUser = userService.getSomeUser(user4);
			mciResponse.setList("userList", allUser, UserVO.class);		

			
			// 트윗게시글 영역			
			String strId= user.getUserId();
			UserVO user_t = new UserVO();
			user_t.setUserId(strId);			
//			List<TweetVO> board = tweetService.getBoard(tweet);
			List<TweetVO> board = tweetService.getBoard2(user_t);
			mciResponse.setList("tweetList", board, TweetVO.class);
			
			// 팔로잉 쭉 뿌려주기
			String my_Id = user.getUserId();   // 내 아이디
			FollowingVO follower = new FollowingVO();
			follower.setUserId(my_Id);				
			List<FollowingVO> findUser1 = followingService.findUser(follower);
			mciResponse.setList("followingList", findUser1, FollowingVO.class);

			mciResponse.set("currentUser", user, UserVO.class);
			
			
			mciResponse.setViewName("twitter");

		}else{
			mciResponse.setViewName("login");
		}
	}
	//-------------------------------------------------------------------------------//









	//-------------------------------------------------------------------------------//
	// 트윗페이지
	@RequestMapping("tweet")
	public void tweetPage(MciRequest mciRequest, MciResponse mciResponse){

		if(SessionUtil.getCurrentUser() == null){
			
			mciResponse.setViewName("login");

		}else{
			// 사용자 세션얻어오기
			UserVO user = SessionUtil.getCurrentUser();


			// 나를 제외한 사람들 보여주기
			UserVO user2 = new UserVO();
			user2.setUserId(user.getUserId());
			List<UserVO> allUser = userService.getSomeUser(user2);
			mciResponse.setList("userList", allUser, UserVO.class);
			
			
			// 트윗게시글 영역			
			String strId= user.getUserId();
			UserVO user_t = new UserVO();
			user_t.setUserId(strId);			
//			List<TweetVO> board = tweetService.getBoard(tweet);
			List<TweetVO> board = tweetService.getBoard2(user_t);
			mciResponse.setList("tweetList", board, TweetVO.class);

			
			
			// 팔로잉 쭉 뿌려주기
			String my_Id = user.getUserId();   // 내 아이디
			FollowingVO follower = new FollowingVO();
			follower.setUserId(my_Id);				
			List<FollowingVO> findUser = followingService.findUser(follower);
			mciResponse.setList("followingList", findUser, FollowingVO.class);

			mciResponse.set("currentUser", user, UserVO.class);
			
			
			mciResponse.setViewName("twitter");
			
		}
	}	
	// 트윗글남기기
	@RequestMapping("tweet/insert")
	public void insertTweet(MciRequest mciRequest, MciResponse mciResponse){

		// 달력
		Date date = new Date();		
		// 텍스트 파라미터	 
		String param = mciRequest.getParam("tweets");		
		// 사용자 세션얻어오기
		UserVO user = SessionUtil.getCurrentUser();

		TweetVO tweet = new TweetVO();
		tweet.setTweets(param);
		tweet.setRegister(user.getUserId());
		tweet.setRegDate(date);		
		tweet.setRegDate(date);

		tweetService.insertTweet(tweet);

		// 사용자 세션얻어오기
		UserVO user3 = SessionUtil.getCurrentUser();		

		// 나를 제외한 사람들 보여주기
		UserVO user4 = new UserVO();
		user4.setUserId(user3.getUserId());
		List<UserVO> allUser = userService.getSomeUser(user4);
		mciResponse.setList("userList", allUser, UserVO.class);
		
		
		
		// 트윗게시글 영역			
		String strId= user.getUserId();
		UserVO user_t = new UserVO();
		user_t.setUserId(strId);			
//		List<TweetVO> board = tweetService.getBoard(tweet);
		List<TweetVO> board = tweetService.getBoard2(user_t);
		mciResponse.setList("tweetList", board, TweetVO.class);
		
		

		// 팔로잉 쭉 뿌려주기
		String my_Id = user.getUserId();   // 내 아이디
		FollowingVO follower = new FollowingVO();
		follower.setUserId(my_Id);				
		List<FollowingVO> findUser = followingService.findUser(follower);
		mciResponse.setList("followingList", findUser, FollowingVO.class);

		mciResponse.set("currentUser", user, UserVO.class);
		
		
		
		mciResponse.set("currentUser", user, UserVO.class);
		mciResponse.setViewName("twitter");
	}	
	//-------------------------------------------------------------------------------//
	
	
	
	
	
	
	//-------------------------------------------------------------------------------//
	// 한명의 고객 디테일뷰로 가기
	@RequestMapping("/user/info/{userId}")
	public void info(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId){

		UserVO user = new UserVO();
		user.setUserId(userId);		

		List<UserVO> findUser = userService.findUser2(user);

		for(UserVO u : findUser){
			mciResponse.set("user", u, UserVO.class);
			mciResponse.setViewName("user/userDetail");
		}		
	}	

	@RequestMapping("/user/updateUser")
	public void save(MciRequest mciRequest, MciResponse mciResponse){

		UserVO user = mciRequest.getParam(UserVO.class);		
		userService.updateUser(user);
		mciResponse.setViewName("login");
	}

	@RequestMapping("/user/deleteUser")
	public void delete(MciRequest mciRequest, MciResponse mciResponse){		

		UserVO user = mciRequest.getParam(UserVO.class);		
		userService.deleteUser(user);	
		mciResponse.setViewName("login");
	}

	//-------------------------------------------------------------------------------//


	
	
	
	
	


	//-------------------------------------------------------------------------------//
	// 고객 등록하러 가기
	@RequestMapping("/user/create.action")
	public void showUserListView(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("user/userReg");

	}
	// 고객등록버튼 클릭
	@RequestMapping("user/insertUser")
	public void showInsertUserView(MciRequest mciRequest, MciResponse mciResponse){

		UserVO user = mciRequest.getParam(UserVO.class); 
		userService.insertUser(user);
		mciResponse.setViewName("twitter");

	}
	//-------------------------------------------------------------------------------//



	
	
	

	//-------------------------------------------------------------------------------//
	// 사용자관리정보로 가기
	@RequestMapping("user/findUsers")
	public void showUserView(MciRequest mciRequest, MciResponse mciResponse){

		List<UserVO> allUser =  userService.getAllUser();	
		mciResponse.setList("userList", allUser);
		mciResponse.setViewName("user/userList");		
	}

	// 한명출력
	@RequestMapping("user/findUsers2")
	public void showUser2View(MciRequest mciRequest, MciResponse mciResponse){		

		String id = mciRequest.getParam("userId");
		String name = mciRequest.getParam("userName");

		UserVO user = new UserVO();
		user.setUserId(id);
		user.setUserName(name);

		List<UserVO> findUser = userService.findUser2(user);		
		mciResponse.setList("userList", findUser, UserVO.class);
		mciResponse.setViewName("user/userList");		
	}
	//-------------------------------------------------------------------------------//
}