package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/req/*") // 경로가 /req/ 뒤에 어떤 파일을 요청하더라도 아래 파일이 실행된다 // 모든 문자열 (파일명)을 의미하는 * 사용가능
@WebServlet("*.act") // 파일명이 .act로 끝나는 모든 파일에 대한 요청 시, 서블릿 실행
public class ReqServlet extends HttpServlet {

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//어떤 주소로 요청이 왔는지
			String uri = req.getRequestURI();
			
			//어떤 브라우저에서 요청을 보냈는지
			String header = req.getHeader("User-Agent"); // "User-Agent 요청헤더값 가져오기
			String agent ="Unknown Browser";
			if(header.contains("Chrome")) {
				agent = "Chrome";
			}else if(header.contains("Trident")) {
				agent = "Internet Explorer";
			}
			
			// 텍스트 형식으로 응답객체 출력 
			PrintWriter out = resp.getWriter();
			out.println("Hello^^*");
			out.println(uri);
			out.println("Your Browser :" + agent);
			
			// 다운로드 형식으로 응답객체 출력시(참고)
			//ServletOutputStream out1 = resp.getOutputStream();
			//out1.write(b);
		}
}