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
			<h1>${ vo.name } 님 반갑습니다.</h1>
		</c:if>
	</div>
</body>
</html>