package com.newcapec.edu.ser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.newcapec.edu.entiy.User;
import com.newcapec.edu.manager.DBManager;

/**
 * Created by li on 17-6-1.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取输入数据
        PrintWriter printWriter = response.getWriter();
        StringBuffer userinfo = new StringBuffer();
        String line;

        BufferedReader br = request.getReader();
        while((line=br.readLine())!=null){
            userinfo = userinfo.append(line);
        }
        Gson gson = new Gson();
        User user = gson.fromJson(userinfo.toString(),User.class);
        String username = user.getUsername();
        String password = user.getPassword();
        DBManager db = new DBManager();
        User user1 = db.checkInfo(username,password);
        if(user1 != null){
            printWriter.write("登录成功");
        }else {
            printWriter.write("登录失败");
        }
    }
}
