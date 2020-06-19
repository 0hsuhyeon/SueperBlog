<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h1>글 수정하기</h1>
	<form action="${pageContext.request.contextPath}/bbs/edit.do" method="post">
	<input type="hidden" name="bbsNo" value="${bbsVo.bbsNo}"/>
	<table align="center" >
		<tbody>
<!-- 		모양은 CSS로 맞추는것이좋음 -->
<%-- 		<tr><th>글번호</th> <td><input type="text" name="bbsNo" value="${bbsVo.bbsNo}" readonly="readonly"/></td></tr>  --%>
			<tr><th>제목</th> <td><input type="text" name="bbsTitle" value="${bbsVo.bbsTitle}"/></td></tr> 
			<tr><th>내용</th> <td><textarea name="bbsContent" rows="10" cols="30" >${bbsVo.bbsContent}</textarea></td></tr>
			<tr><th>작성자</th> <td><c:out value="${bbsVo.bbsWriter}"></c:out></td></tr>
			<tr><th>작성시간</th> <td><fmt:formatDate value="${bbsVo.bbsRegDate}" pattern="YYYY년  MM월  dd일  HH시 mm분 ss초"/></td></tr>
		</tbody>
	</table>
		<input type = "submit" value="발행">
		<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'>
		<button type='button'>삭제</button>
		</a><br>
	</form>
</body>
</html>