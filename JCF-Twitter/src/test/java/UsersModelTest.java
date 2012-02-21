import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UsersService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml","classpath:config/servletContext.xml"})
public class UsersModelTest {

	private UserVO users;


	@Autowired
	private UsersService usersService;

	 @Before
	 public void 셋업(){
		 users = new UserVO();
		 users.setUserId("0333");
		 users.setUserName("kkkk");
		 users.setUserEmail("kdytajo");
	 }
	 @Test
	 public void 고객_조회테스트(){
		 List<UserVO> allProduct = usersService.getAllProduct();
				 for(UserVO users : allProduct){
					 System.out.println(users.getUserName());
				 }
	 }
	 @Test
	 public void 고객_검색테스트(){

		 Map<String, String> map = new HashMap<String, String>();
		 map.put("id", "아이디");
		 usersService.findUsers(map);
		List<UserVO> findUsers = usersService.findUsers(null);
		for(UserVO users : findUsers)
		{
			System.out.println(users.getUserName());
		}
	 }

	@Test
	 public void 고객_입력테스트(){
		usersService.insertUsers(users);
	 }

	 @Test
	 public void 고객_수정테스트(){
		 usersService.updateUsers(users);
	 }

	 @Test
	 public void 고객_삭제테스트(){
		 usersService.deleteUsers(users);
	 }


}
