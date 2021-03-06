package com.newcapec.edu.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.newcapec.edu.entiy.PhoneNum;
import com.newcapec.edu.entiy.User;



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
	public User checkInfo(String username, String password) {
		User user = new User();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u, pw);
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

			} else {
				user = null;
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
		return user;
	}
	
	/**
	 * 判断用户表中是否有相同
	 */
	public  int checkUserName(String username){
		int num=0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u, pw);
			String sql = "select * from user where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next()){
				num=1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
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
	public int addInfo(User user){
		int num=0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u, pw);
			String sql = "insert into user values(0,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3,user.getAddress());
			num=ps.executeUpdate();
		} catch (Exception e) {	
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return num;
	}
	
	/**
	 *添加手机号 
	 */
	public void addPhoneNum(List<PhoneNum> list){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u, pw);
			String sql = "insert into phonenum values(0,?,?,?)";
			ps=conn.prepareStatement(sql);
			for (PhoneNum phoneNum : list) {
				ps.setString(1,phoneNum.getName());
				ps.setString(2, phoneNum.getNum());
				ps.setInt(3,phoneNum.getUser_id());
				ps.executeUpdate();
			}
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
	 *还原手机号 
	 */
	public List<PhoneNum> restorePhoneNum(int id){
		List<PhoneNum> list=new ArrayList<PhoneNum>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, u, pw);
			String sql = "select * from phonenum where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				PhoneNum p=new PhoneNum();
				p.setPhoneNum_id(rs.getInt("phonenum_id"));
				p.setName(rs.getString("name"));
				p.setNum(rs.getString("num"));
				p.setUser_id(rs.getInt("user_id"));
				list.add(p);
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
		return list;
	}
	

}
