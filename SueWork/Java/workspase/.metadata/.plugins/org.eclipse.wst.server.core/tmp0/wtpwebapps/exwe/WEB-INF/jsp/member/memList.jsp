<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
		<!DOCTYPE html>			
		<html>					
		<head>                       
		<meta charset='UTF-8'>       
		<title>회원관리</title> 	
		</head>                      
		<body align="center">
		
<!-- 		다른 JSP파일(또는 서블릿 출력)을 현재 위치에 포함       -->

<%-- 		<%@include file=%>:다른 JSP파일의 내용을 복사하여 현재 위치에 붙여넣기한것과 동일 --%>
<%-- 		<%@include file="/WEB-INF/jsp/comm/menu.jsp" %> --%>
<%-- 		<jsp:include>: 다른 JSP파일로 이동하여 실행한 후 다시 현재위치로 돌아옴 --%>

			<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>
			
<%-- 		<jsp:include>와 유사하지만 외부의 다른 사이트까지 포함 가능  --%>
<%-- 		<c:import url="/WEB-INF/jsp/comm/menu.jsp"></c:import> --%>

			<h1>회원 목록</h1>       
<%-- 		<a href='<%=request.getContextPath()%>/member/addform.do'><button>회원추가</button></a><br> --%>
			<a href='${pageContext.request.contextPath}/member/add.do'><button>회원추가</button></a><br>

			<c:forEach var="vo" items= "${memList}">
				<a href = '${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}'> ${vo.memId}</a>
				: ${vo.memPass} : ${vo.memName} : ${vo.memPoint} 
				<a href='${pageContext.request.contextPath}/member/del.do?memId=${vo.memId}'><button>삭제</button></a><br/>																		
			</c:forEach>				
			
		
		
		</body>        
		</html>        
		