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
			<a href="${pageContext.request.contextPath}/add/Schedule">Add Schedule</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/add/group">Add Group</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/add/account">Add Account</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/add/stockitem">Add Stock Item</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/add/tax">Add Tax</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/add/stocktax">Add Tax to Stock</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/add/journalvoucher">Add Journal Voucher</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/add/bankvoucher">Add Bank Voucher</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/add/cashvoucher">Add Cash Voucher</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/add/stockitemsforpurchaseitems">Add Purchase Voucher</a>
			
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