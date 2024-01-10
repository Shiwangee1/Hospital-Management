package Docter_Login;

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

@WebServlet("/docterlogin1")
public class Docter_login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();
		DocterDao dao = new DocterDao(Dbconnection.getconn());

		// Check if the provided credentials are valid
		Docter_Entity docter = dao.Login(email, password);
	
		System.out.println(" Docter id find in the Doctor Login java page " + docter.getId());
		
		if (docter != null) {
			// Set the authenticated docter in the session
			session.setAttribute("id", docter.getId());
			session.setAttribute("authenticatedDocter", docter);
			resp.sendRedirect("Docter/index.jsp");
		} else {
			resp.sendRedirect("Docter_login.jsp?error=invalidCredentials");
		}
	}
}
