<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body align="center">
	<h1>새 글 쓰기</h1>
	<form action="${pageContext.request.contextPath}/bbs/add.do" method="post">
	<table align="center" >
		<tbody>
			<!-- 		모양은 CSS로 맞추는것이좋음 -->
			<tr><th>제목</th> <td><input type="text" name="bbsTitle"/></td></tr> 
			<tr><th>내용</th> <td><textarea rows="10" cols="30" name="bbsContent"></textarea></td></tr>
<%-- 			<tr><th>작성자</th> <td><input type="text" value="${loginUser.memId}" readonly="readonly"></td></tr> --%>
			<!-- 보안은 백앤드(자바)에서 처리해야한다. --> 
		</tbody>
	</table>
		<input type = "submit" value="발행">

	</form>
</body>
</html>