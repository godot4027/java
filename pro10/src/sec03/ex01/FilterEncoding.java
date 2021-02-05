package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilterEncoding
 */
//@WebFilter("/*")
public class FilterEncoding implements Filter {
	ServletContext context;
    /**
     * Default constructor. 
     */
    public FilterEncoding() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter ȣ��");
		request.setCharacterEncoding("utf-8");
		
		String context =((HttpServletRequest)request).getContextPath();
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		String realpath = request.getRealPath(pathinfo);
		
		String 	mesg = "Context ���� : " + context + "\n";
		mesg += "pathinfo ���� : " + pathinfo  + "\n";
		mesg += "realpath ���� : " + realpath;
		
		System.out.println(mesg);
				
		long begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		
		System.out.println("�۾��ð� " + (end-begin) + "ms");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init ���ڵ�");
		context = fConfig.getServletContext();
	}

}
