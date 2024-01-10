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
import com.Entity.User;

@WebServlet("/userlogin1")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // TODO
																													// Auto-generated
																													// method
		try {
			String fullName = req.getParameter("name");
			String Email = req.getParameter("email");
			String Password = req.getParameter("password");

			User u = new User(fullName, Email, Password);
			UserDao Dao = new UserDao(Dbconnection.getconn());
			HttpSession session = req.getSession();
			boolean f = Dao.Register(u);
			if (f) {
				/* session.setAttribute("Sucmsg", "Register Successfully"); */
				resp.sendRedirect("signup.jsp");
				System.out.println("insert suceesfully data");
			} else {
				/* session.setAttribute("errormsg", "please try again"); */
				resp.sendRedirect("signup.jsp");
				System.out.println("not insert sucess fully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}