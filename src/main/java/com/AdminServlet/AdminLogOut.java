package com.AdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminLogout")
public class AdminLogOut extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session = req.getSession();
	session.removeAttribute("SuccMsg");
	session.setAttribute("sucMsg", "Logout successfully");
	resp.sendRedirect("Admin_login.jsp");
	}

}
