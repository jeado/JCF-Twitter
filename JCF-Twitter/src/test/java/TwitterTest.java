import java.util.Date;
import java.util.List;

import jcf.edu.manage.model.TweetVO;
import jcf.edu.manage.service.TweetService;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml", "classpath:config/servletContext.xml"})
public class TwitterTest {

	
	private TweetVO t;
	
	@Autowired	
	private TweetService tweetService;
	
	@Before
	public void 셋업(){
		
		Date date = new Date();
		t = new TweetVO();		
		t.setRegDate(date);
		t.setTweets("dfdf");
		t.setRegister("12334");
	}
	
	@Test
	public void 트윗글_삽입(){		
		tweetService.insertTweet(t);		
	}	
	
}
