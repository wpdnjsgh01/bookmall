package dao;

import java.sql.*;
import java.util.*;

import dto.OrderbookDto;
import vo.OrderbookVo;

public class OrderbookDao {

	public List<OrderbookDto> select() {
		
		List<OrderbookDto> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		
			conn = getConnection();

			String sql = "select a.quantity, a.price, c.order_code, b.title from order_book a, book b, `order` c where a.order_no = c.no and a.book_no = b.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int quantity = rs.getInt(1);
				int price = rs.getInt(2);
				String order_code = rs.getString(3);
				String title = rs.getString(4);
				
				OrderbookDto Dto = new OrderbookDto();
				Dto.setQuantity(quantity);
				Dto.setPrice(price);
				Dto.setOrder_code(order_code);
				Dto.setTitle(title);
				

				result.add(Dto);
				
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
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	public boolean insert(OrderbookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();

			// SQL 준비
			String sql = "insert into order_book values ( ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 (binding)
			pstmt.setInt(1, vo.getQuantity());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getOrder_no());
			pstmt.setInt(4, vo.getBook_no());
			
			// 5. SQL 실행
			int count = pstmt.executeUpdate();

			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
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
			System.out.println("드라이버 로딩 실패: " + e);
		}
		return conn;
	}
}
