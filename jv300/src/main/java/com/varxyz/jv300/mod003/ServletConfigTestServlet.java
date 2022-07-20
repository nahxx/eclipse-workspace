package com.varxyz.jv300.mod003;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTestServlet extends HttpServlet {
	private static final String DEFAULT_SEASON = "Spring, Summer, Fail, Winter";
	private String[] seasons;
	
	@Override
	public void init() throws ServletException {
		String season_list = getInitParameter("season-list"); // getInitParameter 메서드는 부모의 메서드(부모의 메서드는 내꺼)
		// init의 초기 파라미터를 가져오는 메서드
		// 초기화는 web.xml에서 해줌
		if(season_list == null) {
			season_list = DEFAULT_SEASON;
		}
		seasons = season_list.split(", ");
		System.out.println(season_list);
	} 
	
	/*
	@Override
	public void init(ServletConfig config) throws ServletException {
		String season_list = config.getInitParameter("season_list"); // getInitParameter 메서드는 부모의 메서드(부모의 메서드는 내꺼)
		// init의 초기 파라미터를 가져오는 메서드
		// 초기화는 web.xml에서 해줌
		if(season_list == null) {
			season_list = DEFAULT_SEASON;
		}
		seasons = season_list.split(", ");
		System.out.println(season_list);
	}
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>Servlet Config Test</h3>");
		out.println("<ul>");
		for(String season : seasons) {
			out.println("<li>" + season + "</li>");
		}
		out.println("</ul>");
		// br태그는 줄바꿈 용도로 사용, p태그는 단락을 나눌 때 사용
		out.println("</body></html>");
		out.close();
	}
}
