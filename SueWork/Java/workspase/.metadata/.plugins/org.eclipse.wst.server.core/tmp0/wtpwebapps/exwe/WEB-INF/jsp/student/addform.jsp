<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<!DOCTYPE html>				
		<html>						
		<head>                         
		<meta charset='UTF-8'>         
		<title>학생관리</title> 		
		</head>                        
		<body align="center">        
			<h1>학생 추가</h1>        	
		
			<form action='${pageContext.request.contextPath}/student/add.do' method='post'>      
			<fieldset>      								
		
			<label for="stuNo">신규 학번 </label>     
			<input type="text" name="stuNo"><br/>      	
		
			<label for="stuName">학생 이름 </label>     
			<input type="text" name="stuName"> <br/>    
		
			<label for="stuScore">학생 성적 </label>     
			<input type="text" name="stuScore"> <br/>   
		
		 <input type="submit" value="저장">			


			</fieldset>     								
			</form>     									
		</body>                         					
		</html>
