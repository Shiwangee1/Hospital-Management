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
import com.Entity.Docter_Entity;

@WebServlet("/addDocter")
public class AddDocter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String fullname = req.getParameter("fullname");
            String DOB = req.getParameter("dob");
            String qulification = req.getParameter("qulification");
            String Specialist = req.getParameter("spec");
            String email = req.getParameter("email");
            String Mobile = req.getParameter("mobile");
            String Password = req.getParameter("password");

            Docter_Entity d = new Docter_Entity(fullname, DOB, qulification, Specialist, email, Mobile, Password);
            HttpSession session = req.getSession();
            DocterDao dao = new DocterDao(Dbconnection.getconn());
            if (dao.registerDocter(d)) {
                session.setAttribute("DocterOBJ", d);
                resp.sendRedirect("Admin/viewdocter.jsp");
            } else {
                session.setAttribute("DocterOBJ", null);
                resp.sendRedirect("Admin_login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
