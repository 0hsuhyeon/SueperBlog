package kr.ac.kepo.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/edit.do")
public class StudentEditServlet extends HttpServlet{

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
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); // POST 방식으로 전송된 파라미터값의 인코딩 설정
		String stuNo = req.getParameter("stuNo");
		String stuName = req.getParameter("stuName");
		int stuScore = Integer.parseInt(req.getParameter("stuScore"));
		
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
				System.out.println(num + "명의 회원 변경");
						
			 } catch (SQLException e) {
				e.printStackTrace();
			 	}
		}
		resp.sendRedirect(req.getContextPath()+"/student/list.do");
	
	}
	
}
