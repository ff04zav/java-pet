package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int[] ids = {3, 4, 5};
		String[] names = {"Sue", "Bob", "Charley"};
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dbUrl = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC";
		
		var conn = DriverManager.getConnection(dbUrl, "user", "user");
		conn.setAutoCommit(false);
		String sql;
		var stmt = conn.createStatement();
		try {
			sql = "insert into user (id, name) values (?, ?)";
			var insertStmt = conn.prepareStatement(sql);
			
			for(int i = 0; i < ids.length; i++) {
				insertStmt.setInt(1, ids[i]);
				insertStmt.setString(2, names[i]);
				insertStmt.executeUpdate();
			}
			
			conn.commit();
			insertStmt.close();
			sql = "select id, name from user";
			
			var rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id + ": " + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

}
