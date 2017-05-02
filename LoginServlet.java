package com.xatu.file.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xatu.file.service.StudentService;
import com.xatu.file.service.TeacherService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");  
		request.getSession().setAttribute("userId",userId);//把userid放到cookie里
		String job= request.getParameter("job");
		switch(job){
		case "0":
		{
			//管理员登陆

		} break;
		case "1":
		{	//学生
			StudentService StudentService = new StudentService();
			
			JSONObject json = StudentService.login(request);
			if(json.getInt("result")>0){
				request.getRequestDispatcher("/jsp/page/Document_page.jsp").forward(request, response);
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
		} break;
		case "2":
		{	//老师
			TeacherService TeacherService = new TeacherService();
			
			JSONObject json = TeacherService.login(request);
			if(json.getInt("result")>0){
				request.getRequestDispatcher("/jsp/page/Document_page.jsp").forward(request, response);
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
		}break;
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
