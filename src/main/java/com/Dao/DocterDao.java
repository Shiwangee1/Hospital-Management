package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Docter_Entity;

public class DocterDao {

	private Connection conn = null;

	public DocterDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerDocter(Docter_Entity d) {
		boolean success = false;
		try {
			String sql = "INSERT INTO docterregister (FullName, DOB, Qulification, Specialist, Email, Mobile_no, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set parameters
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDOB());
			ps.setString(3, d.getQulification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobile());
			ps.setString(7, d.getPassword());

			// Execute the update after setting parameters
			int i = ps.executeUpdate();

			if (i == 1) {
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

	public List<Docter_Entity> getAllDocter() {
		List<Docter_Entity> list = new ArrayList<>();
		Docter_Entity d = null;
		try {
			String sql = "SELECT * FROM docterregister ORDER BY id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Docter_Entity();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDOB(rs.getString(3));
				d.setQulification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobile(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public  Docter_Entity  getByDocterId(int id) {
		Docter_Entity d = null;
		try {
			String sql = "SELECT * FROM docterregister WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Docter_Entity();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDOB(rs.getString(3));
				d.setQulification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobile(rs.getString(7));
				d.setPassword(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}

	public boolean updateDocter(Docter_Entity d) {
		boolean success = false;
		try {
			String sql = "UPDATE docterregister SET FullName=?, DOB=?, Qulification=?, Specialist=?, Email=?, Mobile_no=?, password=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set parameters
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDOB());
			ps.setString(3, d.getQulification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobile());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());

			// Execute the update after setting parameters
			int i = ps.executeUpdate();

			if (i == 1) {
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
	
	public boolean DeleteDocter(int id) {
		
		boolean f=false;
		try {
			String sql="delete from docterregister where id=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i =ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	 public Docter_Entity Login(String email, String password) {
	        Docter_Entity docter = null;
	        try {
	            String sql = "SELECT * FROM docterregister WHERE Email=? AND password=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, email);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                docter = new Docter_Entity();
	                docter.setId(rs.getInt("id"));
	                docter.setFullName(rs.getString("FullName"));
	                docter.setDOB(rs.getString("DOB"));
	                docter.setQulification(rs.getString("Qulification"));
	                docter.setSpecialist(rs.getString("Specialist"));
	                docter.setEmail(rs.getString("Email"));
	                docter.setMobile(rs.getString("Mobile_no"));
	                docter.setPassword(rs.getString("password"));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return docter;
	    }
	 public int countDocter() {
		 int i=0;
		 try {
			 String sql="SELECT * FROM docterregister ";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ResultSet rs =ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }
		 
		return i;
		 
	 }
	 public int countViewDocter() {
		 int i=0;
		 try {
			 String sql="SELECT * FROM appointment ";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ResultSet rs =ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }
		 
		return i;
		 
	 }
	 public int countUser() {
		 int i=0;
		 try {
			 String sql="SELECT * FROM user_registration ";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ResultSet rs =ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }
		 
		return i;
		 
	 }
	 public int countSpecilst() {
		 int i=0;
		 try {
			 String sql="SELECT * FROM specialist ";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ResultSet rs =ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }
		 
		return i;
		 
	 }
	 public int countAppointment() {
		 int i=0;
		 try {
			 String sql="SELECT * FROM appointment ";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ResultSet rs =ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }
		 
		return i;
		 
	 }
	 public int CountAppointmentbydocterid(int did) {
		 int i=0;
		 
		 try {
			 String sql="Select * from appointment where Docter_id=? ";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1,did);
			 ResultSet rs= ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return i;
		 
	 }
	 public boolean checkOldPaassword(int userid,String oldPassword) {
			
			boolean f= false;
			try {
				String sql="Select * from docterregister where id=? and password =? ";
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
				String sql="update docterregister set password=? where id=? ";
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
		public boolean EditDocterProfile(Docter_Entity d) {
			boolean success = false;
			try {
				String sql = "UPDATE docterregister SET FullName=?, DOB=?, Qulification=?, Specialist=?, Email=?, Mobile_no=? WHERE id=?";
				PreparedStatement ps = conn.prepareStatement(sql);

				// Set parameters
				ps.setString(1, d.getFullName());
				ps.setString(2, d.getDOB());
				ps.setString(3, d.getQulification());
				ps.setString(4, d.getSpecialist());
				ps.setString(5, d.getEmail());
				ps.setString(6, d.getMobile());
				
				ps.setInt(7, d.getId());

				// Execute the update after setting parameters
				int i = ps.executeUpdate();

				if (i == 1) {
					success = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return success;
		}
}
