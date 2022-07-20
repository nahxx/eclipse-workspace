package com.varxyz.jv300.mod004;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/mod004/file_upload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2, 	// 2MB정도
		maxFileSize = 1024 * 1024 * 10,			// 10MB
		maxRequestSize = 1024 * 1024 * 50		// 50MB
		)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "C:/temp";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		File saveDir = new File(SAVE_DIR);
		
		/*
		 * 파일 가져올 때 header 부분도 가져옴
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()) {
			String header = en.nextElement();
			System.out.println(header + " = " + request.getHeader(header));
		}
		*/
		
		if(!saveDir.exists()) { // saveDir 폴더가 없으면
			saveDir.mkdir(); // 만들어라
		}
		for(Part part : request.getParts()) {
			part.write(saveDir.getPath() + File.separator + extractFileName(part));
			// saveDir.getPath() => c:\temp
			// File.separator(윈도우의 separator는 \역슬래시) => \
			// extractFileName(part) => eclipse.ini
			
			// 다 합치면 c:\temp\eclipse.ini
			// 해당 경로에 요청에서 받은 Parts의 part를 쓰기
		}
		
		response.setContentType("text/html; charset=UTF=8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3> Upload has been done successfully. </h3>");
	    out.println("</body></html>");
	    out.close();
		
	}
	
	/**
	 * 파일 이름 추출 메서드
	 * @param part
	 * @return
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("Content-Disposition");
		System.out.println("content-Disposition : " + contentDisp);
		// 출력 => content-Disposition : form-data; name="attachedFile"; filename="eclipse.ini"
		for(String s : contentDisp.split(";")) {
			if(s.contains(File.separator)) { // File.separator ( 구분자가 포함되어 있다면 => filename이 경로로 적혀있다면 )
				return s.substring(s.lastIndexOf(File.separator) + 1).replace("\"", ""); // 경로 마지막에 있는 파일이름만 반환
			} else { // 그렇지 않고 filename에 나처럼 파일이름만 나와있다면
				if(s.contains("filename=")) {
					return s.substring("filename=".length() + 1).replace("\"", ""); // 파일이름만 반환
				}
			}
		}
		return "";
	}

}
