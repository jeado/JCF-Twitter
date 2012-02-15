import java.util.List;

import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml","classpath:config/servletContext.xml"})
public class TwiiterTest {
	@Autowired
	private UserService userService;

	@Test
	public void 구동테스트() {
		System.out.println("구동되나?");
	}


	@Test
	public void 조회테스트(){
		UserVO user = new UserVO();
	//	user.setUserId("devilston");

		List<UserVO> list = userService.getUser(user);
		for (UserVO u : list) {
			System.out.println(u.toString());
		}
	}
}
