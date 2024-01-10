package com.AdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.DocterDao;
import com.Db.Dbconnection;
import com.Entity.Docter_Entity;
@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Fullname=req.getParameter("fullname");
		String DOB = req.getParameter("dob");
		String qulification = req.getParameter("qulification");
		String specification =req.getParameter("spec");
		String email= req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String password =req.getParameter("password");
		int id= Integer.parseInt(req.getParameter("id"));
		
		Docter_Entity d= new Docter_Entity(id,Fullname,DOB,qulification,specification,email,mobile,password);
		DocterDao dao = new DocterDao(Dbconnection.getconn());
		HttpSession session = req.getSession();
		if(dao.updateDocter(d)) {
			resp.sendRedirect("Admin/viewdocter.jsp");
			
		}
		else {
			resp.sendRedirect("Admin_login.jsp");
		}
	
	}

}
