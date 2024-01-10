<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.Dao.DocterDao"%>
<%@page import="com.Db.Dbconnection"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../Componet/allCss.jsp"%>
<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3)
}
</style>
</head>
<body>

	<%@include file="navbar.jsp"%>
	<!-- 	<h1>welcome docter page</h1> -->
	<p class="text-center fs-3">DOCTER DASHBOARD</p>
	<div class="container p-5">
		<div class="row">

			<%
			DocterDao dao = new DocterDao(Dbconnection.getconn());
			%>
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor <br>
						<h1>
							<%=dao.countDocter()%>
							<h1></h1>
							</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							View Doctor record <br>
						<h1>

							<%=dao.CountAppointmentbydocterid(id)%>
						</h1>
						</p>
					</div>
				</div>
			</div>


		</div>
	</div>
	</div>
	</div>
</body>
</html>