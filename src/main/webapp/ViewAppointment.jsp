<%@page import="com.Entity.User"%>
<%@page import="com.Entity.Docter_Entity"%>
<%@page import="com.Dao.DocterDao"%>
<%@page import="com.Entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.Dbconnection"%>
<%@page import="com.Dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment List</title>
<%@include file="Componet/allCss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<c:if test="${empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<%@include file="Componet/navbar.jsp"%>

	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appoint Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>
								<%
								try {
									int userId = (int) session.getAttribute("id");
									AppointmentDao dao = new AppointmentDao(Dbconnection.getconn());
									DocterDao dao2 = new DocterDao(Dbconnection.getconn());
									List<Appointment> list = dao.getAllAppointmentByLoginUser(userId);
									for (Appointment ap : list) {
										Docter_Entity d = dao2.getByDocterId(ap.getDocterId());
								%>
								<tr>
									<th><%=ap.getFullname()%></th>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppointmentdate()%></td>
									<td><%=ap.getDisease()%></td>
									<td><%=d.getFullName()%></td>

									<td>
										<%=ap.getApp_status() %>
									</td>
								</tr>
								<%
								}
								} catch (Exception e) {
								e.printStackTrace();
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3 p-3">
				<img alt="" src="img/doct.jpg">
			</div>
		</div>
	</div>
</body>
</html>
