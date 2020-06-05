<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HELLO JSP</h1>

	<%-- 스크립트릿: JSP내에서 실행하고 싶은 JAVA코드들은 <% %> 태그 내부에 작성 --%>
	<% 
		//jsp에서는 별도의 선언없이 사용가능한 기본 객체들이 존재함  :: jsp기본객체 검색하면 다 나옴
		// request 요청 객체, response 응답 객체, out (응답객체에 출력하는 스트림) 등
		int a = 3;
		int b = 4;
		int c = a+b;
		out.println("a+b="+c);
	%>
	
	<%-- 표현식: JAVA 코드를 실행한 결과를 현재 위치에 출력하고 싶은 경우<%= %> 사용가능 --%>
	a+b = <% out.println(c); %>
	a+b = <%= c %>
	
	
	<%-- 요청이 올때마다 실행되는 service() 메서드 외부에 위치해야하는 자바코드는 <%! %> 사용가능  --%>
	<%!
		private int x = 10;
	%>
	
</body>
</html>

