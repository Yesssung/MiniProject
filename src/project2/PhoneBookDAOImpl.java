package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookDAOImpl implements PhoneBookDAO {
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String dbur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		
		conn = DriverManager.getConnection(dbur1, "himedia", "himedia");

	} catch (ClassNotFoundException e) {
		System.err.println("드라이버를 찾을 수 없습니다.");
		e.printStackTrace();
	}
	return conn;

}

	@Override
	public List<PhoneBookVO> getList() {
		List<PhoneBookVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT id, name, hp, tel FROM phone_book";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				
				PhoneBookVO vo = new PhoneBookVO(id, name, hp, tel);
				list.add(vo);
			}
		} catch (SQLException e) {
			System.err.println("SQLError!");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) rs.close();
				if (conn != null) rs.close();
			} catch(Exception e) {
				
			}
		}
		return list;
	}

	@Override
	public PhoneBookVO get(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PhoneBookVO vo = null;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT id, name, hp, tel FROM phone_book WHERE name LIKE = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%name%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long phId = rs.getLong(1);
				String phName = rs.getString(2);
				String phHp = rs.getString(3);
				String phTel = rs.getString(4);
				
				vo = new PhoneBookVO(phId, phName, phHp, phTel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				
			}
		}
		return vo;
	}

	@Override
	public boolean insert(PhoneBookVO phonebookvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO phone_book (id, name, hp, tel) VALUES (seq_author_id.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, phonebookvo.getName());
			pstmt.setString(2, phonebookvo.getHp());
			pstmt.setString(3, phonebookvo.getTel());
			
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				
			}
		}
		return insertedCount == 1;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			
			String sql = "DELETE FROM phone_book WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				
			}
		}
		return deletedCount == 1;
	}

	@Override
	public boolean update(PhoneBookVO phonebookvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedCount = 0;
	
		try {
			conn = getConnection();
			String sql = "UPDATE phone_book SET name = ?, hp = ?, tel = ? WHERE id = ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, phonebookvo.getId());
			pstmt.setString(2, phonebookvo.getName());
			pstmt.setString(3, phonebookvo.getHp());
			pstmt.setString(4, phonebookvo.getTel());

			updatedCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close(); 
				if(conn != null) conn.close();
			} catch(Exception e) {
				
			}
		}
	
		return updatedCount == 1;
	}
	
}
	
	
