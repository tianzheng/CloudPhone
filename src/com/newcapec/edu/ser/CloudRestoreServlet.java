package com.newcapec.edu.ser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.newcapec.edu.entiy.PhoneNum;
import com.newcapec.edu.entiy.User;
import com.newcapec.edu.manager.DBManager;

/**
 * Servlet implementation class CloudRestoreServlet
 */
@WebServlet("/CloudRestoreServlet")
public class CloudRestoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudRestoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   User user=(User) request.getSession().getAttribute("user");
   int id=user.getUser_id();
   DBManager db=new DBManager();
  PrintWriter printWriter = response.getWriter();
    List<PhoneNum> list=db.restorePhoneNum(id);
    String info="";
   for(PhoneNum li:list){
	   info=info+li.getName()+","+li.getNum()+"  ";
   }
   printWriter.write(info);
   
  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
