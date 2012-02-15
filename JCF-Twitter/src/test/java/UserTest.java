import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class UserTest {
	
	
	private UserVO u;
	
	@Autowired	
	private UserService userService;
	
	@Before
	public void 셋업(){			
		u = new UserVO();
		u.setUserId("dd");
		u.setUserName("rr");
		u.setUserEmail("appple");	
	}
	
	@Test
	public void 유저조회(){
		List<UserVO> allUser = userService.getAllUser();		
		for(UserVO u: allUser){
			System.out.println(u.getUserId());
			System.out.println(u.getUserName());
			System.out.println(u.getUserEmail());
		}
	}
	
	

//	@Test
//	public void 유저_검색테스트(){		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("user_id", "bbb");		
//		List<UserVO> user = userService.findUser(map);		
//		for(UserVO u : user){
//			System.out.println(u.getUserEmail());
//		}		
//	}

	@Test
	public void 유저_검색테스트2(){
		
		String name="bbb";
		String id="bbb";
		
		UserVO user = new UserVO();
		user.setUserName(name);
		user.setUserId(id);
		
		List<UserVO> allUser = userService.findUser2(user);	
		for(UserVO u: allUser){
			System.out.println(u.getUserId());
			System.out.println(u.getUserName());
			System.out.println(u.getUserEmail());
		}
	}
}