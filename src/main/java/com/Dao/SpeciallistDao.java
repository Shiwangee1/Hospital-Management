package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.Entity.Specalist;

public class SpeciallistDao extends HttpServlet {
	private Connection conn;

	public SpeciallistDao(Connection conn) {
		super();
		this.conn = conn;
	}

public boolean addSpecialist(String spec) {
	boolean f=false;
	try {
		String Sql="insert into Specialist(Speciallist_name) values (?)";
		PreparedStatement ps =conn.prepareStatement(Sql);
		ps.setString(1,spec );
		int i=ps.executeUpdate();
		if(i==1) {
			f=true;
		}	}
		catch(Exception e) {
		e.printStackTrace();
		}
	
	return f;
	
}
public List<Specalist> getAllSpecialist(){
	List<Specalist> list = new ArrayList <Specalist>();
	Specalist s=null;
	try {
		String sql="Select * from Specialist ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s=new Specalist();
			s.setId(rs.getInt(1));
			s.setSpeciallistName(rs.getString(2));
			list.add(s);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	return list;
	
}

}
