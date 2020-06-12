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

@WebServlet("/student/add.do")
public class StudentAddServlet extends HttpServlet{

	Scanner s =  new Scanner(System.in);
	
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
		
		req.setCharacterEncoding("UTF-8"); // post 방식으로 전송된 파라미터값의 인코딩 설정
		String stuNo = req.getParameter("stuNo");
		String stuName = req.getParameter("stuName");
		int stuScore = Integer.parseInt(req.getParameter("stuScore"));
		
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
		resp.sendRedirect(req.getContextPath()+"/student/list.do");
	}
}