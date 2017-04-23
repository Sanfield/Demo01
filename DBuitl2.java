package com.sfjdbc.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBuitl2 {
	private String url= "jdbc:mysql://localhost:3306/sangfei";
	private String user= "root";
	private String password = "ROOT";
	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
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
	public PreparedStatement getprepareStatement(String sql) throws SQLException{
		getConnection();
		ps = conn.prepareStatement(sql);
		return ps;
	}
//	public  ResultSet executeQuery() throws SQLException {
//		getprepareStatement();
//		return rs.executeQuery();
//		
//	}
	public ResultSet excuteQuery(String sql,String...params) throws SQLException{
		getprepareStatement(sql);
		for(int i = 0;i<params.length;i++){
			ps.setString(i+1, params[i]);
			}
		return ps.executeQuery();
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
