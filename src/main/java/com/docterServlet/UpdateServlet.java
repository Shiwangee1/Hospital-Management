package com.docterServlet;

import java.io.IOException;
import com.Dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.Dbconnection;
@WebServlet("/UpdateCommt")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			int docter_id = Integer.parseInt(req.getParameter("did"));
		
			String comm = req.getParameter("comm");
			AppointmentDao dao= new AppointmentDao(Dbconnection.getconn());
			HttpSession session =req.getSession();
			if(dao.UpdateComments(id, docter_id, comm)) {
				session.setAttribute("SuccMsg","comments Sucessfully ");
				resp.sendRedirect("Docter/patient.jsp");
			}
			else {
				session.setAttribute("Error", "not updated");
				resp.sendRedirect("Docter/patient.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
