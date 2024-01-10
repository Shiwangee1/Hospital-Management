<%@ page import="java.util.*"%>
<%@ page import="com.Dao.*"%>
<%@ page import="com.Entity.*"%>
<%@ page import="com.Db.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<%@include file="Componet/allCss.jsp"%>
</head>
<body>
	<%
	Docter_Entity docter =(Docter_Entity) session.getAttribute("authenticatedDocter");
	%>

	<%@include file="Componet/navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<p class="text-center fs-3">Change Password</p>

					<div class="card-body">
						<form action="#" method="post">
							<div class="mb-3">
								<label>Enter New Password</label> <input type="text"
									name="newPassword" class="form-control" required
									>
							</div>

							<div class="mb-3">
								<label>Enter Old Password</label> <input type="text"
									name="oldPassword" class="form-control"
									value="" required>
							</div>
							<input type="hidden" value="" name="uid">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-5 offset-md-2">
				<div class="card paint-card">
					<p class="text-center fs-3">Edit Profile</p>

					<div class="card-body">
						<form action="#" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control"
									value="<%=docter.getFullName()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control"
									value="<%=docter.getDOB()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									name="qualification" type="text" class="form-control"
									value="<%=docter.getQulification()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									required class="form-control">
									<option><%=docter.getSpecialist() %></option>

									<%
									SpeciallistDao dao = new SpeciallistDao(Dbconnection.getconn());
									List<Specalist> list = dao.getAllSpecialist();
									for (Specalist s : list) {
									%>
									<option><%=s.getSpeciallistName()%></option>
									<%
									}
									%>


								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									readonly required name="email" class="form-control"
									value="<%=docter.getEmail()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobno" class="form-control"
									value="<%=docter.getMobile()%>">
							</div>

							<input type="hidden" name="id" value="<%=docter.getId()%>">
							<button type="submit" class="btn btn-primary">Update</button>
						</form>

					</div>
				</div>
			</div>


		</div>
	</div>


</body>
</html>