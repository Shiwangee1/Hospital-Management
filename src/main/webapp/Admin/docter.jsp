<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.Dao.SpeciallistDao"%>
<%@page import="com.Entity.Specalist"%>
<%@page import="com.Db.Dbconnection"%>
<%@ include file="../Componet/allCss.jsp"%>
<%@page import="java.util.List"%>
<%@ page import="com.Entity.Docter_Entity"%>
<%@page import="com.Dao.DocterDao"%>
<script src="https://kit.fontawesome.com/f327e1d3d1.js"
	crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../Componet/allCss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Docter</p>
						<form action="../addDocter" method="Post">
                          
							<div class="mb-3">
								<%-- <input type="hidden" name="id" value="<%= %>"> --%>

								<label>FullName</label> <input type="text" name="fullname"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>DOB</label> <input TYPE="date" name="dob"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Qulification</label> <input type="text"
									name="qulification" class="form-control">
							</div>
							<div class="mb-3">
								<label>Specialist</label> <select name="spec" required
									class="form-control">
									<option>----Select-----</option>

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
								<label>Email</label> <input type="email" name="email"
									class="form-control" required>
							</div>

							<div class="mb-3">
								<label> Mobile no</label> <input name="mobile"
									class="form-control" type="number" required>
							</div>

							<div class="mb-3">
								<label>Password</label> <input name="password" type="password"
									class="form-control" required>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Sumit</button>
							</div>

						</form>
					</div>
				</div>
			</div>

			<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
			<!-- Add other script includes if needed -->
</body>
</html>
