<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.Entity.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <%@include file="Componet/allCss.jsp"%>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
    <%@include file="Componet/navbar.jsp"%>
    <div class="container p-5">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="fs-4 text-center">Change Password</p>
                        <% 
                            // Retrieve id from the query parameter
                            String userIdString = request.getParameter("id");
                            int userId = (userIdString != null) ? Integer.parseInt(userIdString) : 0;

                            // You can use userId in your logic
            
                            // Rest of your code...
                        %>
                        <form action="changePassword" method="post">
                            <div class="mb-2">
                                <label for="newPassword">Enter new Password</label>
                                <input type="password" name="newPassword" id="newPassword" class="form-control" required>
                            </div>
                            <div class="mb-2">
                                <label for="oldPassword">Enter Old Password</label>
                                <input type="password" name="oldPassword" id="oldPassword" class="form-control" required>
                            </div>
                            <input type="hidden" value="<%= userId %>" name="uid">
                            <button type="submit" class="btn btn-success col-md-12">Change Password</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
