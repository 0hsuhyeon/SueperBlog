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

@WebServlet("/member/add.do")
public class MemberAddServlet extends HttpServlet {
	
	MemberDaoJdbc memberDao= new MemberDaoJdbc();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); // post 방식으로 전송된 파라미터값의 인코딩 설정
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		int memPoint = Integer.parseInt(req.getParameter("memPoint"));
		
		
		MemberVo vo = new MemberVo();
		vo.setMemId(memId);
		vo.setMemPass(memPass);
		vo.setMemName(memName);
		vo.setMemPoint(memPoint);
		
		
			
			int num = memberDao.insertMember(vo);
			System.out.println(num + "개의 레코드 추가");
		
		// resp.sendRedirect("URL주소 또는 경로") : 지정된 주소 또는 경로로 이동하라는 명령을 담은 응답을 브라우저에게 전송 
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
		
			
	}


}