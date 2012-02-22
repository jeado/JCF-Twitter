package jcf.edu.follow.model;

public class FollowVO {

	private String userId;
	private String followingId;

	public FollowVO(String userId, String followingId) {
		super();
		this.userId = userId;
		this.followingId = followingId;
	}

	public FollowVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFollowingId() {
		return followingId;
	}

	public void setFollowingId(String followingId) {
		this.followingId = followingId;
	}



}
