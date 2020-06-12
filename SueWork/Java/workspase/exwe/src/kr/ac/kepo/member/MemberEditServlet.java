package kr.ac.kepo.member;

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

@WebServlet("/member/edit.do")
public class MemberEditServlet extends HttpServlet {
	
		MemberDaoJdbc memberDao= new MemberDaoJdbc();
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.setCharacterEncoding("UTF-8"); // POST 방식으로 전송된 파라미터값의 인코딩 설정
			
			MemberVo vo = new MemberVo();
			vo.setMemId(req.getParameter("memId"));
			vo.setMemName(req.getParameter("memName"));
			vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));
			
			
			{
				//SQL문에서 변화하는 값은 ?로 표시
				int num = memberDao.updateMember(vo);
				System.out.println(num + "명의 회원 변경");
			}
			resp.sendRedirect(req.getContextPath()+"/member/list.do");
		
	}


}