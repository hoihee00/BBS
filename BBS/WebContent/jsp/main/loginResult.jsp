<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../menu/mainMenu.jsp"></jsp:include>
	<hr>
	<div align="center">
		<c:if test="${ vo.name eq null }">
			<h1>${ vo.id } 님 로그인 실패하였습니다.</h1>
		</c:if>
		<c:if test="${ vo.name ne null }">
			<h1>사용자 정보</h1>
			<h3>아이디 : ${ vo.id }</h3>
			<h3>성   명 : ${ vo.name }</h3>
			<h3>주   소 : ${ vo.address }</h3>
			<h3>전화번호 : ${ vo.tel }</h3>
			<h3>가입일자 : ${ vo.enterdate }</h3>
			<h3>사용권한 : ${ vo.author }</h3>

		</c:if>
	</div>
</body>
</html>