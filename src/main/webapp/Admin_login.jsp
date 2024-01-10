<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <%@ include file="Componet/allCss.jsp"%>
</head>
<style>
    .pain-card {
        box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
    }
</style>
<body>
    <%@include file="Componet/navbar.jsp"%>

    <div class="container p-5">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card pain-card">
                    <div class="card-body">
                        <p class="fs-4 text-center">Admin Login</p>
                        <c:if test="${not empty SuccMsg}">
                            <p class="text-center text-success fs-3">${SuccMsg}</p>
                            <c:remove var="SuccMsg" scope="session" />
                        </c:if>
                        <c:if test="${not empty ErrorMsg}">
                            <p class="text-center text-success fs-3">${ErrorMsg}</p>
                            <c:remove var="ErrorMsg" scope="session" />
                        </c:if>

                        <form action="adminlogin" method="Post">
                            <div class="md-3">
                                <label class="form-label">Email</label>
                                <input required name="email" type="email" class="form-control">
                            </div>
                            <div class="md-3">
                                <label class="form-label">Password</label>
                                <input class="form-control" name="password" type="password">
                            </div>
                            <br>
                            <button type="submit" class="btn btn-success text-white text-center" style="width: 300px;">Submit</button>
                            <br> Don't have an Account ? <a href="signup.jsp" class="text-decoration-none">Create one</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
