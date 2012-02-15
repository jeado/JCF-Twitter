package jcf.edu.user.controller;

import java.util.List;
import java.util.Map;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.user.model.PicVO;
import jcf.edu.user.model.UserVO;
import jcf.edu.user.service.UserService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;
import jcf.upload.FileInfo;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	private UserService userService;



	@RequestMapping("login")
	public void showLoginView(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("login");
	}

	@RequestMapping("loginHandle")
	public void login(MciRequest mciRequest, MciResponse mciResponse){
		String param = mciRequest.getParam("userId");
		UserVO user = new UserVO();
		user.setUserId(param);

		List<UserVO> findUsers = userService.loginUser(user);
		if(!findUsers.isEmpty()){
			SessionUtil.addUser(findUsers.get(0));
			mciResponse.setViewName("redirect:/tweet");
		}
		else
			mciResponse.setViewName("redirect:/login");
	}

	@RequestMapping("/user/findUsers")
	public void findUsers(MciRequest mciRequest, MciResponse mciResponse){

		List<UserVO> findUsers = userService.findUsers(null);

		mciResponse.setList("userList", findUsers,UserVO.class);
		mciResponse.setViewName("user/userList");

	}

	@RequestMapping("/user/findUsers2")
	public void findUser2(MciRequest mciRequest, MciResponse mciResponse){
		String userId = mciRequest.getParam("userId");
		String userName = mciRequest.getParam("userName");

		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setUserName(userName);

		List<UserVO> findUsers = userService.findUsers(user);

		mciResponse.setList("userList", findUsers,UserVO.class);
		mciResponse.setViewName("user/userList");
	}

	@RequestMapping("/user/info/{userId}")
	public void info(MciRequest mciRequest, MciResponse mciResponse,@PathVariable String userId){
		UserVO user = new UserVO();
		user.setUserId(userId);

		List<UserVO> findUsers = userService.findUsers(user);
		mciResponse.set("user", findUsers.get(0),UserVO.class);
		mciResponse.setViewName("user/userDetail");
	}


	@RequestMapping("/user/deleteUser")
	public void deleteUser(MciRequest mciRequest, MciResponse mciResponse){
		String userId = mciRequest.getParam("userId");
		UserVO user = new UserVO();
		user.setUserId(userId);

		userService.deleteUser(user);

		mciResponse.setViewName("redirect:/user/findUsers");
	}


	@RequestMapping("/user/updateUser")
	public void updateUser(MciRequest mciRequest, MciResponse mciResponse){
		UserVO user = new UserVO(mciRequest.getParam("userId"),
				mciRequest.getParam("userName"),mciRequest.getParam("userEmail"));
		userService.updateUser(user);

		mciResponse.setViewName("redirect:/user/findUsers");
	}

	@RequestMapping("/user/create.action")
	public void showUserRegView(MciRequest mciRequest, MciResponse mciResponse){
		mciResponse.setViewName("user/userReg");
	}

	@RequestMapping("/user/insertUser")
	public void insertUser(MciRequest mciRequest, MciResponse mciResponse){
		Map param = mciRequest.getParam();

		userService.insertUser(param);
		mciResponse.setViewName("redirect:/user/findUsers");
	}

	@RequestMapping("file/fileView/{userId}")
	public void selectPic(MciRequest mciRequest, MciResponse mciResponse,@PathVariable String userId){
		PicVO picVO = new PicVO();
		picVO.setUserId(userId);
		List<PicVO> selectPic = userService.selectPic(picVO);
		if(!selectPic.isEmpty())
			mciResponse.setDownloadFile(new FileInfo(selectPic.get(0).getFilePath(), selectPic.get(0).getFileUuid()));
	}



}
