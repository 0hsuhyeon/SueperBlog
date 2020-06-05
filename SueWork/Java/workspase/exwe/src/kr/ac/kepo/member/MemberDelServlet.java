package kr.ac.kepo.member;

import java.io.IOException;
import java.io.PrintWriter;
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

//브라우저 주소창에 
//http://localhost:8000/exweb/member/del.do?memId=a001
//을 입력하고 엔터키를 입력하면 
//데이터베이스에서 아이디가 a001인 회원을 삭제하고 브라우저 화면에 회원목록이 출력되도록 구현

@WebServlet("/member/del.do")
public class MemberDelServlet extends HttpServlet{
	
	MemberDaoJdbc memberDao= new MemberDaoJdbc();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String delid= req.getParameter("memId");
		{
			
			
			int num = memberDao.deleteMember(delid);
			System.out.println(num + "명의 회원 삭제");
			System.out.println(delid +"님의 정보를 삭제합니다");
		}
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
	}


}
