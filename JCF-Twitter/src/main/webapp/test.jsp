<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>환영합니다.</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.7.min.js"></script>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">JCF-Twitter</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="<%=request.getContextPath()%>/login">Login</a></li>
						<li><a href="<%=request.getContextPath()%>/user/findUsers">사용자관리</a></li>
						<li><a href="http://about.me/jeado">Contact</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
		<div class="hero-unit" align="center">
			<h1>테스트</h1>
			<div class="result"></div>
		</div>
	</div>
</body>
</html>
<script>
/* (function(j){
	//받기
	j.ajax({
		url: 'tweet.json',
		headers: {'Accept':'application/json+sua'},
		context: $('.result'),
		success: function(data){
			jQuery.each(data.followingList, function(i, obj) {
				$(this).append(document.createTextNode(obj.followingId));
				$(this).append(document.createTextNode("|"));
			});
		 }
	});

	//보내기
	j.ajax({
		url: 'user/insertUser.action',
		headers: {'Accept':'application/json+sua'},
                data : JSON.stringify({USER_DS:{userId:'test',userName:'jeado',userEmail:''}}),
                type: 'POST',
		success: function(data){
			console.log("ok");
		 }
	});
})(jQuery); */
</script>