package com.newcapec.edu.ser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.newcapec.edu.entiy.User;
import com.newcapec.edu.manager.DBManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//获取输入数据
		StringBuffer userinfo = new StringBuffer();
		String line = null;
		//提取数据
		BufferedReader br = request.getReader();
		while((line=br.readLine())!=null){
			userinfo = userinfo.append(line);
		}
		String userString = userinfo.toString();
		Gson gson = new Gson();
		User user =  gson.fromJson(userString, User.class);
		
		System.out.println(user.getUsername()+"《《《《《《《《正在注册》》》》》》》");
		DBManager reg = new DBManager();
		int regresultNum = reg.addInfo(user);
		boolean result = regresultNum==1?true:false;
		String regs ="注册失败！";
		if(result){
			regs = "注册成功！";
		}
		out.println(user.getUsername()+regs);
		System.out.println(user.getUsername()+regs);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
