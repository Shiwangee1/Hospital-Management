<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	  <%--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	   <%@page isElIgnored="false" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Docter Login Page</title>
<%@include file="Componet/allCss.jsp"%>
</head>
<style>
.pain-card{
box-shadow:0 0 10px 0 rgba(0,0,0,0.3);
}
</style>
<body>
	<%@ include file="Componet/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card pain-card">
					<div class="card-body">
						<p class="fs-4 text-center">User Registration</p>
						

						<p class="fs-4-text-center text-center text-danger"></p>

<%
						Object succMsg = session.getAttribute("succMsg"); // Corrected attribute name
						Object errorMsg = session.getAttribute("errorMsg");

						if (succMsg != null) {
						%>
						<p class="text-center text-success fs-3">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
						<!-- Corrected variable name -->
						<%
						} else if (errorMsg != null) {
						%>
						<p class="text-center text-success fs-3">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
						<%
						}
						%>


						<P class="fs-4 text-center text-success"></P>

						<form action="userlogin1" method="Post">
							<div class="md-3">
								<label class="form-label">FullName</label> <input required
									name="name" type="text" class="form-control">
							</div>
							<div class="md-3">
								<label class="form-label">Email</label> <input
									class="form-control" name="email" type="email">
							</div>
							<div class="md-3">
								<label class="form-label">Password</label> <input
									class="form-control" name="password" type="password">
							</div>
 <br> 
							<button type="submit"
								class="btn btn-success text-white text-center" style="width:300px;">Submit</button>
								<br>
					Don' t have an Account ? <a href="signup" class="text-decoration-none">Create one</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>