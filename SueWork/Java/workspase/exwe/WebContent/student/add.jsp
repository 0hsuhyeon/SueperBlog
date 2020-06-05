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
		request.setCharacterEncoding("UTF-8"); // post 방식으로 전송된 파라미터값의 인코딩 설정 // 요청객체 세팅
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		int stuScore = Integer.parseInt(request.getParameter("stuScore"));
		
		{
			//SQL문에서 변화하는 값은 ?로 표시
			String sql ="INSERT INTO student(stu_no, stu_name, stu_score)" 
					+ "VALUES(?,?,?)";
					
					
			try (
						
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
						
				pstmt.setString(1,stuNo);
				pstmt.setString(2,stuName);
				pstmt.setInt(3,stuScore);
						
				int num = pstmt.executeUpdate();
				System.out.println(num + "개의 레코드 추가");
						
			 } catch (SQLException e) {
				e.printStackTrace();
			 	}
		}
		
		// resp.sendRedirect("URL주소 또는 경로") : 지정된 주소 또는 경로로 이동하라는 명령을 담은 응답을 브라우저에게 전송 
		response.sendRedirect(request.getContextPath()+"/student/list.jsp");
%>		
		

