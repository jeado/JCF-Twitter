import java.util.List;
import jcf.edu.user.model.FollowingVO;
import jcf.edu.user.model.PicVO;
import jcf.edu.user.service.FollowingService;
import jcf.edu.user.service.PicService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml", "classpath:config/servletContext.xml"})

public class PicTest {
	
	private PicVO p;
	
	@Autowired
	private PicService picService;
	
	@Before
	public void 셋업(){		
		p = new PicVO();
		p.setFileName("aa");
		p.setFilePath("aa");
		p.setFileUuid("aa");
		p.setUserId("aa");
	}
	
	@Test	
	public void 조회(){
		PicVO pic = new PicVO();
		
		pic.setUserId("aa");
		
		List<PicVO> allPic = picService.getAllPic(pic);		
		for(PicVO p: allPic){
			System.out.println(p.getFileName());					
		}
	}
	
	@Test
	public void 삽입(){
		
		picService.insertPic(p);
	}
	
	@Test
	public void 삭제(){		
		picService.deletePic(p);		
	}
}
;