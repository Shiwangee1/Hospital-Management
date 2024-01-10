package com.user.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Db.Dbconnection;
import com.Entity.*;

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(req.getParameter("uid"));
		String oldPassword=req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		
		
		
		 System.out.println("user id changepassword .java "+uid );
		UserDao dao = new UserDao(Dbconnection.getconn());
		HttpSession session =req.getSession();
		
		if(dao.checkOldPaassword(uid, oldPassword)) {
			if(dao.changePassword(uid, newPassword)) {
				session.setAttribute("SuccMsg", "PasswordChange");
				resp.sendRedirect("ChangePassword.jsp");
			}
			else {
				session.setAttribute("ErroMsg", "Something went wrong");
				resp.sendRedirect("ChangePassword.jsp");
			}
			
		}
		else {
			session.setAttribute("errMsg", "old password incoreect");
			resp.sendRedirect("ChangePassword.jsp");
		}
		
	
	}

	
}
