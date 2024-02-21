<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
.top-bar {
	background-color: #006BB9;
	color: #fff;
	display: flex;
  	justify-content: space-between;
  	align-items: center;
}

.review {
	flex:1;
	vertical-align: middle;
	text-align: left;
	padding-left: 5px;
}

.logo {
	margin: 4px;
	width: 50px;
	height: 50px;
	border-radius: 10px;
}

.site{
	flex:1;
	text-align: center;
}

.link {
	font-size: 15px;
	color: white;
}

.login-signin a {
	margin-left: 10px;
	text-decoration: none;
}

.login-signin {
	flex:1;
	vertical-align: middle;
	text-align: right;
	padding-right: 5px;
}
</style>
<div class="top-bar">
 	<div class="review">
 		<a href="/later"><img alt="로고" src="resources/images/리뷰엔.png" class="logo"></a>
	</div>
	<div class="site">
		<h2>리뷰엔</h2>
	</div>
	<div class="login-signin">
	<i class="fa fa-user-circle-o" aria-hidden="true"></i> <a
	class="link" href="loginPage">로그인</a> <a class="link"
	href="mSignIn">회원가입</a>
	<!-- <a class="link" href="writeFrm">모집글 등록</a> --> 
	</div>
</div>
