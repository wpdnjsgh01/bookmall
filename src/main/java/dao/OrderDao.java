package dao;

import java.sql.*;
import java.util.*;

import dto.OrderDto;
import vo.OrderVo;

public class OrderDao {

	public List<OrderDto> select() {
		List<OrderDto> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// SQL 준비
			String sql = "select a.order_code, a.no, a.price, a.destination, b.name from `order` a, member b where a.member_no = b.no";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int order_code = rs.getInt(1);
				int no = rs.getInt(2);
				int price = rs.getInt(3);
				String destination = rs.getString(4);
				String member_name = rs.getString(5);

				OrderDto dto = new OrderDto();
				dto.setOrder_code(order_code);
				dto.setNo(no);
				dto.setPrice(price);
				dto.setDestination(destination);
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
			String sql = "insert into `order` values ( ?, ?, ?, ?, ?)";
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
