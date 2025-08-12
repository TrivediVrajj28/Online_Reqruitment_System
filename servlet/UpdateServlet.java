package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.jobseekerdao;
import com.pojo.jobseeker;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		jobseeker js = new jobseeker();
		js.setId(id);
		js.setName(name);
		js.setEmail(email);
		js.setPassword(password);

		int status = jobseekerdao.jobseekerupdate(js);

		if (status > 0) {
			response.sendRedirect(request.getContextPath() + "/ViewServlet");
		} else {
			response.getWriter().println("Update failed.");
		}

	}
}
