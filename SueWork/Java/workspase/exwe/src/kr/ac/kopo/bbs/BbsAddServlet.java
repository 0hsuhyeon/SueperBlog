package kr.ac.kopo.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bbs/add.do")
public class BbsAddServlet extends HttpServlet {
	BbsDaoJdbc bbsDao = new BbsDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsAdd.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		BbsVo vo = new BbsVo();
		vo.setBbsTitle(req.getParameter("bbsTitle"));
		vo.setBbsContent(req.getParameter("bbsContent"));
		vo.setBbsWriter(req.getParameter("bbsWriter"));
		
		int num = bbsDao.insertBbs(vo);
		
		
		resp.sendRedirect(req.getContextPath() + "/bbs/list.do"); //리다이렉트 시킬때는 브라우저가 이동을 인식한다
		//req.getRequestDispatcher("/bbs/list.do").forward(req, resp); // 포워드는 코드 내부상에서 이동하므로 브라우저가 모른다 
		
	}

}