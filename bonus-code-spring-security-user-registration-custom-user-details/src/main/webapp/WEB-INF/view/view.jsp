<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<html>

<head>
	<title>View Page</title>
		<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>
<body>
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

	<p>
			<a href="${pageContext.request.contextPath}/view/Schedule">View Schedules</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/group">View Groups</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/account">View Accounts</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/stockitem">View Stock Items</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/tax">View Tax</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/taxbystock">View Tax by Stock</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/stockbytax">View Stock by Taxes</a>
			
	</p>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/" 
			   method="POST">
	
		<input type="submit" value="Back to Home" />
	
	</form:form>
	
</body>
</html>