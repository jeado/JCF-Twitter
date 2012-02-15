import java.util.List;
import jcf.edu.user.model.FollowingVO;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.FollowingService;
import jcf.edu.user.service.UserService;

import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml", "classpath:config/servletContext.xml"})

public class FollowingTest {
	
	private FollowingVO f;
	private UserVO u;
	
	@Autowired
	private FollowingService followingService;
	private UserService userService;
	
	@Before
	public void 셋업(){		
		f = new FollowingVO();
		f.setFollowingId("apple");
		f.setUserId("banana");
		
		u = new UserVO();
		u.setUserId("dd");
		u.setUserName("rr");
		u.setUserEmail("appple");
		
		
	}
	
	@Test
	public void 팔로_검색테스트(){	
		
		String id="aaa";
		
		FollowingVO f = new FollowingVO();
		f.setUserId(id);
		
		List<FollowingVO> allUser = followingService.findUser(f);	
		for(FollowingVO ff: allUser){
			
			System.out.println(ff.getFollowingId());
			
		}
	}
	
	
	
	
	@Test	
	public void 조회(){
		List<FollowingVO> allFollower = followingService.getAllFollower();		
		for(FollowingVO f: allFollower){
			System.out.println(f.getUserId());
			System.out.println(f.getFollowingId());
		}
	}
	
	@Test
	public void 유저조회(){		
		List<UserVO> allUser = userService.getAllUser();		
		for(UserVO u: allUser){
			System.out.println(u.getUserId());			
		}
	}
	
	@Test
	public void 삽입(){
		
		followingService.insertFollowing(f);
	}
	
	@Test
	public void 삭제(){		
		followingService.deleteCustomer(f);		
	}
	
	
	
}
;