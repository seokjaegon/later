<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="resources/css/style.css"/>
<link rel="stylesheet"
	href="resources/css/reviewDetail.css"/>
</head>
<style>
	.detail-all {
		overflow-x: hidden;
		overflow-y: auto;
	}
</style>
<body>
<div class="detail-all">
	<div class="content">
		<h2 class="form-header">상세 보기</h2>
		<!-- 게시글 상세 내용 출력(div) -->
		<div class="detail">
			<div class="detail-sub">
				<div class="detail-title">내용</div>
				<div class="detail-content">${review.contents}</div>
			</div>
			<div class="detail-sub">
				<div class="detail-title">작성 시간</div>
				<div class="detail-content">${review.time}</div>
			</div>
		</div>
		<div class="btn-area">
			<button class="btn-write" id="upbtn">U</button>
			<button class="btn-write" id="delbtn">D</button>
			<button class="btn-sub" id="backbtn">B</button>
		</div>
	</div>
</div>
</body>
</html>