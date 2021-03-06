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
import com.haiming.messageboard.bean.User;
import com.haiming.messageboard.logic.MessageLogic;
import com.haiming.messageboard.logic.ThemeLogic;
import com.haiming.messageboard.utils.MyTools;

/**
 * Servlet implementation class ThemeServlet
 */
@WebServlet("/ThemeServlet")
public class ThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ThemeLogic themeLogic = new ThemeLogic();
		User u = (User) session.getAttribute("user");
		System.out.println(u);
		String theme = MyTools.changeHTML(MyTools.toUTF8(request.getParameter("theme")));
		Theme t = themeLogic.saveTheme(theme, u);
		String message =MyTools.changeHTML( MyTools.toUTF8(request.getParameter("message")));
		MessageLogic messageLogic = new MessageLogic();
		messageLogic.saveMessage(t, message, u);
		Page<Theme> page = new Page<Theme>(Theme.class);
		session.setAttribute("page", page);
		response.sendRedirect("index.jsp");
	}

}
