<%@page import="com.Db.Dbconnection"%>
<%@page import="com.Dao.DocterDao"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.Entity.Docter_Entity"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Appointment</title>
<%@include file="Componet/allCss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
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
	<%
	int userId = (int) session.getAttribute("id");
	%>
	<%-- <%@include file="User/navbar.jsp"%> --%>



	<!--navbar start  -->

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@page isELIgnored="false"%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"><i
				class="fas fa-clinic-medical"></i> MEDI HOME</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

					<c:if test="${empty userObj }">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="admin_login.jsp"><i
								class="fas fa-sign-in-alt"></i> ADMIN</a></li>

						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="doctor_login.jsp">DOCTOR</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="ViewAppointment.jsp">APPOINTMENT</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="ViewAppointment.jsp">USER</a></li>

					</c:if>




					<c:if test="${not empty userObj }">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="UserAppointtment.jsp">APPOINTMENT</a></li>

						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="ViewAppointment.jsp">VIEW
								APPOINTMENT</a></li>

						<div class="dropdown">
							<a class="btn btn-secondary dropdown-toggle" href="#"
								role="button" id="dropdownMenuLink" data-bs-toggle="dropdown"
								aria-expanded="false">  ${userObj.fullName}</a>

							<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
								<li><a class="dropdown-item" href="Edit_Profile.jsp">Edit
										Profile</a></li>
								<li><a class="dropdown-item"
									href="ChangePassword.jsp?id=<%=userId%>">Change Password</a></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul>
						</div>



					</c:if>





				</ul>
			</div>
		</div>
	</nav>


	<!-- navbar end -->















	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 p-5">
				<img alt="" src="img/india1.jpg" height="70%" width="60%">
			</div>

			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">User Appointment</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>


						<form class="row g-3" action="appAppointment" method="post">

							<input type="hidden" name="userid" value="<%=userId%>">

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Full Name</label> <input
									required type="text" class="form-control" name="fullname">
							</div>

							<div class="col-md-6">
								<label>Gender</label> <select class="form-control" name="gender"
									required>
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Age</label> <input
									required type="number" class="form-control" name="age">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Appointment
									Date</label> <input type="date" class="form-control" required
									name="appoint_date">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Email</label> <input
									required type="email" class="form-control" name="email">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Phone No</label> <input
									maxlength="10" required type="number" class="form-control"
									name="phno">
							</div>


							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Diseases</label> <input
									required type="text" class="form-control" name="diseases">
							</div>

							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Doctor</label> <select
									required class="form-control" name="doct">
									<option value="">--select--</option>

									<%
									DocterDao dao = new DocterDao(Dbconnection.getconn());
									List<Docter_Entity> list = dao.getAllDocter();
									for (Docter_Entity d : list) {
									%>
									<option value="<%=d.getId()%>"><%=d.getFullName()%> (<%=d.getSpecialist()%>)
									</option>
									<%
									}
									%>




								</select>
							</div>

							<div class="col-md-12">
								<label>Full Address</label>
								<textarea required name="address" class="form-control" rows="3"
									cols=""></textarea>
							</div>

							<c:if test="${empty userObj }">
								<a href=User_login.jsp
									" class="col-md-6 offset-md-3 btn btn-success">Submit</a>
							</c:if>

							<c:if test="${not empty userObj }">
								<button class="col-md-6 offset-md-3 btn btn-success">Submit</button>
							</c:if>
							<input type="submit" name="button" class="btn btn success">
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="Componet/footer.jsp"%>

</body>
</html>