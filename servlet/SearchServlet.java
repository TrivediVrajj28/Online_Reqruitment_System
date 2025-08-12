package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.jobseekerdao;
import com.pojo.jobs;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        List<jobs> list = jobseekerdao.searchJobs(keyword);

        request.setAttribute("list", list);//list refrel use for show table records dynamically
        request.getRequestDispatcher("searchjobs.jsp").forward(request, response);
    }
}

