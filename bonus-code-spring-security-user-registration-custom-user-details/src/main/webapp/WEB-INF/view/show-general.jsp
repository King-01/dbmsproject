<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html lang="en">

<head>
	
	<title>View Tax Stock</title>
	
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
  <h1>View All Tax by Stock</h1>
	<!-- Registration Form -->
	<form:form action="${pageContext.request.contextPath}/process/stocktaxhandler" 
		  	   modelAttribute="addelem"
		  	   class="form-horizontal">
		<form:hidden path = "id" />
			
	<c:if test="${items != null}" >
	<h3>Select Stock Item : </h3>
		<div style="margin-bottom: 25px" class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
			<form:errors path="stockId" cssClass="error alert alert-danger" />
			<form:select path="stockId">
				<form:option value="null" label = "Select one Stock Item from the list"></form:option>
				<c:forEach var="oneschedule" items="${items}">
						<form:option value="${oneschedule.getId()}" label = "${ oneschedule.getStockItemName() }"></form:option>
					</c:forEach>
			</form:select>  
		
	</div>
	</c:if>
	<c:if test = "${ items == null }" >
	<form:hidden path = "stockId" />
	</c:if>
		<c:if test="${taxes != null}" >
		<h3>Select Tax: </h3>
	<div style="margin-bottom: 25px" class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
			<form:errors path="taxId" cssClass="error alert alert-danger" />
			<form:select path="taxId">
				<form:option value="null" label = "Select one Tax Item from the list"></form:option>
				<c:forEach var="oneschedule" items="${taxes}">
						<form:option value="${oneschedule.getId()}" label = "${ oneschedule.getTaxName() } | ${ oneschedule.getTaxPercent() }%"></form:option>
				</c:forEach>
			</form:select>  
		
		</div>
	</c:if>
	<c:if test = "${ taxes == null }" >
	<form:hidden path = "taxId" />
	</c:if>
		<!-- Register Button -->
		<div style="margin-top: 10px" class="form-group">						
			<div class="col-sm-6 controls">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</form:form>
	</div>
	</section>
</body>
</html>