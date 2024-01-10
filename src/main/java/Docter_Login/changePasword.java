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
@WebServlet("/changepassword")
public class changePasword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid= Integer.parseInt(req.getParameter("uid"));
		String oldpassword= req.getParameter("newPassword");
		String newPassword = req.getParameter("oldPassword");
		DocterDao dao = new DocterDao(Dbconnection.getconn());
		HttpSession session = req.getSession();
		if(dao.checkOldPaassword(uid, oldpassword)) {
			if(dao.changePassword(uid, newPassword)) {
			session.setAttribute("SuccMsg", "successfully change password");
			resp.sendRedirect("Docter/Edit_Doctor.jsp");
		}
			else {
				session.setAttribute("ErrMsg", "Something went wrong");
				resp.sendRedirect("Docter/Edit_Doctor.jsp");
			}
			
			
	}
		else {
			session.setAttribute("ErrMsg", "Invlaid Password");
			resp.sendRedirect("Docter/Edit_Doctor.jsp");
		}
	

}
}
