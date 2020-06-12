package kr.ac.kopo.student;

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

import kr.ac.kopo.member.MemberDaoJdbc;

@WebServlet("/student/edit.do")
public class StudentEditServlet extends HttpServlet{

	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("stuNo");
		
		StudentVo vo = studentDao.selectStudent(no);
		req.setAttribute("stuVo", vo);
		req.getRequestDispatcher("/WEB-INF/jsp/student/editform.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); // POST 방식으로 전송된 파라미터값의 인코딩 설정
		
		StudentVo vo = new StudentVo();
		vo.setStuNo(req.getParameter("stuNo"));
		vo.setStuName(req.getParameter("stuName"));
		vo.setStuScore(Integer.parseInt(req.getParameter("stuScore")));
		
			int num = studentDao.updateStudent(vo);
			System.out.println(num + "명의 회원 변경");
		
		resp.sendRedirect(req.getContextPath()+"/student/list.do");
	
	}
	
}