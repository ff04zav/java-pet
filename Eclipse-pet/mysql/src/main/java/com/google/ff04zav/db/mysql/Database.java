package com.google.ff04zav.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	
	private static Database db = new Database();
	private static final String URL = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC";
	public static Database instance() {
		return db;
	}
	private Connection conn;
	
	public Connection getConn() {
		return conn;
	}


	
	private Database() {}
	
	public void connect(Properties props) throws SQLException {
		String server = props.getProperty("server");
		String database = props.getProperty("database");
		String port = props.getProperty("port");
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		conn = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC", server, port, database), user, password);
	}
	
	public void close() throws SQLException {
		conn.close();
	}

}
