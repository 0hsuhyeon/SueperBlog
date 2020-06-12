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
	<title>회원관리</title>
	</head>               
	<body align="center">                         
		
		<h1>회원 목록</h1>       
		<a href='<%=request.getContextPath()%>/member/memAddForm.jsp'><button>회원추가</button></a><br/>
	
	<% 
	{
			String sql ="SELECT mem_id, mem_pass, mem_name, mem_point FROM MEMBER";
			try (
				
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					String memId = rs.getString("mem_id"); 
					String memPass = rs.getString("mem_pass");
					String memName = rs.getString("mem_name");
					int memPoint = rs.getInt("mem_point");
	%>				
		<a href = '<%=request.getContextPath()%>/member/memEditForm.jsp?memId=<%=memId%>'> <%=memId%></a> : <%=memPass%> : <%=memName%>: <%=memPoint%>
		<a href = '<%=request.getContextPath()%>/member/memDel.jsp?memId=<%=memId%>'><button>삭제</button></a><br/>
	<%				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	%>
		</body>
		</html>
		
	
	

   