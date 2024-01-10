<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget Password</title>
<style type="text/css">
.body {
	background-position: center;
	background-color: #eee;
	background-repeat: no-repeat;
	background-size: cover;
	color: #505050;
	font-family: "Rubik", Helvetica, Arial, Sans-Serif;
	font-size: 14px;
	font-weight: normal;
	line-height: 1.5; /* Corrected typo: line-weight to line-height */
	text-transform: none;
}

.forget {
	background-color: #fff;
	padding: 12px;
	border: 1px solid #dfdfdf;
}

.padding-bottom-3x {
	padding-bottom: 72px !important; /* Corrected typo: 72ox to 72px */
}

.card-footer {
	background-color: #fff;
}

.btn {
	font-size: 13px;
}

.form-control:focus {
	color: #4905057;
	background-color: #76b9;
	outline: 0;
	box-shadow: 0 0 0 0px #28a7d; /* Corrected typo: 28a7d to #28a7d */
}
</style>
</head>
<body oncontextmenu='return false' class='snippet-body'>
	<div class="container padding-bottom-3x mb-2 mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10">
				<div class="forget">
					<h2>Forget your Password ?</h2>
					<p>Change your Password in three easy steps. This will help you secure your Password</p>
					<ol class="list-unstyled">
						<li><span class="text-primary text-medium">1</span>Enter your email address below</li>
						<li><span class="text-primary text-medium">2</span>Our system will send you an OTP to your email</li>
						<li><span class="text-primary text-medium">3</span>Enter your OTP on the next page</li>
					</ol>
				</div>
				<div class="card-body">
				<form action="forgotPassword" class="card mt-4" method="post"> <!-- Corrected typo: method="Post" to method="post" -->
					<div class="card-body">
						<div class="form-group">
							<label for="email-for-password">Enter your email</label>
							<input class="form-control" type="text" name="email" id="email-for-password" required>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn btn-success" type="submit">Get new Password</button>
						<button class="btn btn-danger" type="submit">Back to login</button>
					</div>
				</form>
			</div>
			</div>
		</div>
		</div>
	
</body>
</html>
