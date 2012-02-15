package jcf.edu.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.user.model.PicVO;

import jcf.edu.user.service.PicService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml","classpath:config/servletContext.xml"})
public class PicTest {

	private PicVO p;
	
	@Autowired
	private PicService picService;
	@Test
	public void 사진_검색테스트() {
		Map<String, String> map= new HashMap<String, String>();
		map.put("userId", "abcd");
		List<PicVO> findCustomer = picService.findPicture(map);
		
		for(PicVO c : findCustomer) {
			System.out.println(c.getFileName());
		}
	}
}
