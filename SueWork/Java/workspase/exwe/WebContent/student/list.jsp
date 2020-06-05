<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
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
	<title>학생관리</title>
	
	<style> body	{background-color: rgba(147, 112, 216, 0.925);} 
			div		{ 
					background-color: lightpink; 
					width:90%;  /* 너비 */ 
					padding:15px;  /* 패딩 */
					border:1px solid black;  /* 테두리 */ 
					}
			.shadow {color: lightskyblue; text-shadow: 5px 5px 3px dodgerblue;}
	</style>
	
	</head>               
	<body align="center">                         
	
		<div>
		<h1 class='shadow'>학생 목록</h1>      
		<a href='<%=request.getContextPath()%>/student/addform.jsp'><button>회원추가</button></a><br/>
	
	<% 
	{
			String sql ="SELECT stu_no, stu_name, stu_score FROM student";
			try (
				
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					String stuNo = rs.getString("stu_no"); 
					String stuName = rs.getString("stu_name");
					int stuScore = rs.getInt("stu_score");
	%>				
		<li> <a href = '<%=request.getContextPath()%>/student/editform.jsp?stuNo=<%=stuNo%>'><%=stuNo%></a>: <%=stuName %>:<%=stuScore%>
		<a href='<%=request.getContextPath()%>/student/del.jsp?stuNo=<%=stuNo%>'><button>삭제</button></a><br/></li>		
	<%
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	%>
		</div>
		</body>
		</html>