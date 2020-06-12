package kr.ac.kopo.student;

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

import kr.ac.kopo.member.MemberDaoJdbc;


@WebServlet("/student/del.do")
public class StudentDelServlet extends HttpServlet{

	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String delid= req.getParameter("stuNo");
		
			int num = studentDao.deleteStudent(delid);
			System.out.println(num + "명의 학생 삭제");
			System.out.println(delid +"님의 정보를 삭제합니다");
			resp.sendRedirect (req.getContextPath() + "/student/list.do") ;
	}

	
}