<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<!DOCTYPE html>				
		<html>						
		<head>                        
		<meta charset='UTF-8'>        
		<title>학생관리</title> 	
		</head>                       
		<body align="center">       
			<h1>학생정보변경</h1>     			
						
						<form action='${pageContext.request.contextPath}/student/edit.do' method='post'>    
						<fieldset>  
						
						<label for="stuNo">학 번 </label>  
						<input type="text" name="stuNo" value='${stuVo.stuNo}' readonly><br/> 

						<label for="stuName">이 름 </label>    
						<input type="text" name="stuName"value='${stuVo.stuName}'> <br/>     
						
						<label for="stuScore">포인트 </label>     
						<input type="text" name="stuScore"value='${stuVo.stuScore}'> <br/>    
						
						<input type="submit" value="수정">
						<a href='${pageContext.request.contextPath}/student/del.jsp?stuNo=${stuVo.stuNo}'><button type='button'>삭제</button></a><br/>
						


						</fieldset>  
						</form>   
	
		</body>       
		</html>       