package com.haiming.messageboard.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.haiming.messageboard.bean.User;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter("/AuthorityFilter")
public class AuthorityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorityFilter() {
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
		  
		String loginPage="login.jsp";
		//验证用户是否已经登录
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(true);
		User user = (User) session.getAttribute("user");
		if(user == null){ 
			session.setAttribute("ErrorMessage","没有权限操作，请先登录");
			request.getRequestDispatcher(loginPage).forward(request, response);
		}
		//如果用户已经登录 
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
