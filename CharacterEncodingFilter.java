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
		//��Web.xml�л�ȡ�ַ���
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
		//A:��ServletRequest����ǿ��ת��ΪHttpServletRequset����
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//B:�����ַ�����
		/*req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");*/
		req.setCharacterEncoding(characterEncoding);
		resp.setCharacterEncoding(characterEncoding);
		//C:�����󽻸��¸�����������������Դ����s
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
