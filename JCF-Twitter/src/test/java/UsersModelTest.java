import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.follow.model.FollowVO;
import jcf.edu.follow.service.FollowService;
import jcf.edu.twit.model.TwitVO;
import jcf.edu.twit.service.TwitterService;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UsersService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml","classpath:config/servletContext.xml"})
public class UsersModelTest {

	private UserVO users;


	@Autowired
	private UsersService usersService;
	@Autowired
	private TwitterService twitService;
	@Autowired
	private FollowService followService;

	 @Before
	 public void 셋업(){
		 users = new UserVO();
		 users.setUserId("0333");
		 users.setUserName("kkkk");
		 users.setUserEmail("kdytajo");
	 }
	 @Test
	 public void 고객_조회테스트(){
		 List<UserVO> allProduct = usersService.getAllProduct();
				 for(UserVO users : allProduct){
					 System.out.println(users.getUserName());
				 }
	 }
	 @Test
	 public void 고객_검색테스트(){

		 Map<String, String> map = new HashMap<String, String>();
		 map.put("id", "아이디");
		 usersService.findUsers(map);
		List<UserVO> findUsers = usersService.findUsers(null);
		for(UserVO users : findUsers)
		{
			System.out.println(users.getUserName());
		}
	 }

	@Test
	 public void 고객_입력테스트(){
		usersService.insertUsers(users);
	 }

	 @Test
	 public void 고객_수정테스트(){
		 usersService.updateUsers(users);
	 }

	 @Test
	 public void 고객_삭제테스트(){
		 usersService.deleteUsers(users);
	 }

	 @Test
	 public void 트윗삽입테스트(){
		 TwitVO twit = new TwitVO();
		 twit.setRegister("sdfsdf");
		 twit.setTweets("sdfsdsdfsfdsdfsfd");
		 twitService.insertTwit(twit);
	 }
	 @Test
	 public void 팔로우테스트(){
		 FollowVO fol = new FollowVO();
		 fol.setUserId("sdfsw4e5dsfgf");
		 fol.setFollowingId("dfsfdsdfsfd");
		 followService.insertFollow(fol);
	 }
	 @Test
	 public void 언팔로우테스트(){
		 FollowVO fol = new FollowVO();
		 fol.setUserId("sdfsdf");
		 fol.setFollowingId("dfsfdsdfsfd");
		 followService.deleteFollow(fol);
	 }


}
