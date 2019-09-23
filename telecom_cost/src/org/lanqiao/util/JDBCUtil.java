package org.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://106.52.82.236:3306/forwork?serverTimezone=GMT","root","123456");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
