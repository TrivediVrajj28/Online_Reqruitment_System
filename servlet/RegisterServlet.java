package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.jobseekerdao;
import com.pojo.jobseeker;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String pname = request.getParameter("name");
		String pemail = request.getParameter("email");
		String ppassword = request.getParameter("password");

		jobseeker j = new jobseeker();
		j.setName(pname);
		j.setEmail(pemail);
		j.setPassword(ppassword);

		int b = jobseekerdao.datainsert(j);

		if (b > 0) {
			out.print("Record saved successfully!");
		} else {
			out.print("Sorry! unable to save record");
		}

	}

}
