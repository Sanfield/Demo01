package com.sfjdbc.www;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCdemo2 extends DBuitl{
public static void main(String[] args) throws SQLException {
	JDBCdemo2 j = new JDBCdemo2();
	boolean success = j.login("admin", "123456");
	if(success){
		System.out.println("³É¹¦");
	}else{
		System.out.println("Ê§°Ü");
	}
}

public boolean login(String username,String password) throws SQLException{
	String sql = "SELECT *FROM qq WHERE USER ='"+ username+"' AND PASSWORD ='"+ password +"'";
	System.out.println(sql);
	ResultSet set = executeQuery(sql);
	boolean  success = set.next();
	close(conn,st,set);
	return success;
}
}
