
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.Dao.SpeciallistDao"%>
<%@page import="com.Entity.Specalist"%>
<%@page import="com.Db.Dbconnection"%>
<%@ include file="../Componet/allCss.jsp"%>
<%@page import="java.util.List"%>
<%@ page import="com.Entity.Docter_Entity"%>
<%@page import="com.Dao.DocterDao"%>
<script src="https://kit.fontawesome.com/f327e1d3d1.js" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../Componet/allCss.jsp"%>
<style type="text/css">
.paint-card {
    box-shadow: 0 0 0 10px 0 rgba(0, 0, 0, 0.3),
                0 0 0 15px 0 rgba(0, 0, 0, 0.1); /* Add another box shadow */
}
</style>

</head>
<body>
	<%@ include file="navbar.jsp"%>  
	<div class="container-fluid p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center"><h6 class="text-center">Edit Docter Details</h6></p>
						
						<% int id=Integer.parseInt(request.getParameter("id"));
						 DocterDao dao2= new DocterDao(Dbconnection.getconn());
						 Docter_Entity d=dao2.getByDocterId(id);
						
						
						%>
						<form action="../updateservlet" method="Post">
                      	<input type="hidden" name="id" value="<%=d.getId() %>">
							<div class="mb-2">
								<label>FullName</label> <input type="text" name="fullname"
									class="form-control" required value="<%=d.getFullName()%>">
							</div>
							<div class="mb-2">
								<label>DOB</label> <input TYPE="date" name="dob"
									class="form-control" required value="<%=d.getDOB() %>">
							</div>
							<div class="mb-2">
								<label>Qulification</label> <input type="text"
									name="qulification" class="form-control" value="<%=d.getQulification() %>" required>
							</div>
							<div class="mb-2">
								<label>Specialist</label> <select name="spec" value="" required
									class="form-control">
									<option><%=d.getSpecialist() %></option>

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
							<div class="mb-2">
								<label>Email</label> <input type="email" name="email"
									class="form-control" value="<%=d.getEmail() %>" required>
							</div>

							<div class="mb-2">
								<label> Mobile no</label> <input name="mobile"
									class="form-control" type="number" value="<%=d.getMobile() %>" required>
							</div>

							<div class="mb-2">
								<label>Password</label> <input name="password" type="text"
									class="form-control" value="<%=d.getPassword() %>" required>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary col-md-12">Update</button>
							</div>

						</form>
					</div>
				</div>
			
		
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- Add other script includes if needed -->
</body>
</html>
