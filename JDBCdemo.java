package com.sfjdbc.www;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCdemo {
	public static void main(String[] args) throws Exception {
    JDBCdemo  jd = new JDBCdemo();
    jd.add();

}
	public void add() throws Exception{
		
		Class.forName("com.mysql.jdbc.Connection");
		String url = "jdbc:mysql://localhost:3306/sangfei";
		String user = "root";
		String password = "ROOT";
		Connection conn= DriverManager.getConnection(url, user, password);
		Statement st = conn.createStatement();
		ResultSet result= st.executeQuery("SELECT *from `qq`");
		//执行增删改查语句，或执行其他不返回任何内容
		
		
		int i = st.executeUpdate("update `qq` set`password`= '123456' where id =2");
		System.out.println(i);
	}
public  void justnow (){
	 try {
//		Class.forName("com.mysql.jdbc.Connection");
		 Class.forName("com.mysql.jdbc.Driver");
		// jdbc:mysql://数据库所在的IP：端口号/数据库名称（mysql的固定格式）
		String url = "jdbc:mysql://localhost:3306/sangfei";
		String user = "root";
		String password = "ROOT";
		Connection conn = DriverManager.getConnection(url, user, password);
		//注意 包为java.sql
		
		System.out.println("链接成功");
		//先建立 statement 操作流
		Statement st =  conn.createStatement();
		//再建立 result 返回流
		ResultSet  result = st.executeQuery("select *from student");
		while(result.next()){
			/*通过索引获得
			System.out.print(result.getString(1)+'\t');
			System.out.print(result.getString(2)+'\t');
			System.out.print(result.getString(3)+'\t');
			System.out.print(result.getString(4)+'\t');
			System.out.print(result.getString(5)+'\n');
			*///
			System.out.print(result.getString("sno")+'\t');
			System.out.print(result.getString("sname")+'\t');
			System.out.print(result.getString("ssex")+'\t');
			System.out.print(result.getString("sbrithday")+'\t');
			System.out.print(result.getString("class")+'\n');
			
		}
		conn.close();
		st.close();
		result.close();
		
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}
	
}
