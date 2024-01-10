<%@page import="javax.print.Doc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.Dao.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.Db.*"%>
<%@ page import="com.Entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
.card-pain {
	box-shadow: 0 0 10px 0rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<!-- 	======================================================== -->
	<%@include file="navbar.jsp"%>

	<!-- ============================================================================ -->
	<div class="container p-3">
		<div class="row">
			<div class="col-md-4 p-5">
				<div class="card paint-card">
					<div class="card-body">
					<p class="text-center fs-3">Password change</p>
					
					<%
					/* 	id = Integer.parseInt(request.getParameter("id")); */
						DocterDao dao2 = new DocterDao(Dbconnection.getconn());
						Docter_Entity d = dao2.getByDocterId(id);
						%>
					
						<form action="../changepassword" method="post">
							<div class="mb-2">
								<label>Old Password</label> <input type="text"
									name="newPassword" class="form-control" required value="">
							</div>
							<div class="mb-2">
								<label>New Password</label> <input type="text"
									name="oldPassword" class="form-control" required value="">
									<input type="hidden" name="uid" value="<%=d.getId()%>">
							</div>
							<div class="mb-2">
							<button type="submit" name="btn" class="btn btn-info">Update</button>
							</div>

						</form>
					</div>
				</div>
			</div>



			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">Edit Details</p>
						<%-- <c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if> --%>
						
						<form class="row g-3" action="../editDocter" method="post">

							<div class="mb-2">
								<label>FullName</label> <input type="text" name="fullname"
									class="form-control" required value="<%=d.getFullName()%>">
							</div>
							<div class="mb-2">
								<label>DOB</label> <input TYPE="date" name="dob"
									class="form-control" required value="<%=d.getDOB()%>">
							</div>
							<div class="mb-2">
								<label>Qulification</label> <input type="text"
									name="qulification" class="form-control"
									value="<%=d.getQulification()%>" required>
							</div>
							<div class="mb-2">
								<label>Specialist</label> <select name="spec" value="" required
									class="form-control">
									<option><%=d.getSpecialist()%></option>

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
									class="form-control" value="<%=d.getEmail()%>" required>
							</div>

							<div class="mb-2">
								<label> Mobile no</label> <input name="mobile"
									class="form-control" type="number" value="<%=d.getMobile()%>"
									required>
							</div>


							<div class="text-center">
								<input type="hidden" name="id" value="<%=d.getId()%>">
								<button type="submit" class="btn btn-primary col-md-12">Update</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>