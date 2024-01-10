<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.Dao.SpeciallistDao"%>
<%@ page import="com.Entity.Specalist"%>
<%@ page import="com.Db.Dbconnection"%>
<%@ include file="../Componet/allCss.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.Entity.Docter_Entity"%>
<%@ page import="com.Dao.DocterDao"%>
<script src="https://kit.fontawesome.com/f327e1d3d1.js" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Details</title>
    <%@ include file="../Componet/allCss.jsp"%>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 0 10px 0 rgba(0, 0, 0, 0.3);
            max-height: 400px; /* Set the max height for the card */
            overflow-y: auto; /* Add vertical scrollbar if needed */
        }

        /* Add the following style for the table shadow */
        .table-shadow {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-height: 300px; /* Set the max height for the table */
            overflow-y: auto; /* Add vertical scrollbar if needed */
        }
    </style>
</head>
<body>
    <%@ include file="navbar.jsp"%>
    <div class="container-fluid p-3">
        <div class="row">
            <div class="col-md-12 offset-md-12">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="fs-3 text-center">Doctor Details</p>
                        <table class="table table-shadow">
                            <thead>
                                <tr>
                                    <th scope="col">FullName</th>
                                    <th scope="col">Dob</th>
                                    <th scope="col">Qualification</th>
                                    <th scope="col">Specialist</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Mobile number</th>
                                    <th scope="col">Password</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <%
                            try {
                                DocterDao dao2 = new DocterDao(Dbconnection.getconn());
                                List<Docter_Entity> list1 = dao2.getAllDocter();
                                if (list1 != null) {
                                    for (Docter_Entity d : list1) {
                            %>
                            <tr>
                                <td><%=d.getFullName()%></td>
                                <td><%=d.getDOB()%></td>
                                <td><%=d.getQulification()%></td>
                                <td><%=d.getSpecialist()%></td>
                                <td><%=d.getEmail()%></td>
                                <td><%=d.getMobile()%></td>
                                <td><%=d.getPassword()%></td>
                                <td>
                                    <a href="Edit_docter.jsp?id=<%=d.getId()%>"><i class="fa-regular fa-pen-to-square"></i></a>
                                    <a href="../deleteDocter?id=<%=d.getId()%>"><i class="fa-solid fa-trash-can"></i></a>
                                </td>
                            </tr>
                            <%
                            }
                            } else {
                            %>
                            <tr>
                                <td colspan="8">No data available</td>
                            </tr>
                            <%
                            }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            %>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- Add other script includes if needed -->
</body>
</html>
