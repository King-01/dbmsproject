<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html>

<head>
	
	<title>Change Password</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=15, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta charset="utf-8" />
		
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
	
	
</head>

	<body class="subpage">
<!-- Header -->
			<header id="header">
				<nav class="left">
					<a href="#menu"><span>Menu</span></a>
				</nav>
				<a href="${pageContext.request.contextPath}/" class="logo">Merchant Manager</a>
				<nav class="right">
				<form:form action="${pageContext.request.contextPath}/updatecompanydetails" class="button alt"
			   	method="POST">
	
					<input type="submit" value="<%= session.getAttribute("UserName") %>" />
	
				</form:form>
					<form:form action="${pageContext.request.contextPath}/logout" class="button alt"
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
				</nav>
			</header>

	<c:if test="${registrationError != null}">

		<div class="alert alert-danger col-xs-offset-1 col-xs-10">
			${registrationError}
		</div>
	</c:if>
	<!-- Check for registration error -->
	<c:if test="${successMessage != null}">

		<div class="alert alert-success">
			${successMessage}
		</div>

	</c:if>


		<!-- Menu -->
			<nav id="menu">
				<ul class="links">
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/add">Create</a></li>
					<li><a href="${pageContext.request.contextPath}/view">View</a></li>
					<li><a href="${pageContext.request.contextPath}/update">Update</a></li>
					<li><a href="${pageContext.request.contextPath}/showFormForUpdatePassword">Change Password</a></li>
					<li><a href="${pageContext.request.contextPath}/updatecompanydetails">Update Company Details</a></li>
				</ul>
				<ul class="actions vertical">
					<li><a href="${pageContext.request.contextPath}/logout" class="button fit">Logout</a></li>
				</ul>
			</nav>


	<!-- Check for registration error -->
	<c:if test="${someerror != null}">

		<div class="alert alert-danger col-xs-offset-1 col-xs-10r">
			${someerror}
		</div>

	</c:if>
	<!-- Registration Form -->
			<section id="main" class="wrapper">
				<div class="inner">
		<div class="content">
	<h1>Change Your Password</h1></div>
	<form:form action="${pageContext.request.contextPath}/updatePassword"
		  	   modelAttribute="UpdatePasswordUser"
		  	   class="form-horizontal">

		<!-- User name -->
		<form:errors path="userName" cssClass="error alert alert-danger" />
			
			UserName : 
				<div class="row uniform">
					<div class="5u 12u$(small)">
					<div style="margin-bottom: 25px" class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
			<form:input path="userName" placeholder="username" class="form-control" readonly="true" />
		</div>
		</div>
		</div>
		<form:errors path="confirmPassword" cssClass="error alert alert-danger" />
			<!-- Display Name-->
		Confirm Current Password : 
				<div class="row uniform">
					<div class="5u 12u$(small)"><div style="margin-bottom: 25px" class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
			<form:password path="confirmPassword" placeholder="Reenter current Password (*)" class="form-control" />
		</div>
		</div>
		</div>
		<!-- Display Name-->
		<form:errors path="changePassword" cssClass="error alert alert-danger" />
			Enter New Password : 
				<div class="row uniform">
					<div class="5u 12u$(small)">
					<div style="margin-bottom: 25px" class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
			<form:password path="changePassword" autocomplete="new-password" placeholder="Enter your new Password (*)" class="form-control" />
		</div>
		</div>
		</div>
		<!-- Display Name-->
		<form:errors path="changeConfirmPassword" cssClass="error alert alert-danger" />
			Confirm New Password : 
				<div class="row uniform">
					<div class="5u 12u$(small)">
					<div style="margin-bottom: 25px" class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
			<form:password path="changeConfirmPassword" placeholder="ReEnter your new Password (*)" class="form-control" />
		</div>
		</div>
		</div>
		<!-- Register Button -->
		<div style="margin-top: 10px" class="form-group">						
			<div class="col-sm-6 controls">
				<button type="submit" class="btn btn-primary">Update Details</button>
			</div>
		</div>
		
	</form:form>
	</div>
	</section>
		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<h2>Get In Touch</h2>
					<ul class="actions">
						<li><span class="icon fa-phone"></span>(+91) 97825-65081</li>
						<li><span class="icon fa-envelope"></span> <a href="https://mail.google.com/mail/?view=cm&fs=1&tf=1&to=aasavbadera.cse18@iitbhu.ac.in">aasavbadera.cse18@iitbhu.ac.in</a></li>
						<li><span class="icon fa-map-marker"></span> H-2-A, Jawahar Nagar, Kota, Rajasthan</li>
					</ul>
				</div>
				<div class="copyright">
					&copy; King_01 Design <a href="https://templated.co">TEMPLATED</a>. Images <a href="https://unsplash.com">Unsplash</a>.
				</div>
			</footer>	
			<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/skel.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

</body>
</html>