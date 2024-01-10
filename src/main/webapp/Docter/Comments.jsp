<%@page import="com.Dao.AppointmentDao"%>
<%@page import="com.Entity.Appointment"%>
<%@page import="com.Db.Dbconnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comments</title>
<%@include file="allCss.jsp"%>
<style>
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("../img/sonal.jpg"); /* Check the path to the image */
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

form {
	margin-bottom: 20px; /* Adjust the value as needed */
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-4">Patient Comments</p>

						<%
					/* 	int id = Integer.parseInt(request.getParameter("id")); */
						AppointmentDao dao = new AppointmentDao(Dbconnection.getconn());
						Appointment app = dao.getAppointmentById(id);
						%>

						<form action="../UpdateCommt" class="row" method="Post">
							<div class="col-md-6">
								<label>Patient Name</label> <input type="text" readonly
									value="<%=app.getFullname()%>" class="form-control">
							</div>
							<div class="col-md-6">
								<label>Age</label> <input type="text" class="form-control"
									readonly value="<%=app.getGender()%>">
							</div>
							<div class="col-md-6">
								<label>Mobile no</label> <input type="text" class="form-control"
									value="<%=app.getPhno()%>" readonly>
							</div>
							<div class="col-md-6">
								<label>Disease</label> <input type="text" class="form-control"
									value="<%=app.getDisease()%>" readonly>
							</div>
							<div class="col-md-12">
								<label>Comments</label> <input type="text" class="form-control"
									value="<%=app.getApp_status()%>" name="comm" >
							</div>
							<input type="hidden" name="id" value="<%=app.getId()%>">
							<input type="hidden" name="did" value="<%=app.getDocterId()%>">
							<br> <br>
							<button class="md-3 btn btn-primary col-md-6 offset-md-3">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
