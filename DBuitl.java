package com.sfjdbc.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBuitl {
	private String url= "jdbc:mysql://localhost:3306/sangfei";
	private String user= "root";
	private String password = "ROOT";
	public Connection conn;
	public Statement st;
	static{
		try {
			Class.forName("com.mysql.jdbc.Connection");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public 	Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection(url, user, password);
		return conn;
		}
	public Statement getStatement() throws SQLException{
		getConnection();
		st = conn.createStatement();
		return st;
	}
	public  ResultSet executeQuery(String sql) throws SQLException {
		getStatement();
		return st.executeQuery(sql);
		
	}
	public void close(Connection conn,Statement st,ResultSet rs){
	
		try{
			if(rs !=null){
				rs.close();
			}
			if(st != null){
				st.close();
			}
			if(conn != null){
				conn.close();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}
	

}
