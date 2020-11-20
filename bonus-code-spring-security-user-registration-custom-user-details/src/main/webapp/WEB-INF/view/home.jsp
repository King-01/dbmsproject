<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
	<head>
		<title>Home Page</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
	</head>
	<body>

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

		<!-- Banner -->
			<section id="banner">
				<div class="content">
					<h1>Hello ${ DisplayName }</h1>
					<p>Welcome to Merchant Manager, you can do amazing stuff here.
					<br />Just a click away to get to know about them.</p>
					<ul class="actions">
						<li><a href="#one" class="button scrolly">Get Started</a></li>
					</ul>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper">
				<div class="inner flex flex-3">
					<div class="flex-item left">
						<div>
							<h3>Create</h3>
							<p>You have 11 different types of add operations available. Excited ?
						<a href="${pageContext.request.contextPath}/add" class="button scrolly">Start Adding</a>
					</p>
						</div>
						<div>
							<h3>Manage</h3>
							<p>Managing your data, just got organized. Query by dates, groups, accounts etc.
							<a href="${pageContext.request.contextPath}/view" class="button scrolly">Click Here!</a> </p>
						</div>
					</div>
					<div class="flex-item image fit round">
						<img src="${pageContext.request.contextPath}/resources/images/pic01.jpg" alt="" />
					</div>
					<div class="flex-item right">
						<div>
							<h3>Update</h3>
							<p>Made a mistake? Don't worry, we got you covered. You can update multiple details in your Group, Account, Schedule.<br />
						<a href="${pageContext.request.contextPath}/update" class="button scrolly">Start from here</a>
					</p>
						</div>
						<div>
							<h3>Delete</h3>
							<p>Managing Taxes in your stocks have delete support!<br /> Just find your stock to query on!
						<a href="${pageContext.request.contextPath}/view/taxbystock" class="button scrolly">Select the stock!</a>
					</p>
						</div>
					</div>
				</div>
			</section>

		<!-- Two -->
			<section id="two" class="wrapper style1 special">
				<div class="inner">
					<h2>My Vision</h2>
					<figure>
					    <blockquote>
					        "This project is created as a Course Project for Database Management System Course<br />, which i took in 5th Semester of My Bachelor's in IIT BHU Varanasi.<br /> Most work on this Website was done till November 2020, I hope you will like it!"
					    </blockquote>
					    <footer>
					        <cite class="author">Aasav Badera</cite>
					        <cite class="company">Creator, Merchant Manager</cite>
					    </footer>
					</figure>
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

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/skel.min.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

	</body>
</html>







