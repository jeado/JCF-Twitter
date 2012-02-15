import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private UserVO userVO;

	@Autowired
	private UserService userService;

	@Before
	public void 셋업(){
		userVO = new UserVO();
		userVO.setUserEmail("aaaaa@msn.com");
		userVO.setUserId("aaaaa");
		userVO.setUserName("성수민");
	}

	@Test
	public void 고객_조회테스트(){
		Map<String, String> map = new HashMap<String, String> ();
		map.put("user_id", "andycloudy");
		List <UserVO> allUser = userService.getUser(map);
		System.out.println("-----------고객 정보 조회 -----------------");
		System.out.println(allUser);
	for (UserVO u: allUser){
		System.out.println(u.getUserEmail());
		}

	}

}
