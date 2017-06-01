package com.newcapec.edu.ser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);    
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        // 设置编码形式    
        request.setCharacterEncoding("utf-8");   
        response.setCharacterEncoding("utf-8");   
        // 获取传入数据    
			StringBuffer jb = new StringBuffer();
			  String line = null;
			  
			    BufferedReader reader = request.getReader();
			    while ((line = reader.readLine()) != null){
			      jb.append(line);
			    }
			    System.out.println("获取到的数据="+jb.toString());
	
	}
}
