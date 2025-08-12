package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.jobseekerdao;
import com.pojo.jobseeker;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		jobseeker js = jobseekerdao.checkLogin(email, password);// authentication with db

		if (js != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", js.getName());// store name throgh session:"username"
			response.sendRedirect("welcome.jsp");
		} else {
			request.setAttribute("msg", "Invalid email or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
