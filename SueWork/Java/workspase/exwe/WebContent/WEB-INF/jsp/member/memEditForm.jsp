
<%@page import="kr.ac.kepo.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo vo = (MemberVo)request.getAttribute("memVo");
%>
	<!DOCTYPE html>				
	<html>						
	<head>                       
	<meta charset='UTF-8'>       
	<title>회원관리</title> 		
	</head>                      
	<body align="center">      
		<h1>회원정보변경</h1>       
		
		
			<form action='<%= request.getContextPath() %>/member/edit.do' method='post'>  			 
			<fieldset>  																	
		
			<label for="memId">아이디 </label>     										
			<input type="text" name="memId" value='<%= vo.getMemId()%>' readonly/><br/> 
		
			<label for="mamName">이름 </label>   											
			<input type="text" name="memName"value='<%= vo.getMemName()%>'/> <br/>    	 
		
			<label for="mamPoint">포인트 </label>    										
			<input type="text" name="memPoint"value='<%=vo.getMemPoint()%> '/> <br/>   
		
		 	<input type="submit" value="수정">											
			<a href='<%= request.getContextPath() %>/member/del.do?memId=" + <%= vo.getMemId() %> '><button type='button'>삭제</button></a><br>
		
		
		
			</fieldset>  
			</form>    
		
	
	
		</body>    
		</html>    
   