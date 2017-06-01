package com.newcapec.edu.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DBManager {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/phone";
	String u = "root";
	String pw = "123456";
	ResultSet rs;
	Connection conn = null;
	PreparedStatement ps = null;
	
	/**
	 * @param username
	 * @param password
	 * @return 登陆验证
	 */
	public int checkInfo(String username, String password) {
		int num=0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u, pw);
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				num=1;
			}
		} catch (Exception e) {

		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return num;
	}
	
	
	
	/**
	 * @param username
	 * @param password
	 * @param address
	 * 注册
	 */
	public void addInfo(String username,String password,String address){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u, pw);
			String sql = "insert into user values(0,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3,address);
			int num=ps.executeUpdate();
		} catch (Exception e) {
			
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
	}
	
	/**
	 *添加手机号 
	 */
	public void addPhoneNum(){
		
	}
	
	/**
	 *还原手机号 
	 */
	public void restorePhoneNum(int id){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u, pw);
			String sql = "select * from phonenum where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (Exception e) {

		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
	}
	
	
	
	
}
