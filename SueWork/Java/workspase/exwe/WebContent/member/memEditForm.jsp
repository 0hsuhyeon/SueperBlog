<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	{
		// 초기화 블럭
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String user ="com"; 
	String password ="com01"; 
%>
	
	
		<!DOCTYPE html>				
		<html>						
		<head>                        
		<meta charset='UTF-8'>        
		<title>회원관리</title> 	
		</head>                       
		<body align="center">       
			<h1>회원정보변경</h1>     
<%
		PrintWriter outPrintWriter = response.getWriter(); //응답객체에 출력할 수 있는 스트림 가져오기
		String no = request.getParameter("memId");
		String sql ="SELECT mem_id, mem_pass, mem_name, mem_point FROM MEMBER WHERE mem_id = ?";
			try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				
				pstmt.setString(1,no);
				try (ResultSet rs = pstmt.executeQuery();){
					if(rs.next()){
						String memId = rs.getString("mem_id"); 
						String memPass = rs.getString("mem_pass"); 						
						String memName = rs.getString("mem_name");
						int memPoint = rs.getInt("mem_point");
%>						
						
						<form action='<%=request.getContextPath()%>/member/memEdit.jsp' method='post'>    
						<fieldset>  
						
						<label for="memId">아이디 </label>  
						<input type="text" name="memId" value='<%=memId%>' readonly><br/> 

						<label for="mamName">이름 </label>    
						<input type="text" name="memName"value='<%=memName%>'> <br/>     
						
						<label for="mamPoint">포인트 </label>     
						<input type="text" name="memPoint"value='<%=memPoint%>'> <br/>    
						
						<input type="submit" value="수정">
						<a href='<%=request.getContextPath()%>/member/memDel.jsp?memId=<%=memId%>'><button type='button'>삭제</button></a><br/>
						


						</fieldset>  
						</form>   
<%								
					}
			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
	
%>		
		</body>       
		</html>       