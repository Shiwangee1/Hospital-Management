package com.AdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.AppointmentDao;
import com.Db.Dbconnection;
import com.Entity.Appointment;
import com.Entity.Docter_Entity;

@WebServlet("/appAppointment")
public class AppointmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException {
		System.out.println("Khaleesi Java 1");

		int userId = Integer.parseInt(req.getParameter("userid"));

		System.out.println("Khaleesi Java ");
	
		String fullName = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		String appointmentDate = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String disease = req.getParameter("diseases");
		int doctorId = Integer.parseInt(req.getParameter("doct"));
		String address = req.getParameter("address");
		try {

//			// Validate inputs
//			if (fullName == null || gender == null || appointmentDate == null || email == null || phno == null
//					|| disease == null || address == null) {
//				throw new IllegalArgumentException("Invalid input parameters");
//			}

			// Additional validation can be added based on your requirements
			System.out.println("Khaleesi Java 2");
			Appointment ap = new Appointment(userId, fullName, gender, age, appointmentDate, email, phno, disease,
					doctorId, address, "pending");

			AppointmentDao dao = new AppointmentDao(Dbconnection.getconn());

			HttpSession session = req.getSession();
			if (dao.addAppointment(ap)) {
				System.out.println("Khaleesi Java 3");
				session.setAttribute("SuccMsg", "Appointment submitted successfully");
				session.setAttribute("DocterObj", new Docter_Entity());
				resp.sendRedirect("UserAppointtment.jsp");
			} else {
				System.out.println("Khaleesi Java4 ");
				session.setAttribute("DocterObj", new Docter_Entity());
				resp.sendRedirect("User_login.jsp");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Khaleesi Java 5");
			e.printStackTrace(); // Log the exception for debugging purposes
			HttpSession session = req.getSession();
			session.setAttribute("ErrorMsg", "Invalid input parameters");
			resp.sendRedirect("error.jsp");
		}
	}
}
