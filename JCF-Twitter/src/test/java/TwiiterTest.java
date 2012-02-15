import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.tweet.model.FollowingVO;
import jcf.edu.tweet.model.TweetVO;
import jcf.edu.tweet.service.TwitterService;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml","classpath:config/servletContext.xml"})
public class TwiiterTest {

	private UserVO user;

	@Autowired
	private UserService userService;

	@Autowired
	private TwitterService twitterService;

	@Before
	public void 셋업(){
		user = new UserVO();
		user.setUserId("yuni");
		user.setUserEmail("yuni@naver.com");
		user.setUserName("yunhee");
	}

	@Test
	public void 회원조회테스트(){
		List<UserVO> findUsers = userService.findUsers(null);

		if(findUsers.isEmpty()){
			System.out.println("empty");
		}else{

			for (UserVO userVO : findUsers) {
				System.out.println(userVO.getUserId());
			}
		}

	}

	@Test
	public void 로그인테스트(){
		UserVO user = new UserVO();
		user.setUserId("hihihihi");

		List<UserVO> findUsers = userService.loginUser(user);
		if(findUsers.isEmpty())
			System.out.println("null");
		else
			System.out.println("not null");
	}

	@Test
	public void 수정테스트(){

		userService.updateUser(user);


	}

	@Test
	public void 트윗테스트(){
		List<TweetVO> selectTweet = twitterService.selectTweet(user);

		for (TweetVO tweetVO : selectTweet) {
			System.out.println(tweetVO.getId());
		}
	}



}
