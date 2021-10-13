package dao;

import java.sql.*;
import java.util.*;

import vo.OrderVo;

public class OrderDao {

	public List<OrderVo> select() {
		List<OrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// SQL 준비
			String sql = "SELECT order_code, no, price, destination, member_no from order";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int order_code = rs.getInt(1);
				int no = rs.getInt(2);
				int price = rs.getInt(3);
				String destination = rs.getString(4);
				int member_no = rs.getInt(5);

				OrderVo vo = new OrderVo();
				vo.setOrder_code(order_code);
				vo.setNo(no);
				vo.setPrice(price);
				vo.setDestination(destination);
				vo.setMember_no(member_no);
				

				result.add(vo);
				
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

	public boolean insert(OrderVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();

			// SQL 준비
			String sql = "insert into book values ( null, null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 (binding)
			pstmt.setInt(1, vo.getOrder_code());
			pstmt.setInt(2, vo.getNo());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getDestination());
			pstmt.setInt(5, vo.getMember_no());
			

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
