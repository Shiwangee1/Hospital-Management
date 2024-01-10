<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.Entity.Docter_Entity" %>
<%@ page import="com.Dao.AppointmentDao" %>
<%@ page import="com.Db.Dbconnection" %>
<%@ page import="com.Entity.Appointment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Dao.DocterDao" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Details</title>
    <%@include file="../Componet/allCss.jsp" %>
    <style>
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
        .table-container {
            max-height: 400px; /* Set the desired height */
            overflow-y: auto;
        }
    </style>
</head>
<body>
    <%@include file="navbar.jsp" %>

    <div class="container p-5">
        <div class="row">
            <div class="col-md-12">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="fs-3 text-center">PATIENT DETAILS</p>
                        <c:choose>
                            <c:when test="${not empty authenticatedDocter}">
                                <div class="table-container">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">FullName</th>
                                                <th scope="col">Gender</th>
                                                <th scope="col">Age</th>
                                                <th scope="col">Date</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Mobile</th>
                                               <th scope="col">Disease</th>
                                               <th scope="col">Address</th>
                                               <th scope="col">Docter Name</th>
                                               <th scope="col">Status </th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                              AppointmentDao dao = new AppointmentDao(Dbconnection.getconn());
                                              DocterDao dao2 = new DocterDao(Dbconnection.getconn());
                                              List<Appointment>list = dao.getAllAppointment();
                                              for(Appointment ap :list){
                                                  Docter_Entity d = dao2.getByDocterId(ap.getDocterId());
                                            %>  
                                            <tr>
                                                <td><%=ap.getFullname() %></td>
                                                <td><%=ap.getGender() %></td>
                                                <td><%=ap.getAge() %></td>
                                                <td><%=ap.getAppointmentdate() %></td>
                                                <td><%=ap.getEmail() %></td>
                                                <td><%=ap.getPhno() %></td>
                                                <td><%=ap.getDisease() %></td>
                                                <td><%=ap.getAddress() %></td>
                                                
                                                <td><%=d.getFullName()%></td>
                                                <td><%=ap.getApp_status()%></td>
                                               
                                                <td><a href="Comments.jsp?id=<%=ap.getId()  %>" class="btn btn-success btn-sm">
                                                    <i class="fas fa-comment"></i> Comments
                                                </a></td>
                                            </tr>
                                            <%} %>    
                                        </tbody>
                                    </table>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <p>No authenticated doctor found.</p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
