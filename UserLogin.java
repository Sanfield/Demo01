package com.web.shopping.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.shopping.user.bean.User;
import com.web.shopping.user.service.UserService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userservice = new UserService();
		
		JSONObject json = userservice.login(request);
		if(json.getInt("result")==1)
		{
			request.getRequestDispatcher("Vegetables.jsp").forward(request, response);
		}else if(json.getInt("result")== -1){
			PrintWriter out= response.getWriter();
			out.write("<div align='center'><font color='red'>用户不存在</font></div>");
			out.flush();
			out.close();
		}else{
			PrintWriter out= response.getWriter();
			out.write("<div align='center'><font color='red'>密码不正确</font></div>");
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
