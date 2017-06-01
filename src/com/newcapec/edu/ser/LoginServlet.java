package com.newcapec.edu.ser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.newcapec.edu.entiy.User;
import com.newcapec.edu.manager.DBManager;
@WebServlet(name="LoginServlet",urlPatterns="/LoginServlet")
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
			  
			    PrintWriter out=response.getWriter();
			    Gson gson=new Gson();
			    User user=gson.fromJson(jb.toString(),User.class);
			    String username=user.getUsername();
			    String pswd=user.getPassword();
			    DBManager db=new DBManager();
			    User user1=db.checkInfo(username, pswd);
			    request.getSession().setAttribute("user",user1);
			    if(user1!=null){
			    	out.print(user1.getUsername()+"登陆成功！");
			    }else{
			    	out.print("登录失败！");
			    }
	
	}
}
