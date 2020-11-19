<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<html>

<head>
	<title>Create Page</title>
		<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta charset="utf-8" />
		<style>
	p{
	margin-top:1em;
	}
	</style>
</head>
<body><!-- Header -->
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

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/skel.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

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


	<!-- Check for registration error -->
	<c:if test="${someerror != null}">

		<div class="alert alert-danger col-xs-offset-1 col-xs-10r">
			${someerror}
		</div>

	</c:if>
	<section id="main" class="wrapper">
		<div class="inner">
		
		<h1>Create Page - </h1>
	<ol><dl>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/Schedule">Create Schedule</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/group">Create Group</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/account">Create Account</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/stockitem">Create Stock Item</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/tax">Create Tax</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/stocktax">Create Tax to Stock</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/journalvoucher">Create Journal Voucher</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/bankvoucher">Create Bank Voucher</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/cashvoucher">Create Cash Voucher</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/stockitemsforpurchaseitems">Create Purchase Voucher</a>
			
	</dt></li>
	<li><dt>
			<a href="${pageContext.request.contextPath}/add/stockitemsforsaleitems">Create Sale Bill</a>
			
	</dt></li></dl></ol>
	</div>
	</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<h2>Get In Touch</h2>
					<ul class="actions">
						<li><span class="icon fa-phone"></span> (+91) 97825-65081</li>
						<li><span class="icon fa-envelope"></span> <a href="https://mail.google.com/mail/?view=cm&fs=1&tf=1&to=aasavbadera.cse18@iitbhu.ac.in">aasavbadera.cse18@iitbhu.ac.in</a></li>
						<li><span class="icon fa-map-marker"></span> H-2-A, Jawahar Nagar, Kota, Rajasthan</li>
					</ul>
				</div>
				<div class="copyright">
					&copy; King_01 Design <a href="https://templated.co">TEMPLATED</a>. Images <a href="https://unsplash.com">Unsplash</a>.
				</div>
			</footer>	
	
</body>
</html>