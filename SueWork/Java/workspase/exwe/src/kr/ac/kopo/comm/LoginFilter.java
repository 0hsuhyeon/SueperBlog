package kr.ac.kopo.comm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.member.MemberVo;

// 1.회원추가 기능도 로그인 없이 사용 가능하도록LoginFilter를 변경
// 2.로그인 안 한 경우에는 [로그인]하고 [회원가입]메뉴가 나오고, 
// 	로그인 한 경우에는 [회원관리][게시판][학생관리][로그아웃] 메뉴가 나오도록 
// 	menu.jsp를 변경
// 3. 게시판 새 글을 쓸 경우 로그인 한 사람의 아이디가 자동으로 글 작성자로 저장


//필터(Filter): 지정된 주소로 요청이 왔을때, 서블릿의 실행 전과 후에 실행되는 객체
// - 여러 서블릿들에서 공통적으로 실행해야 하는 전처리/후처리 작업 구현시 사용
// - 등록방법
//		(1) @WebFilter("요청주소")를 필터 클래스에 적용하여 등록 
//		(2) web.xml 설정파일에 등록
@WebFilter("/member/*")
public class LoginFilter implements Filter{

	//통과나 막는 것중 수가 적은 것들의 목록을 만들어두기 (set을 사용하는 것이 좋음)
	private ArrayList<String> whiteList = new ArrayList<String>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터객체가 처음 생성된 후, 1번만 실행
		
		System.out.println("LoginFilter의 init 실행!");
		whiteList.add("/member/login.do");
		whiteList.add("/member/add.do");
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 이 필터에 지정된 주소로 요청이 올 때마다 1번씩 실행
		
			System.out.println("LoginFilter의 doFilter 실행!");
			
			//다음필터 또는 서블릿 실행 전에 수행할 작업들 
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			
//			System.out.println(  req.getRequestURI());
			System.out.println(  req.getRequestURL());
			
//			whiteList.contains(req.getRequestURI()); // 컨택스트패스가 포함되어있는 상태임
			String reqPath =req.getRequestURI().substring( req.getContextPath().length() );
			// RequestURI에서 Context Path를 제외한 뒷부분의 경로만 추출
			
			
			
//			if (!(whiteList.contains(reqPath))) { // 아래와 같은 의미
			if (whiteList.contains(reqPath)==false) { // 요청 주소가 whiteList에 없는 경우
				
				//로그인 검사 수행 
				HttpSession session = req.getSession();
				MemberVo loginVo = (MemberVo)session.getAttribute("loginUser"); 
				
				if (loginVo == null) {//로그인 하지 않은 경우, 로그인 화면으로 이동
					resp.sendRedirect(req.getContextPath()+"/member/login.do");
					return;
				}
				
			}
			
			
			//다음에 실행될 필터 또는 서블릿을 실행시키라는 명령
			chain.doFilter(request, response);
			
			//다음 필터 또는 서블릿 실행 후에 수행할 작업들
		
	}
	
	@Override
	public void destroy() {
		// 필터 객체가 소멸되기 전에 1번만 실행 // 필터가 사용하던 자원같은것을 반납하는 걸 구현하는 경우가 많음
	}

}
