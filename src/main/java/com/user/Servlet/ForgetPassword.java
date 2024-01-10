package com.user.Servlet;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/forgotPassword")
public class ForgetPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        RequestDispatcher dispatcher = null;
        int otpvalue = 0;
        HttpSession mySession = request.getSession();

        try {
            if (email != null && !email.isEmpty()) {
                // Sending OTP
                Random rand = new Random();
                otpvalue = rand.nextInt(1255650);
                System.out.println("Generated OTP: " + otpvalue);

                String to = email;

                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

                Session session = Session.getInstance(props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        // Provide your email and password here
                        return new PasswordAuthentication("shivangeesingh117@gmail.com", "");
                    }
                });

                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("your_email@gmail.com"));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("Password Reset OTP");
                    message.setText("Your OTP is: " + otpvalue);
                    Transport.send(message);

                    System.out.println("Message sent successfully");

                    dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
                    request.setAttribute("message", "OTP is sent to your email id");
                    mySession.setAttribute("otp", otpvalue);
                    mySession.setAttribute("email", email);
                    dispatcher.forward(request, response);

                } catch (MessagingException e) {
                    e.printStackTrace();
                    throw new ServletException("Error sending email", e);
                }
            } else {
                // Handle the case where email is null or empty
                dispatcher = request.getRequestDispatcher("ErrorPage.jsp");
                request.setAttribute("errorMessage", "Email cannot be empty");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception and handle it appropriately
        }
    }
}
