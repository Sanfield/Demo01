package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dean.demo.DB;

/**
 * Servlet implementation class SnumberAJAX
 */
@WebServlet("/AJAX/SnumberAJAX")
public class SnumberAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnumberAJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String sunmber  = request.getParameter("snumber");
		if(sunmber==""){
			out.println("<font color='red'>账户不能为空</font>");
		}
		Connection conn  = DB.getconn();
		Statement stmt= DB.getstmt(conn);
		String  sql= "SELECT student_number FROM student";
		ResultSet rs = DB.getRS(stmt, sql);
		try {
			while(rs.next()){
				if(rs.getString(0)==sunmber){
					out.println("<font color='red'>改账户已被注册</font>");
				}else{
					out.println("<font color='green'>可以使用</font>");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
