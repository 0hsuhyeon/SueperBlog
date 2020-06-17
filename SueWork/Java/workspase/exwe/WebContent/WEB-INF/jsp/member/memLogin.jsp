<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body align="center">  
	<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>    
	<h1>회원 로그인</h1>  
	<form action="${pageContext.request.contextPath}/member/login.do" method="post">
    <fieldset>
			<legend>로그인 정보</legend>
			<ul>
					<label for="memId">아이디</label>
					<input type="text" name="memId">
				<br/><br/>
					<label for="memPass">비밀번호</label>
					<input type="text" name="memPass">
				<br/><br/>
					<a href='${pageContext.request.contextPath}/member/login.do'><button>로그인</button></a><br/>
			</ul>
		</fieldset>
  </form>
</body>
</html>