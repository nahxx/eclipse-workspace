package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiplicationTableServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageTitle = "Multiplication Table";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title>");
		out.println("<style>h3 { display: inline-block; margin-left: 23px; color: #888; background: pink; }p { display: flex; } span { width: 100px; text-align: center; }</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>구구단</h3>");
		out.println(getMultiplicationTable(9));
		out.println("</body></html>");
		out.close();
	}
	
	protected String getMultiplicationTable(int num) {
		String result = "";
		for(int i = 1; i <= num; i++) {
			result += "<p>";
			for(int j = 2; j <= num; j++) {
				result += "<span>" + j + "X" + i + "=" + (j * i) + "</span>";
			}
			result += "</p>";
		}
		return result;
	}
}
