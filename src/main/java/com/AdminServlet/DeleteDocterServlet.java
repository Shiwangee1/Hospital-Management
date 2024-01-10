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
@WebServlet("/deleteDocter")
public class DeleteDocterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		DocterDao dao= new DocterDao(Dbconnection.getconn());
		HttpSession session = req.getSession();
		if(dao.DeleteDocter(id)) {
			resp.sendRedirect("Admin/viewdocter.jsp");
		}
		else {
			resp.sendRedirect("Admin/viewdocter.jsp");
		}
	}
	
	

}
