<%@page import="java.sql.SQLException"%>
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
<% 
		String delid= request.getParameter("memId");
		{
			String sql = "DELETE FROM MEMBER where MEM_ID = ?";//실행할 SQL문을 명령문 객체로 생성(실행준비)
			
			//try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 달아준다(close)
			try (
				
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				pstmt.setString(1,delid);
				int num = pstmt.executeUpdate();
				System.out.println(num + "명의 회원 삭제");
				System.out.println(delid +"님의 정보를 삭제합니다");
				
	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect(request.getContextPath()+"/member/memList.jsp");
	
%>	

