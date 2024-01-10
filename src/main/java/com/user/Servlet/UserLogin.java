package com.user.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.DocterDao;
import com.Dao.UserDao;
import com.Db.Dbconnection;
import com.Entity.User;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		UserDao dao = new UserDao(Dbconnection.getconn());
		User user = dao.login(email, password);
		System.out.println(" User id : " + user.getId());
		int id = user.getId();
		if (user != null) {
			session.setAttribute("id", id);
			session.setAttribute("userObj", new User());

			resp.sendRedirect("UserAppointtment.jsp");
		} else {
			session.setAttribute("errorMsg", "invalid email & password");
			resp.sendRedirect("user_login.jsp");
		}

	}

}
