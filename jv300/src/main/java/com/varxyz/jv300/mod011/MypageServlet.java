package com.varxyz.jv300.mod011;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mod011/mypage")
public class MypageServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private UserService userService;
   
   public void init() {
      userService = UserService.getInstance();
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      HttpSession session = request.getSession(false); // false는 세션있을때만 연결
      String userId = (String) session.getAttribute("userId"); // 세션의 "userId"키값의 value값을 가져옴
      if(userId == null) { // 아이디가 없을 경우(즉, 로그인하지 않고 mypage에 접근한 경우)
         request.getRequestDispatcher("login.jsp").forward(request, response); // 로그인페이지로 넘어감
         return;
      }
      
      // 쿠키를 만들지 않아도 쿠키는 존재함.
      // 여기서는 세션아이디가 쿠키
      Cookie[] cookies = request.getCookies();
      for(Cookie cookie : cookies) {
    	  // 쿠키는 Map형식이므로 key값과 value값을 가짐
    	  // 여기서는 getName()이 key값을 가져오고 getValue()가 value값을 가져옴
    	  System.out.println(cookie.getName() + " : " + cookie.getValue());
    	  if(cookie.getName().equals("lastAccessTime")) {
    		  // 로그인시 방문시간 확인
    		  request.setAttribute("lastAccessTime", URLDecoder.decode(cookie.getValue(), "UTF-8")); // 쿠키의 "lastAccessTime"키값의 값을 디코드하여 setAttribute함
    	  }
      }
      response.addCookie(lastAccessTime()); // 쿠키를 추가하여 보냄
      
      request.getRequestDispatcher("mypage.jsp").forward(request, response); // jsp로 넘어감
   }
   
   private Cookie lastAccessTime() {
	   // 2022-07-08+09%3A41%3A41 이런식으로 나오는 값을 아래의 형태로 포맷해줌
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String dateStr = format.format(new Date()); // 현재 시간값을 넣어줌
	   
	   Cookie cookie = null;
	   try {
		   cookie = new Cookie("lastAccessTime", URLEncoder.encode(dateStr, "UTF-8")); // 쿠키의 "lastAccessTime"키값에 dateStr을 인코드한 값을 value값으로 넣어줌
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   cookie.setMaxAge(60 * 60 * 24 * 30); // 한달까지 보관 보장
	   cookie.setPath("/"); // 최상위경로인 /(root)이후로 접속시 쿠키 저장
	   
	   return cookie; // 쿠키 반환
   }
}
