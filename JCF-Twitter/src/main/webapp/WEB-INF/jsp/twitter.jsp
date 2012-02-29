<%@page import="jcf.edu.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome to Twitter</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-responsive.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.min.js"></script>
</head>
<SCRIPT type='text/javascript'>
$(document).ready(function(){
	$('.main-content').height($('.stream-manager').height()+167);
 });
</SCRIPT>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<a class="brand" href="<%=request.getContextPath()%>/login">JCF-Twitter</a>
			<div class="nav-collapse">
				<ul class="nav">
					<li><a class="active" href="<%=request.getContextPath()%>/tweet">트위터</a></li>
					<li><a href="<%=request.getContextPath()%>/user/findUsers">사용자관리</a></li>
					<li><a href="http://about.me/jeado">Contact</a></li>
				</ul>
			</div>
			<div class="active-links">
				<span id="session" class="loggedin js-session"> <a
					class="profile-links" href="#"> <img
						src="<%=request.getContextPath()%>/file/fileView/${currentUser.userId}">
				</a> <span id="screen-name">${currentUser.userName}</span>
				</span>
			</div>
		</div>
	</div>
</div>
<body>
<div id="page-outer">
<div id="page-container" class="page-container  home-container">
<div class="main-content" style="min-height: 396px; ">
	<div class ="page-header home-header">
		<form  name="tweetForm" action="<%=request.getContextPath()%>/tweet/insert" method="post" >
		<div class="tweet-box condensed">
		      <div class="tweet-box-title">
		      		<h2>What’s happening?</h2>
		      </div>
			  <div class="text-area">
			    <div class="text-area-editor twttr-editor"><textarea name="tweets" class="twitter-anywhere-tweet-box-editor" style="width: 482px; height: 56px; "></textarea></div>
			  </div>
		  </div>
		  <input type="submit"  class="btn" value="저장" >
	 	 </form>
	</div>
	<div class="stream-manager js-stream-manager-container">
		<div class="stream-title"><h2>Favorites, follows, retweets, and more by people you follow</h2></div>
		<div class="stream-container">
			<div class="stream">
			</div>
		</div>
	</div>
</div>
<div class="dashboard">
		<div class="component">
			<div class="user-rec-inner ">
		      <h2 class="user-rec-component">
		      <span class="dashboard-component-title">Who to follow</span>
		    </h2>
		    <ul class="js-recommended-followers recommended-followers user-rec-component" data-section-id="wtf">

		    </ul>
			</div>
			<hr class="component-spacer">
		</div>
	</div>
</div>
</div>
</body>
</html>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/twitter.js"></script>