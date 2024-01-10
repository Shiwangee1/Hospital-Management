package com.AdminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminlogin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            HttpSession session = req.getSession();

            if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
                session.setAttribute("SuccMsg", "Successfully logged in as admin");
                resp.sendRedirect("Admin/index.jsp");
            } else {
                session.setAttribute("ErrorMsg", "Invalid Email or Password");
                resp.sendRedirect("adminlogin.jsp"); // Redirect back to the login page with an error message
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
