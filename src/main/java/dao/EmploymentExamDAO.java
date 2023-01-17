package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.EmploymentExam;

public class EmploymentExamDAO {

	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static int registerEmploymentExam(EmploymentExam exam) {
		String sql = "INSERT INTO employment_exam VALUES(default, ?, ?, ?, ?, current_timestamp)";
		int result = 0;
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, exam.getCompanyName());
			pstmt.setObject(2, LocalDate.parse(exam.getExamDate()));
			pstmt.setInt(3, exam.getAccountId());
			pstmt.setString(4, exam.getNote());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	// ログインしているユーザの全受験状況を取得
	public static List<EmploymentExam> selectAllExamByUser(int account_id){
		
		// 実行するSQL
		String sql = "SELECT * FROM employment_exam where account_id = ?";
		
		// 返却用のListインスタンス
		List<EmploymentExam> result = new ArrayList<>();
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setInt(1, account_id);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("company_name");
					String exam_date = rs.getString("exam_date");
					//int account_id = rs.getInt("account_id");
					String note = rs.getString("note");
					String createdAt = rs.getString("created_at");

					EmploymentExam exam = new EmploymentExam(id, name, exam_date, account_id, note, createdAt);
					result.add(exam);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}

}
