package com.haiming.messageboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haiming.messageboard.bean.Page;
import com.haiming.messageboard.bean.Theme;
import com.haiming.messageboard.logic.ThemeLogic;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 应该可以肯定page不为空，index.jsp每次都检查page对象是否为空
		Page<Theme> page = (Page<Theme>) session.getAttribute("page");
		ThemeLogic provider = new ThemeLogic();
		String parameter = request.getParameter("action");
		System.out.println(parameter);
		switch (parameter) {
		case "firstPage":
			page.setCurrentPage(0);
			page = provider.getThemes(page);
			session.setAttribute("page", page);
			break;
		case "nextPage":
			// 如果当前已经是最后一页，页面会把连接置失效，但是这里还是要判断
			page = provider.getThemes(page);
			session.setAttribute("page", page);
			break;
		case "prevPage":
			page.setCurrentPage(page.getCurrentPage() - 2);
			page = provider.getThemes(page);
			session.setAttribute("page", page);
			break;
		case "lastPage":
			page.setCurrentPage(page.getTotalPage()  );
			page = provider.getThemes(page);
			session.setAttribute("page", page);
			break;
		case "newTheme":
			//发表新的帖子
			response.sendRedirect("theme.jsp");
			return ;
			 
		}
		response.sendRedirect("index.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
