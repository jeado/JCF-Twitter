package jcf.edu.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.user.model.TweetVO;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.TweetService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml","classpath:config/servletContext.xml"})
public class TwiiterTest {
	private TweetVO t;
	@Autowired
	private TweetService tweetService;
	
	@Before
	public void 셋업() {
		t=new TweetVO();
		t.setRegister("asdf");
		t.setTweets("테스트2");
			
	}
	
	
	@Test
	public void 입력_테스트() {
		tweetService.insertTweet(t);
		
	}

	
		
	

}
