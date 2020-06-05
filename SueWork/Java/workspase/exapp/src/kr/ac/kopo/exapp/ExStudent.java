//브라우저 주소창에
//http://localhost:8000/exwe/member/list.do


package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExStudent {
// 숙제
//	1. 학생목록 2. 학생추가 3. 학생삭제 4.종료라고 메뉴를 출력
//	번호를 입력받는다
//	1을 입력한 경우 student 테이블에 존재하는 모든 학생 목록을 출력
//	2를 입력한 경우 학번 이름 성적을 입력받아서 student 테이블에 저장
//	3을 입력한 경우 "삭제할 학생의 학번 입력:"라고 출력하고 해당학생을 테이블에서 삭제
//	4를 입력한 경우 프로그램을 정료
//	위 작업을 무한 반복 
//	
//	5. 성적변경 메뉴를 추가
//	5를 입력한 경우 "성적을 변경할 학생의 학번을 입력하세요" 라고 출력하고 학번을 입력받는다 
//	입력받은 학번의 학생의 학번 이름 성적을 출력 
//	"변경할 성적을 입력하세요" 라고 출력하고 성적을 입력받는다 해당학생의 성적을 입력한 성적으로 테이블에서 변경

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="com"; 
		String password ="com01"; 
	///////////////////////////////////오라클 연결////////////////////////////////////////
		
		String no = "";
		String na = "";
		int sc = 0;
		
		boolean flag = true; // while 문
		
		do {
		
			System.out.println("1. 학생목록	2. 학생추가	3. 학생삭제	4.종료	5.성적변경");
			String menu = s.nextLine();
			
			switch (menu) {
			case "1" :System.out.println("학생 목록을 불러옵니다.\n");
				{
					String sql ="SELECT stu_no, stu_name, stu_score FROM student";
					try (
						
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery();
					){
						while(rs.next()){
							String stuNo = rs.getString("stu_no"); 
							String stuName = rs.getString("stu_name");
							int stuScore = rs.getInt("stu_score");
							
							System.out.println(stuNo +" :: "+ stuName +" :: "+ stuScore);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
				
			case "2": System.out.println("새 학생을 추가합니다.\n");
				
				System.out.println("신규 학번을 입력하세요");
				no = s.nextLine();
				System.out.println("신규 이름을 입력하세요");
				na = s.nextLine();
				System.out.println("신규 성적을 입력하세요");
				sc = s.nextInt();
				
				{
					//SQL문에서 변화하는 값은 ?로 표시
					String sql ="INSERT INTO student(stu_no, stu_name, stu_score)" 
								+ "VALUES(?,?,?)";
							
							
					try (
								
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
					){
								
						pstmt.setString(1,no);//pstmt에 들어있는 SQL문의 1번째 ?에 no값을 주입
						pstmt.setString(2,na);
						pstmt.setInt(3,sc);
								
						int num = pstmt.executeUpdate();
						System.out.println(num + "명의 학생 추가");
								
					 } catch (SQLException e) {
						e.printStackTrace();
					 	}
				}
				
				break;
				
			case "3": System.out.println("학생 정보를 삭제합니다.\n");
				System.out.println("삭제할 학생의 학번을 입력해주세요\n");
				String del= s.nextLine();
				
				{
					String sql = "DELETE FROM student WHERE stu_no = ?";//실행할 SQL문을 명령문 객체로 생성(실행준비)
					
					//try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 달아준다(close)
					try (
						
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
					){
						pstmt.setString(1,del);
						
						int num = pstmt.executeUpdate();
						System.out.println(del +"님의 정보를 삭제합니다");
						System.out.println(num + "명의 회원 삭제");
						
			
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
				
			case "4": System.out.println("프로그램을 종료합니다.\n");
				flag = false;
				break;
				
			case "5":System.out.println("학생의 성적을 변경합니다.\n");
			//			5. 성적변경 메뉴를 추가
			//			5를 입력한 경우 "성적을 변경할 학생의 학번을 입력하세요" 라고 출력하고 학번을 입력받는다 
			//			입력받은 학번의 학생의 학번 이름 성적을 출력 
			//			"변경할 성적을 입력하세요" 라고 출력하고 성적을 입력받는다 해당학생의 성적을 입력한 성적으로 테이블에서 변경
				System.out.println("성적을 변경할 학생의 학번을 입력하세요");
				no = s.nextLine();
				
				{
					String sql ="SELECT stu_no, stu_name, stu_score FROM student WHERE stu_no = ?";
					try (
						
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
					){
						
						pstmt.setString(1,no);
						
						try {
							ResultSet rs = pstmt.executeQuery();
							
							if(rs.next()){
								String stuNo = rs.getString("stu_no"); 
								String stuName = rs.getString("stu_name");
								int stuScore = rs.getInt("stu_score");
								System.out.println(stuNo +" : "+ stuName +" : "+ stuScore);
								
								System.out.println("변경할 성적을 입력하세요");
								sc = s.nextInt();
								
							
									String sql2 = "UPDATE student SET stu_score = ? where stu_no =?";//실행할 SQL문을 명령문 객체로 생성(실행준비)
									
									//try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 달아준다(close)
									try (
										//데이터베이스에 접속(연결,로그인)
										Connection conn2 = DriverManager.getConnection(url, user, password);//Ctrl +1 하고 첫번째 거 클릭 
										//실행할 SQL문을 명령문 객체로 생성(실행준비)
										PreparedStatement pstmt2 = conn2.prepareStatement(sql2);
									){
										
										pstmt2.setInt(1,sc);
										pstmt2.setString(2,no);
										
										int num = pstmt2.executeUpdate();// 실행결과 변경된 레코드 수를 반환
										System.out.println(num + "개의 레코드 변경");
										
							
										
									} catch (SQLException e) {
										e.printStackTrace();
									}
							
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				
				
				break;
				
//			default: System.out.println("유효하지 않은 접근입니다. 다시 입력해주십시오\n");
//				break;
			}
			
		}while(flag);
		
	}
}
