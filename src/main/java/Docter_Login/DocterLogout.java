package Docter_Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/docterlogout")
public class DocterLogout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * HttpSession session = req.getSession(); session.removeAttribute("adminObj");
		 * session.setAttribute("sucMsg", "Logout successfully");
		 * resp.sendRedirect("Admin_login.jsp");
		 */
		HttpSession session = req.getSession();
		session.removeAttribute("docterObj");
		resp.sendRedirect("Docter_login.jsp");
	
	}
	

}
