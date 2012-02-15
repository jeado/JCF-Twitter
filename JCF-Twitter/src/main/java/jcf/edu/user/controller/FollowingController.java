package jcf.edu.user.controller;

import jcf.edu.login.util.SessionUtil;
import jcf.edu.user.model.FollowingVO;
import jcf.edu.user.service.FollowingService;
import jcf.sua.mvc.MciRequest;
import jcf.sua.mvc.MciResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FollowingController {
	
	@Autowired
	private FollowingService followingService;
	
	@RequestMapping("follow")
	public void doFollwing(MciRequest mciRequest, MciResponse mciResponse) {
		FollowingVO f = new FollowingVO();
		String userId = SessionUtil.getCurrentUser().getUserId();
		String followingId = mciRequest.getParam("id");
		f.setUserId(userId);
		f.setFollowingId(followingId);
		followingService.following(f);
		mciResponse.setViewName("redirect:/tweet");
	}
	@RequestMapping("unfollow") 
	public void doUnFollowing(MciRequest mciRequest, MciResponse mciResponse) {
		FollowingVO f = new FollowingVO();
		String userId = SessionUtil.getCurrentUser().getUserId();
		String followingId = mciRequest.getParam("id");
		f.setUserId(userId);
		f.setFollowingId(followingId);
		followingService.unfollowing(f);
		mciResponse.setViewName("redirect:/tweet");
		
	}
	
}
