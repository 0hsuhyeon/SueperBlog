package kr.ac.kopo.bbs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 게시물 목록에서 등록일이 2020/06/12 09:58:37 와 같은 형태로 출력되도록 변경
// 게시물 상세보기 화면에서 등록일이 보이도록 변경 (X년 X월 X일 X시 X분 X초)


@WebServlet("/bbs/list.do")
public class BbsListServlet extends HttpServlet{
	BbsDao bbsDao = new BbsDaoJdbc();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BbsVo> list = bbsDao.selectBbsList();
		
		req.setAttribute("bbsList", list);
		
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsList.jsp").forward(req,resp);
	}
}
