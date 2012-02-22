package jcf.edu.user.controller;

import java.util.List;
import java.util.Map;

import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UsersService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	private List<UserVO> findUsers;

	@RequestMapping("/user/create.action")
	public void showJoinView(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("/user/userReg");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/user/findUsers")
	public void findUsers(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> findUsers = usersService.findUsers(param);
		mciResponse.setList("userList", findUsers);
		mciResponse.setViewName("user/userList");

	}
	@RequestMapping("/user/insertUser")
	public void joinMember(MciRequest mciRequest, MciResponse mciResponse){

		//Map<String, Object> param = mciRequest.getParam();
		UserVO param = mciRequest.getParam(UserVO.class);
		System.out.println("환영합니다. : " +param.getUserName());

		usersService.insertUsers(param);



		mciResponse.setViewName("redirect:/user/findUsers");

	}
	//상세페이지
	@SuppressWarnings("unchecked")
	@RequestMapping("/user/info/{userId}")
	public void info(MciRequest mciRequest, MciResponse mciResponse, @PathVariable String userId ){
		int index = 0;
		Map param = mciRequest.getParam();
		findUsers = usersService.findUsers(param);
		for(int i =0; i< findUsers.size(); i++)
		{
			if(findUsers.get(i).getUserId().equals(userId))
			{
				index = i;
			}
		}
		mciResponse.set("user", findUsers.get(index));
		mciResponse.setViewName("user/userDetail");
	}
	//수정
	@RequestMapping("/user/updateUser")
	public void infoUpdate(MciRequest mciRequest, MciResponse mciResponse){

		UserVO param = mciRequest.getParam(UserVO.class);
		usersService.updateUsers(param);
		mciResponse.setViewName("redirect:/user/findUsers");
	}
	//삭제
	@RequestMapping("/user/deleteUser")
	public void infoDelete(MciRequest mciRequest, MciResponse mciResponse){

		UserVO param = mciRequest.getParam(UserVO.class);
		usersService.deleteUsers(param);
		mciResponse.setViewName("redirect:/user/findUsers");
	}

	//검색
	@SuppressWarnings("unchecked")
	@RequestMapping("/user/findUsers2")
	public void search(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> findUsers = usersService.findUsers(param);

		mciResponse.setList("userList", findUsers);
		mciResponse.setViewName("/user/userList");
	}

	//로그인
	@SuppressWarnings("unchecked")
	@RequestMapping("/login")
	public void login(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();
		List<UserVO> findUsers = usersService.findUsers(param);
		mciResponse.setList("userList", findUsers);
		mciResponse.setViewName("login");

	}

	//입장
		@SuppressWarnings("unchecked")
		@RequestMapping("/loginHandle")
		public void entered(MciRequest mciRequest, MciResponse mciResponse){

			Map param = mciRequest.getParam();
			List<UserVO> findUsers = usersService.findUsers(param);


			if(!findUsers.isEmpty())
			{
					mciResponse.setViewName("redirect:/tweet");
			}
			else
			{
					mciResponse.setViewName("redirect:/login");
			}

		}


	//이미지 보기
	@RequestMapping("showMeFile")
	public void show(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("fileView");
	}

}