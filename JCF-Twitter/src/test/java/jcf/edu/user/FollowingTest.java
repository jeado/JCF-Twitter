package jcf.edu.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.user.model.FollowingVO;
import jcf.edu.user.service.FollowingService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml","classpath:config/servletContext.xml"})
public class FollowingTest {
	private FollowingVO f;
	
	@Autowired
	private FollowingService followingService;
	
	@Test
	public void 조회테스트() {
		Map<String, String> map= new HashMap<String, String>();
		map.put("userId", "asdf");
		List<FollowingVO> findcustomer2 = followingService.findcustomer(map);
		
		
			for(FollowingVO c : findcustomer2) {
			System.out.println(c.getFollowingId());
		}
	}

}
