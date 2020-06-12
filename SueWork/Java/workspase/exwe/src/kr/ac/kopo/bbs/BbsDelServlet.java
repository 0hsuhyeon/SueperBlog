package kr.ac.kopo.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bbs/del.do")
public class BbsDelServlet extends HttpServlet{

	BbsDaoJdbc bbsDao = new BbsDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int no = Integer.parseInt(req.getParameter("bbsNo"));
		
		int num = bbsDao.deleteBbs(no);
		
		System.out.println(num + "명의 회원 삭제");
		System.out.println(no +"님의 정보를 삭제합니다");
		
		resp.sendRedirect(req.getContextPath() + "/bbs/list.do");
	}

	
}