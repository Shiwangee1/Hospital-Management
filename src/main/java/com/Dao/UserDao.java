package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Entity.User;

public class UserDao {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean Register(User u) {
		boolean f = false;
		try {
			String sql = "Insert into user_registration (Name,Email,Password) value (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getFullName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPasword());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
	
	public User login(String em,String ps) {
		User u=null;
		try {
			String sql1 = "SELECT * FROM user_registration WHERE Email=? AND Password =?";
			PreparedStatement pstmt1 =conn.prepareStatement(sql1);
			pstmt1.setString(1,em);
			pstmt1.setString(2, ps);
			
		ResultSet rs=pstmt1.executeQuery();
		while(rs.next()) {
			u= new User();
			u.setId(rs.getInt(1));
			u.setFullName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPasword(rs.getString(4));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public boolean checkOldPaassword(int userid,String oldPassword) {
		
		boolean f= false;
		try {
			String sql="Select * from user_registration where id=? and Password =? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2,oldPassword);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return f;
		
	}
	public boolean changePassword(int userid,String newPassword) {
		boolean f = false;
		try {
			String sql="update user_registration set Password=? where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);
			int i =ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	
}
