package kr.ac.kopo.bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DAO (Data Access Object):
// 자바 데이터 (객체) <-> 데이터베이스 데이터(테이블) 사이의 상호변환을 담당
public class BbsDaoJdbc {

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
	
		public ArrayList<BbsVo> selectBbsList() {
			
			
			ArrayList<BbsVo> list = new ArrayList<BbsVo>();
			String sql ="SELECT bbs_no, bbs_title, bbs_writer, bbs_reg_date, bbs_count FROM Bbs";
			try (
				
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					BbsVo vo = new BbsVo();
					vo.setBbsNo(rs.getInt("bbs_no"));
					vo.setBbsTitle(rs.getString("bbs_title"));
					vo.setBbsWriter(rs.getString("bbs_writer"));
					vo.setBbsRegDate(rs.getTimestamp("bbs_reg_date"));
					vo.setBbsCount(rs.getInt("bbs_count"));
					list.add(vo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public int insertBbs(BbsVo vo) {
				
				//SQL문에서 변화하는 값은 ?로 표시
				int num =0;
				String sql ="INSERT INTO Bbs(bbs_no, bbs_title, bbs_content, bbs_writer)" 
							+ "VALUES(seq_bbs_no.NEXTVAL,?,?,?)";
						
						
				try (
							
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
				){
					
					pstmt.setString(1,vo.getBbsTitle());
					pstmt.setString(2,vo.getBbsContent());
					pstmt.setString(3,vo.getBbsWriter());
							
					num = pstmt.executeUpdate();
							
				 } catch (SQLException e) {
					e.printStackTrace();
				 	}
				return num;
		}
	
		public BbsVo selectBbs(int bbsNo) {
			BbsVo vo = null;
			String sql ="SELECT bbs_no, bbs_title, bbs_content, bbs_writer, bbs_reg_date, bbs_count FROM Bbs WHERE bbs_no = ?";
			try (
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
					){
				
				pstmt.setInt(1,bbsNo);
				try (ResultSet rs = pstmt.executeQuery();){
					if(rs.next()){

						vo = new BbsVo();
						vo.setBbsNo(rs.getInt("bbs_no"));
						vo.setBbsTitle(rs.getString("bbs_title"));
						vo.setBbsContent(rs.getString("bbs_content"));
						vo.setBbsWriter(rs.getString("bbs_writer"));
						vo.setBbsRegDate(rs.getDate("bbs_reg_date"));
						vo.setBbsCount(rs.getInt("bbs_count"));
						
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			return vo;
		}
	
		public int updateBbs(BbsVo vo) {
			int num =0;
			String sql ="UPDATE Bbs SET bbs_title =?, bbs_content=? where bbs_no = ?" ;
					
					
			try (
						
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				
				pstmt.setInt(3,vo.getBbsNo());//pstmt에 들어있는 SQL문의 1번째 ?에 id값을 주입
				pstmt.setString(1,vo.getBbsTitle());
				pstmt.setString(2,vo.getBbsContent());
						
				num = pstmt.executeUpdate();
						
			 } catch (SQLException e) {
				e.printStackTrace();
			 	}
			return num;
		}
	
		
		public int deleteBbs(int bbsNo) {
			int num = 0;
			String sql = "DELETE FROM Bbs where bbs_no = ?";//실행할 SQL문을 명령문 객체로 생성(실행준비)
			
			//try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 달아준다(close)
			try (
				
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				pstmt.setInt(1,bbsNo);
				num = pstmt.executeUpdate();
				
				
	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return num;
		}
	
			
}