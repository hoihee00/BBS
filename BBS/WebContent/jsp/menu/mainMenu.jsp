<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/BBS/css/mainMenu.css">
</head>
<body>
	<div align="center">
		<div id="menu">
			<nav id="topMenu">
				<ul>
					<c:if test="${ id eq null }">
						<li><a class="menuLink" href="loginForm.do">로그인</a></li>
						<li>|</li>
					</c:if>
					<li><a class="menuLink" href="#">공지사항</a></li>
					<li>|</li>
					<li><a class="menuLink" href="#">게시판</a></li>
					<c:if test="${ id eq null }">
						<li>|</li>
						<li><a class="menuLink" href="memberForm.do">회원가입</a></li>
					</c:if>
					<c:if test="${ author eq 'admin' }">
						<li>|</li>
						<li><a class="menuLink" href="memberList.do">회원관리</a></li>
					</c:if>
					<li>|</li>
					<li><a class="menuLink" href="logout.do">로그아웃</a></li>
				</ul>
			</nav>
		</div>
	</div>

</body>
</html>