package kr.ac.kepo.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student/del.do")
public class StudentDelServlet extends HttpServlet{

	Scanner s = new Scanner(System.in);
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
		
		String delid= req.getParameter("stuNo");
		{
			String sql = "DELETE FROM student where stu_no = ?";//실행할 SQL문을 명령문 객체로 생성(실행준비)
			
			//try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 달아준다(close)
			try (
				
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				
				pstmt.setString(1,delid);
				int num = pstmt.executeUpdate();
				System.out.println(num + "명의 학생 삭제");
				System.out.println(delid +"님의 정보를 삭제합니다");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		resp.sendRedirect(req.getContextPath()+"/student/list.do");
	}
}
