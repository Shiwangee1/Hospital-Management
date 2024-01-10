package com.AdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.SpeciallistDao;
import com.Db.Dbconnection;
@WebServlet("/addSecp")
public class addSpeciallist extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String spec_name=req.getParameter("specName");
		SpeciallistDao dao= new SpeciallistDao(Dbconnection.getconn());
		boolean f= dao.addSpecialist(spec_name);
		HttpSession session= req.getSession();
		if(f) {
			session.setAttribute("succMsg","Speclist add succesfully");
			resp.sendRedirect("Admin_login.jsp");
		}
		else {
			session.setAttribute("errorMsg","try agin");
			
			resp.sendRedirect("Admin/index.jsp");
		}
	}

}
