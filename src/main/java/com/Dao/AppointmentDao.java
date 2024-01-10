package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Appointment;

public class AppointmentDao {
	private Connection conn;

	public AppointmentDao(Connection conn) {
		this.conn = conn;
	}

	public boolean addAppointment(Appointment ap) {
		boolean f = false;
		try {
			String sql = "INSERT INTO appointment ( userId,FullName, Gender, age, Appointment_Date, Email, Phno, Diseases, Docter_id, Address, App_Status) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ap.getUserid());
			ps.setString(2, ap.getFullname());
			ps.setString(3, ap.getGender());
			ps.setInt(4, ap.getAge());
			ps.setString(5, ap.getAppointmentdate());
			ps.setString(6, ap.getEmail());
			ps.setString(7, ap.getPhno());
			ps.setString(8, ap.getDisease());
			ps.setInt(9, ap.getDocterId());
			ps.setString(10, ap.getAddress());
			ps.setString(11, ap.getApp_status());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Appointment> getAllAppointments() {
		List<Appointment> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM appointment";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Appointment ap = new Appointment(); // Create a new Appointment object for each row
				 ap.setId(rs.getInt(1)); 
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppointmentdate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhno(rs.getString(8));
				ap.setDisease(rs.getString(9));
				ap.setDocterId(rs.getInt(10)); // Assuming DocterId is a long
				ap.setAddress(rs.getString(11));
				ap.setApp_status(rs.getString(12));
				list.add(ap);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Appointment> getAllAppointmentsBydocterLogin(int docterid) {
		List<Appointment> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM appointment WHERE Docter_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, docterid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Appointment app = new Appointment();
				app.setFullname(rs.getString(3));
				app.setGender(rs.getString(4));
				app.setAge(rs.getInt(5));
				app.setAppointmentdate(rs.getString(6));
				app.setEmail(rs.getString(7));
				app.setPhno(rs.getString(8));
				app.setDisease(rs.getString(9));
				app.setDocterId(rs.getInt(10)); // Assuming DocterId is a long
				app.setAddress(rs.getString(11));
				app.setApp_status(rs.getString(12)); // Update index to 12
				list.add(app);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Appointment getAppointmentById(int id) {

		Appointment ap = null;
		try {
			String sql = "Select * from appointment where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppointmentdate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhno(rs.getString(8));
				ap.setDisease(rs.getString(9));
				ap.setDocterId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setApp_status(rs.getString(12));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ap;

	}

	public List<Appointment> getAllAppointmentByLoginUser(int userId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		try {
			String sql = "Select * from appointment where userId=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppointmentdate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhno(rs.getString(8));
				ap.setDisease(rs.getString(9));
				ap.setDocterId(rs.getInt(10));
				ap.setApp_status(rs.getString(11));
				ap.setApp_status(rs.getString(12));
				list.add(ap);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<Appointment> getAllAppointment() {

		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		try {
			String sql = "Select * from appointment order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppointmentdate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhno(rs.getString(8));
				ap.setDisease(rs.getString(9));
				ap.setDocterId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setApp_status(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return list;

	}

	public Appointment getAppointmentBYId(int id) {

		Appointment ap = null;
		try {
			String sql = "Select * from appointment where Docter_id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppointmentdate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhno(rs.getString(8));
				ap.setDisease(rs.getString(9));
				ap.setDocterId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setApp_status(rs.getString(12));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ap;

	}
	 public boolean UpdateComments(int id, int docterId, String comm) {
	        boolean f = false; // Initialize f to false
	        try {
	            String sql = "UPDATE appointment SET App_Status = ? WHERE Docter_id = ? or userId = ?";
	            try (PreparedStatement ps = conn.prepareStatement(sql)) {
	                ps.setString(1, comm);
	                ps.setInt(2, docterId);
	                ps.setInt(3, id);

	                int i = ps.executeUpdate();
	                if (i == 1) {
	                    f = true; // Set f to true if the update is successful
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return f;
	    }
	

	public List<Appointment> getAllAppointmentPatients(){
	 List<Appointment>list = new ArrayList<Appointment>();
	 Appointment ap = null;
	 try {
		 String sql="SELECT * FROM appointment ORDER BY id DESC";
		 PreparedStatement ps =conn.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 ap = new Appointment();
			 ap.setId(rs.getInt(1));
			 ap.setUserid(rs.getInt(2));
			 ap.setFullname(rs.getString(3));
			 ap.setGender(rs.getString(3));
			 ap.setAge(rs.getInt(4));
			 ap.setAppointmentdate(rs.getString(5));
			 ap.setEmail(rs.getString(6));
			 ap.setPhno(rs.getString(7));
			 ap.setDisease(rs.getString(8));
			 ap.setDocterId(rs.getInt(9));
			 ap.setAddress(rs.getString(10));
			 ap.setApp_status(rs.getString(12));
			 list.add(ap);
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
		 
	 }
		return list;
		
	}

}
