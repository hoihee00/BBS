<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formCheck() {
		var f = document.frm;
		if(f.id.value=="") {
			alert("사용자 아이디를 입력하세요.");
			f.id.focus();
			return false;
		}
		
		if(f.password.value=="") {
			alert("사용자 비밀번호를 입력하세요.");
			f.password.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<jsp:include page="../menu/mainMenu.jsp"></jsp:include>
	<hr>
	<div align="center">
		<div>
			<h1>로 그 인</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="login.do" method="post">
				<table border="1">
					<tr>
						<th width="200">아이디</th>
						<td width="500"><input type="text" id="id" name="id"></td>
					</tr>
					<tr>
						<th width="200">패스워드</th>
						<td width="500"><input type="password" id="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" onclick="return formCheck()">로그인</button>&nbsp;&nbsp;&nbsp;
							<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
							<button type="button" onclick="#">회원가입</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>