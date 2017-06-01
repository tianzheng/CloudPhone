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
 * Servlet implementation class CloudBackupsServlet
 */
@WebServlet("/CloudBackupsServlet")
public class CloudBackupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudBackupsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  PrintWriter printWriter = response.getWriter();
	        StringBuffer PhoneNuminfo = new StringBuffer();
	        String line;
	        DBManager db = new DBManager();
	        BufferedReader br = request.getReader();
	        while((line=br.readLine())!=null){
	        	PhoneNuminfo = PhoneNuminfo.append(line);
	        }
	        Gson gson = new Gson();
	       List<PhoneNum> list= gson.fromJson(PhoneNuminfo.toString(),PhoneNum.class);
	       if(list!=null){
	    	   db.addPhoneNum(list);
	    	   printWriter.write("成功");
	       }else{
	    	   printWriter.write("失败");
	       }
	       
	      /* String  json="{\"username\":\"jintian_2004@163.com\",\"password\":\"123456\",\"address\":\"新开普\"}";
		    
			 
			 LoginBean loginBean= gson.fromJson(json, LoginBean.class);
			 
			 
			 String  json1="{\"username\":\"jintian_2004@163.com\",\"phonelist\":[{\"phonename\":\"晋天正\",\"phone\":\"18616951795\"},{ \"phonename\":\"王大大\",\"phone\":\"18616951794\"}]}";
			    
			 Gson gson1=new Gson();
			 
			 PhoneList phoneList= gson1.fromJson(json1, PhoneList.class);*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
