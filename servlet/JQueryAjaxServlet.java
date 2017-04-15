package com.sangfei.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class JQueryAjaxServlet
 */
@WebServlet("/JQueryAjaxServlet")
public class JQueryAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public JQueryAjaxServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		String jsonStr = "{\"name\":\"手机\",\"type\":\"华为\",\"success\":\"true\"}";
		PrintWriter out = null;
		StringBuffer jsonRequest = new StringBuffer();
		String line=null;
		try{
			BufferedReader reader = request.getReader();
			while((line=reader.readLine())!=null){
				jsonRequest.append(line);
			}
			System.out.println(jsonRequest.toString());
			JSONObject job = JSONObject.fromObject("{"+jsonRequest.toString()+"}");
			System.out.println(job.get("sessionId"));
			JSONObject job1= JSONObject.fromObject(job.get("request"));
			System.out.println(job1.get("orderId"));
					
			out = response.getWriter();
			out.write(jsonStr);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out!=null)
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
