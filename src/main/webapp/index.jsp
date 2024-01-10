 <%@page import="com.Db.Dbconnection"%>
<%@page import="java.sql.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="Componet/allCss.jsp"%>

<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>

</head>
<body>
 <%--  <%Connection conn=  Dbconnection.getconn(); 
  out.print(conn);
%>  --%>

	<%@ include file="Componet/navbar.jsp"%>
	<div id="carouselExampleFade" class="carousel slide carousel-fade"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/docter1.jpg" class="d-block w-100" alt="..."
					height="400px">
			</div>
			<div class="carousel-item">
				<img src="img/docter3.jpg" class="d-block w-100" alt="..."
					height="400px">
			</div>
			<div class="carousel-item">
				<img src="img/docter2.jpg" class="d-block w-100" alt="..."
					height="400px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleFade" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleFade" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<div class="container p-3">
		<p class="text-center fs-2">Key Features of our hospital</p>
		<div class="row">
			<div class="col-md-8 p-5">
				<div class="row">
					<!-- Cards Section -->
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">100% Safety</p>
								<p>Lorem ipsum the fg sonam the profit and give application
									and show the program the project the ggffggffg</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Clean Environment</p>
								<p>Lorem ipsum the fg sonam the profit and give application
									and show the program the project the ggffggffg</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Friendly Doctor</p>
								<p>Lorem ipsum the fg sonam the profit and give application
									and show the program the project the ggffggffg</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Medical Research</p>
								<p>Lorem ipsum the fg sonam the profit and give application
									and show the program the project the ggffggffg</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Fixed Image Section -->
			<div class="col-md-4">
				<img alt="" src="img/images (1).jpg" hight="600px" width="400px">
			</div>
		</div>
	</div>
	<hr>
	<div class="container p-2">
		<p class="text-center fs-2">Our Team</p>
		<div class="row">
			<div class="col-md-3">
				<div class="card paint-card">
					<img alt="" src="img/docter4.jpg" height="300px" width="250px">
					<p class="fw-bold fs-5">Shiwangee Singh</p>
					<p class="fs-7">(CEO & Chairmain)</p>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card paint-card">
					<img alt="" src="img/docter5.jpg" height="300px" width="250px">
					<p class="fw-bold fs-5">Ashish Pal</p>
					<p class="fs-7">(Founder)</p>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card pain-card">
					<img alt="" src="img/images (3).jpg" height="300px" width="250px">
					<p class="fw-bold fs-5">Vinayak More</p>
					<p class="fs-7">(Chief Docter)</p>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card pain- card">
					<img alt="" src="img/images (2).jpg" height="300px" width="250px">
					<p class="fw-bold fs-5 text-centre">Sumit Gaoud</p>

					<p class="fs-7">(Chief Docter)</p>
				</div>
			</div>
		</div>
	</div>
	<%@include file="Componet/footer.jsp"%>
</body>
</html>
