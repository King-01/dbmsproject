<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html lang="en">

<head>
	
	<title>Add Journal Voucher</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta charset="utf-8" />
	
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


	<section id="main" class="wrapper">
		<div class="inner">
	<h1>Add Journal Voucher</h1>
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
	<form:form action="${pageContext.request.contextPath}/process/journalvoucher" 
		  	   modelAttribute="addelem"
		  	   class="form-horizontal">
		<form:hidden path="jvoucherId"/>
		<form:hidden path="userName"/>
		<form:hidden path="accountName"/>
		<!-- Password -->
		<h4>Date : </h4>
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">			
			<form:errors path="date" cssClass="error alert alert-danger" />
			
			<form:input type="date" path="date" placeholder="Date (*)" class="form-control" />
		</div>
		<br>
		<h4>Select Account: </h4>
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">
			<form:errors path="accountId" cssClass="error alert alert-danger" />
			<form:select path="accountId">
				<form:option value="${ null }" label = "Select a Account from this List (*)"></form:option>
				<c:forEach var="oneschedule" items="${theaccountlist}">
					<form:option value="${oneschedule.getId()}" label = "${ oneschedule.getAccountName() }"></form:option>
				</c:forEach>
			</form:select>  
					
		</div>
		<br>
		<h4>Credit : </h4>
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">			
			<form:errors path="creditTotal" cssClass="error alert alert-danger" />
			
			<form:input path="creditTotal" placeholder="Credit (*)" class="form-control" />
		</div>
		<br>
		<h4>Debit : </h4>
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">			
			<form:errors path="debitTotal" cssClass="error alert alert-danger" />
			
			<form:input path="debitTotal" placeholder="Debit (*)" class="form-control" />
		</div>
		<br>
		<h4>Description : </h4>
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">			
			<form:errors path="description" cssClass="error alert alert-danger" />
			
			<form:input path="description" placeholder="Description" class="form-control" />
		</div>
		<br>
		<!-- Register Button -->
		<div style="margin-bottom: 25pxl; margin-left:4pxl" class="form-group">						
			<div class="col-sm-6 controls">
				<button type="submit" class="btn btn-primary">Submit</button>
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