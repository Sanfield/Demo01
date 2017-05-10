package com.sxt.taobao.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter("/CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }

   private String characterEncoding = null;
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("****init****");
		//从Web.xml中获取字符集
		characterEncoding = fConfig.getInitParameter("charEncoding");
		if(characterEncoding == null){
			characterEncoding = "UTF-8";
		}
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("****doFilter****");
		//A:将ServletRequest对象强制转换为HttpServletRequset类型
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//B:设置字符类型
		/*req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");*/
		req.setCharacterEncoding(characterEncoding);
		resp.setCharacterEncoding(characterEncoding);
		//C:将请求交给下个过滤器或者请求资源处理s
		chain.doFilter(request, response);
	}
	
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("****destroy****");
	}

}
