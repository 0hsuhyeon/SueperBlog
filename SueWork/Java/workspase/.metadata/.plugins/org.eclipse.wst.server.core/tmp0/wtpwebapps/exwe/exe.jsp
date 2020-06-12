<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연습</title>
</head>
<body>
	<div>
	
		문자열 <%="문자열" %> ${"문자열"}<br/>
		${'자바와 다르게 작은 따옴표도 인식'}<br/>
		<%=123 %> ${123}<br/>
		<%=true %> ${true} <br/>
		<br/>
	</div>
	<div>
	
		<%=8+4%> <%=8-4%> <%=8*4%> <%=8/4%> <br/>
		${8+4} ${8-4} ${8*4} ${8/4} <br/>
		${8 div 4} ${8 mod 4}<br/>
		<br/>
	</div>
	<div>
	
		<%=3==4%> <%=3!=4%> <%=8<4%> <%=8>4%><br/>
		${3==4} ${3!=4} ${8<4} ${8>4} <br/>
		${3 eq 4} ${3 ne 4} ${3 lt 4} ${3 gt 4} <br/>
		<br/>
	</div>
	<div>
		
		<%
			String s = "I'm Sue";
		%>
		
		<%=s %> <br/>
		<%out.print(s);%> 와 동일한 의미 <br/>
		
		"$ { s }"를 사용하면 값이 나오지 않는다
		<br/><br/>
		param <br/>
		<%
			String xparam = request.getParameter("x");
			out.println(xparam);
			
			out.println( request.getParameter("x"));
		%><br/>
		JS X 파라미터 값: <%=request.getParameter("x") %> <br/>
		EL X 파라미터 값: ${param.x} <br/>
		EL X 파라미터 값: ${param["x"]} <br/>
		
		http://localhost:8001/exwe/exe.jsp?x=호출할것쓰기
		<br/><br/>
		
		JS User-Agent 헤더값: <%=request.getHeader("User-Agent") %><br/>
		EL User-Agent 헤더값: ${ header["User-Agent"] }<br/>
		
		<!-- 	jsp 기본객체 (request.resphone,session,appilcate,...)는 pageContext에 포함되어 있으므로 꺼내서 사용 가능 -->
		현재 웹애플리케이션(프로젝트)의 고유경로(컨텍스트패스) <%=request.getContextPath() %><br/>
		현재 웹애플리케이션(프로젝트)의 고유경로(컨텍스트패스) ${pageContext.request.getContextPath()} <!-- pageContext를 붙지지 않으면 사용불가 -->
		현재 웹애플리케이션(프로젝트)의 고유경로(컨텍스트패스) ${pageContext.request.contextPath} <!-- 간단화 -->
		<%-- 	${} 내부에서는 .getXxx()a메서드 대신 .xxx와 같이 속성(변수)이름만 사용가능  --%>
	
	</div>
	
	<div>
		<%
		// 		자바 웹 애플리케이션에서 데이터를 저장할 수 있는 공간(객체)
		pageContext.setAttribute("a", 1); //pageContext는 현재 JSP파일 안에서만 사용가능
		request.setAttribute("b", 2); // request는 현재 요청이 처리되는 동안에만 사용가능
		session.setAttribute("c", 3);
		application.setAttribute("d", 4);
		
		
		pageContext.setAttribute("z", 5); //pageContext는 현재 JSP파일 안에서만 사용가능
		request.setAttribute("z", 6); // request는 현재 요청이 처리되는 동안에만 사용가능
		session.setAttribute("z", 7);
		application.setAttribute("z", 8);
		%>
		<br/>
		pageContext에 "a"라는 이름으로 저장한 값: <%=pageContext.getAttribute("a") %><br/>
		pageContext에 "a"라는 이름으로 저장한 값: ${pageScope.a }<br/>
		pageContext에 "a"라는 이름으로 저장한 값: ${a }<br/> 
		<br/>
		request에 "b"라는 이름으로 저장한 값: <%=request.getAttribute("b") %><br/>
		request에 "b"라는 이름으로 저장한 값: ${requestScope.b }<br/>
		request에 "b"라는 이름으로 저장한 값: ${b }<br/>
		<br/>
		session에 "c"라는 이름으로 저장한 값: <%=session.getAttribute("c") %><br/>
		session에 "c"라는 이름으로 저장한 값: ${sessionScope.c }<br/>
		session에 "c"라는 이름으로 저장한 값: ${c }<br/>
		<br/>	
		application에 "d"라는 이름으로 저장한 값: <%=application.getAttribute("d") %><br/>
		application에 "d"라는 이름으로 저장한 값: ${applicationScope.d }<br/>
		application에 "d"라는 이름으로 저장한 값: ${d }<br/>
		<ba/>
		"z"라는 이름으로 저장한 값 : ${z} 스코프를 지정하지 않으면 순서대로 읽고 z가 있으면 바로 불러들인다, 때문에 가급적이면 다른 이름으로 저장하는 것이 좋다 
	
	</div>
	

</body>
</html>