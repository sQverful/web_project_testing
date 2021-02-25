<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>

<head>
	<!-- Basic Page Info -->
	<meta charset="utf-8">
	<title>Testify.Registration</title>

	<!-- Site favicon -->
	<link rel="apple-touch-icon" sizes="180x180" href="admin/vendors/images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="admin/images/favicon-32x32.png">

	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="admin/vendors/styles/core.css">
	<link rel="stylesheet" type="text/css" href="admin/vendors/styles/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="admin/src/plugins/jquery-steps/jquery.steps.css">
	<link rel="stylesheet" type="text/css" href="admin/vendors/styles/style.css">

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag(){dataLayer.push(arguments);}
		gtag('js', new Date());

		gtag('config', 'UA-119386393-1');
	</script>
</head>

<body class="login-page">
	<div class="login-header box-shadow">
		<div class="container-fluid d-flex justify-content-between align-items-center">
			<div class="brand-logo">
				<a href="${pageContext.request.contextPath}">
					<img src="admin/vendors/images/deskapp-logo.svg" alt="">
				</a>
			</div>
			<div class="login-menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}">Login</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="register-page-wrap d-flex align-items-center flex-wrap justify-content-center">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-6 col-lg-7">
					<img src="admin/vendors/images/register-page-img.png" alt="">
				</div>
				<div class="col-md-6 col-lg-5">
					<div class="register-box bg-white box-shadow border-radius-10">
							<form action="controller" method="post">
							<input type="hidden" name="command" value="register">
								<input type="hidden" name="role_id" value="1">

								<h2 class="text-center text-primary">Register </h2>
							<br>
									<div class="form-wrap max-width-600 mx-auto">
										<div class="input-group custom">
											<label class="col-sm-4 col-form-label">Login*</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" name="login" required>
											</div>
										</div>
										<div class="input-group custom">
											<label class="col-sm-4 col-form-label">Email Address*</label>
											<div class="col-sm-8">
												<input type="email" class="form-control" name="email" required>
											</div>
										</div>
										<div class="input-group custom">
											<label class="col-sm-4 col-form-label">Name*</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" name="name" required>
											</div>
										</div>
										<div class="input-group custom">
											<label class="col-sm-4 col-form-label">Surname*</label>
											<div class="col-sm-8">
												<input type="text" class="form-control" name="surname" required>
											</div>
										</div>										
										<div class="input-group custom">
											<label class="col-sm-4 col-form-label">Password*</label>
											<div class="col-sm-8">
												<input type="password" id="password" class="form-control" name="password" onkeyup='check();' required>
											</div>
										</div>
										<div class="input-group custom">
											<label class="col-sm-4 col-form-label">Confirm Password*</label>
											<div class="col-sm-8">
												<input type="password" id="confirm_password" class="form-control" onkeyup='check();' required>
												  <span id='message'></span>
											</div>
										</div>
										<c:if test="${registrationIncorrectLogin}">
												<label class="text-dark">Such login already exists</label>
										</c:if>
										<c:if test="${invalidInput}">
												<label class="text-dark">Invalid input in form!</label>
										</c:if>
										<div class="row">
											<div class="col-sm-12">
												<div class="input-group mb-0">										
												<input class="btn btn-primary btn-lg btn-block" type="submit" id="submitRegister" value="Register">
												</div>
											</div>
										</div>
									</div>
							</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- js -->
	<script>
	var check = function() {
  if (document.getElementById('password').value == document.getElementById('confirm_password').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'Matching';
	document.getElementById('submitRegister').disabled = false;
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'Passwod is not matching!';
	document.getElementById('submitRegister').disabled = true;
  }
}
</script>
	<script src="admin/vendors/scripts/core.js"></script>
	<script src="admin/vendors/scripts/script.min.js"></script>
	<script src="admin/vendors/scripts/process.js"></script>
	<script src="admin/vendors/scripts/layout-settings.js"></script>
	<script src="admin/src/plugins/jquery-steps/jquery.steps.js"></script>
	<script src="admin/vendors/scripts/steps-setting.js"></script>
</body>

</html>