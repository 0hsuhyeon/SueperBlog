package kr.ac.kepo.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1.브라우저 주소창에
//http://localhost:8000/exweb/student/list.do
//를 입력하여 접속(요청전송)하면,
//브라우저 화면에 학생목록(학번,이름)이 출력되도록 구현

//2.학생목록 화면에 "학생추가"링크를 추가하고,
//그 링크를 클릭하면,
//http://localhost:8000/exweb/student/addform.do
//로 이동하여,
//학생의 학번, 이름, 성적을 입력할 수 있는 입력엘리먼트를 출력
//(학번,이름,성적 파라미터 이름은 stuNo, stuName, stuScore로 설정

//2-1 저장버튼을 클릭하면
//http://localhost:8000/exweb/student/add.do
//로 이동하여, 입력한 학생 정보를 데이터베이스에 저장하고
//학생등록 화면으로 이동

//3. 학생목록화면에서 각 학생들의 학번을 클릭하면,
//http://localhost:8000/exweb/student/editform.do
//로 이동하여,
//해당 학생의 학번, 이름, 성적을 입력할 수 있는 입력멜리먼트들을 출력
//(입력엘리먼트에는 해당 학생의 현재 학번, 이름, 성적을 출력)

//3-1 저장 버튼을 클릭하면
//http://localhost:8000/exweb/student/edit.do
//로 이동하여,
//데이터베이스에서 해당 학생의 이름과 성적을 변경하고
//학생목록 화면으로 이동

//3-2 삭제 버튼을 틀릭하면
//http://localhost:8000/exweb/student/del.do
//로 이동하여, 데이터베이스에서 해당 학생을 삭제하고,
//브라우저 화면에 학생목록이 출력
	@WebServlet("/student/list.do")
	public class StudentListServlet extends HttpServlet {
	
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
		
			resp.setContentType("text/html");//응답내용이 text/html임을 알리도록 설정
			resp.setCharacterEncoding("UTF-8"); //응답내용의 문자 인코딩 설정
			PrintWriter out = resp.getWriter(); //응답객체에 출력할 수 있는 스트림 가져오기
		
		
		
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.print("<head>                           ");
			out.print("<meta charset='UTF-8'>           ");
			out.print("<title>학생관리</title> ");
			
			out.print("<style> body {\r\n" + 
					"      background-color: rgba(147, 112, 216, 0.925);\r\n" + 
					"    }"+ 
					"div {   \r\n" + 
					"      background-color: lightpink;   \r\n" + 
					"      width:90%;  /* 너비 */\r\n" + 
					"      padding:15px;  /* 패딩 */\r\n" + 
					"      border:1px solid black;  /* 테두리 */\r\n" + 
					"    }"+ 
					".shadow{color: lightskyblue; text-shadow: 5px 5px 3px dodgerblue;}"+
					"</style> ");
			
			out.print("</head>                          ");
			out.print("<body align=\"center\">                           ");
			out.print("	 <div> ");
			out.print("	<h1 class='shadow'>학생 목록</h1>       ");
			out.println("<a href='"+req.getContextPath()+"/student/addform.do'><button>학생추가</button></a><br/>");
			
			{
				String sql ="SELECT stu_no, stu_name, stu_score FROM student";
				try (
					
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
				){
					
					
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()){
						String stuNo = rs.getString("stu_no"); 
						String stuName = rs.getString("stu_name");
						int stuScore = rs.getInt("stu_score");
						
						out.println("<li> <a href = "+req.getContextPath()+"/student/editform.do?stuNo="+ stuNo +">" + stuNo + "</a>"+" : "+ stuName +"	:"+ stuScore );
						out.println("<a href='"+req.getContextPath()+"/student/del.do?stuNo=" + stuNo + "'><button>삭제</button></a><br/></li>");
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			out.print("	</div>   ");
			out.print("</body>                          ");
			out.print("</html>                          ");
			
		}
	}
