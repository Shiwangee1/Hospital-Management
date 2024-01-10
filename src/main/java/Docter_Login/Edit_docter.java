package Docter_Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DocterDao;
import com.Db.Dbconnection;
import com.Entity.Docter_Entity;
@WebServlet("/editDocter")
public class Edit_docter extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String fullname=req.getParameter("fullname");
		     String Dob = req.getParameter("dob");
		     String qulification = req.getParameter("qulification");
		     String spec = req.getParameter("spec");
		     String email = req.getParameter("email");
		     String mobile = req.getParameter("mobile");
				 int id = Integer.parseInt(req.getParameter("id")); 
		try {
	  
			/*
			  System.out.println(fullname); System.out.println(date);
			  System.out.println(qulification); System.out.println(spec);
			  System.out.println(email); System.out.println(mobile);*/
				/* System.out.println(id); */
			 Docter_Entity dao = new Docter_Entity(id ,fullname,Dob,qulification,spec,email,mobile);
			 DocterDao dao1= new DocterDao(Dbconnection.getconn());
			boolean f= dao1.EditDocterProfile(dao);
			 
			if(f==true) {
				resp.sendRedirect("");
			}
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	    
	}
	

}
