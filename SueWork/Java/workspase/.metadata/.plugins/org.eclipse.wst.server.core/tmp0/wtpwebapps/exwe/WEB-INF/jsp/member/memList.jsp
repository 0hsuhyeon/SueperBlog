<%@page import="kr.ac.kepo.member.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<!DOCTYPE html>			
		<html>					
		<head>                       
		<meta charset='UTF-8'>       
		<title>회원관리</title> 	
		</head>                      
		<body align="center">      
			<h1>회원 목록</h1>       
		<a href='<%=request.getContextPath()%>/member/addform.do'><button>회원추가</button></a><br>

<% 
			ArrayList <MemberVo> list=  (ArrayList<MemberVo>)request.getAttribute("memList"); //요청객체에 memList라는 이름으로 저장되어 있는 데이터 가져오기
		
			
			for (MemberVo vo : list) { 
%>	
				
			
			<a href = '<%=request.getContextPath()%>/member/editform.do?memId=<%=vo.getMemId()%>'><%=vo.getMemId()%></a> : <%=vo.getMemPass()%> : <%=vo.getMemName()%> : <%=vo.getMemPoint()%> 
			<a href='<%=request.getContextPath()%>/member/del.do?memId="<%=vo.getMemId()%>'><button>삭제</button></a><br/>																		
				
<% }%>
			
		
		
		</body>        
		</html>        
		