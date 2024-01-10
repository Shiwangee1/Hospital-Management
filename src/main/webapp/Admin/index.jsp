<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.Dao.DocterDao" %>
	<%@page import="com.Db.Dbconnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../Componet/allCss.jsp"%>
<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<br>
	<h1 class="text-center">Admin Desbord</h1>
	<div class="container">
		<div class="row">
			<!-- Left Cards -->
			<%DocterDao dao = new DocterDao(Dbconnection.getconn()) ;%>
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor <br>
						<h1>
							<%=dao.countDocter() %>
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
							<%=dao.countViewDocter() %>
							<h1></h1>
							</p>
					</div>
				</div>
			</div>


			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-circle fa-3x"></i><br>
						<p class="fs-4 text-center">
							User <br>
						<h1>
							<%=dao.countUser() %>
							<h1></h1>
							</p>
					</div>
				</div>
			</div>

			<!-- Middle Card -->


			<!-- Add some space between the two sets of cards -->
			<div class="row" style="margin-top: 20px;">
				<!-- Right Cards -->
				<div class="col-md-4">
					<div class="card paint-card" data-bs-toggle="modal"
						data-bs-target="#exampleModal">
						<div class="card-body text-center text-success">
							<i class="fa-solid fa-address-book fa-3x"></i><br>
							<p class="fs-4 text-center">
								SPECIALIST <br>
							<h1><%=dao.countSpecilst() %></h1>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card paint-card">
						<div class="card-body text-center text-success">
							<i class="fa-regular fa-calendar-check fa-3x"></i><br>
							<p class="fs-4 text-center">
								Total APPOINTMENT <br>
							<h1><%=dao.countAppointment()  %></h1>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Button trigger modal -->


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Specialist
						type</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="../addSecp" method="Post">
						<div class="form-group">
							<label>Enter Specialist Name</label> <input type="text"
								name="specName" class="form-control">

						</div>

						<div class="text-center mt-3">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<!--  <button type="button" class="btn btn-primary">Save changes</button> -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
