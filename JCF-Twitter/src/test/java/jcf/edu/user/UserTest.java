package jcf.edu.user;

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
public class UserTest {
	private UserVO u;
	@Autowired
	private UserService userservice;
	
	@Before
	public void 셋업() {
		u= new UserVO();
		u.setUserId("gsagas");
		u.setUserName("yrere");
		u.setUserEmail("hfdhjjjk");
	}
	
	@Test
	public void 회원_입력테스트() {
		userservice.insertUser(u);
	}
	@Test
	public void 회원_검색테스트() {
		Map<String, String> map= new HashMap<String, String>();
		map.put("userId", "spike44");
		List<UserVO> findCustomer = userservice.findCustomer(map);
		
		for(UserVO c : findCustomer) {
			System.out.println(c.getUserName());
		}
	}
	@Test
	public void 회원_삭제테스트() {
		userservice.deleteUser(u);
	}

}
