package dao;

import java.sql.*;
import java.util.*;

import vo.CartVo;
import dto.CartDto;

public class CartDao {
	
	public List<CartDto> select() {
		List<CartDto> result = new  ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			//SQL 준비
			String sql = "select a.quantity, b.title, c.name from cart a, book b, member c where a.book_no = b.no and a.member_no = c.no";
			pstmt = conn.prepareStatement(sql);
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int quantity = rs.getInt(1);
				String book_title = rs.getString(2);
				String member_name = rs.getString(3);
				
				CartDto dto = new CartDto();
				dto.setQuantity(quantity);
				dto.setBook_title(book_title);
				dto.setMember_name(member_name);
				
				result.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if ( conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			//SQL 준비
			String sql = "INSERT INTO cart values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//바인딩 (binding)
			pstmt.setInt(1, vo.getQuantity());
			pstmt.setInt(2, vo.getBook_no());
			pstmt.setInt(3, vo.getMember_no());
			
			//5. SQL 실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if ( conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: "+e);
		}
		return conn;
	}
}
