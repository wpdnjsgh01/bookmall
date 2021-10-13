package dao;

import java.sql.*;
import java.util.*;

import vo.CategoryVo;

public class CategoryDao {

	public List<CategoryVo> select() {

		List<CategoryVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// SQL 준비
			String sql = "SELECT no, cat_name from category";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);

				CategoryVo vo = new CategoryVo();
				vo.setNo(no);
				vo.setCat_name(name);

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

	public boolean insert(CategoryVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			System.out.println("try 진입");
			// SQL 준비
			String sql = "INSERT INTO category values ( null, ?)";
			pstmt = conn.prepareStatement(sql);

			// 바인딩 (binding)
			pstmt.setString(1, vo.getCat_name());

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
