<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
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
			request.setCharacterEncoding("UTF-8"); // POST 방식으로 전송된 파라미터값의 인코딩 설정
			String stuNo = request.getParameter("stuNo");
			String stuName = request.getParameter("stuName");
			int stuScore = Integer.parseInt(request.getParameter("stuScore"));
			
			{
				//SQL문에서 변화하는 값은 ?로 표시
				String sql ="UPDATE student SET stu_name =?, stu_score=? where stu_no = ?" ;
						
						
				try (
							
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
				){
							
					pstmt.setString(3,stuNo);//pstmt에 들어있는 SQL문의 1번째 ?에 id값을 주입
					pstmt.setString(1,stuName);
					pstmt.setInt(2,stuScore);
							
					int num = pstmt.executeUpdate();
					System.out.println(num + "명의 정보 변경");
							
				 } catch (SQLException e) {
					e.printStackTrace();
				 	}
			}
			response.sendRedirect(request.getContextPath()+"/student/list.jsp");
		
	
%>			

    