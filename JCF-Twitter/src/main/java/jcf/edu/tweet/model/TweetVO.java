package jcf.edu.tweet.model;

import java.util.Date;

public class TweetVO {
	private String id;
	private String register;
	private String tweets;
	private String regDate;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getTweets() {
		return tweets;
	}
	public void setTweets(String tweets) {
		this.tweets = tweets;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
