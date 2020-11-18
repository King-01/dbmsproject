<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html lang="en">

<head>
	
	<title>Update Details</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=15, shrink-to-fit=no">
	
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

	<div>
		
		<div id="loginbox" style="margin-top: 30px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">Update Company Details</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/updateCompanyForm"
						  	   modelAttribute="crmUser"
						  	   class="form-horizontal">

					    
						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="userName" cssClass="error alert alert-danger" />
							
							<form:input path="userName" placeholder="username" class="form-control" readonly="true" />
						</div>
						
						<!-- Display Name-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="password" cssClass="error alert alert-danger" />
							<form:password path="password" placeholder="Reenter current Password (*)" class="form-control" />
						</div>
						<!-- Display Name-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="matchingPassword" cssClass="error alert alert-danger" />
							<form:password path="matchingPassword" placeholder="Confirm Current Password (*)" class="form-control" />
						</div>
						<!-- Display Name-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="displayName" cssClass="error alert alert-danger" />
							<form:input path="displayName" placeholder="Display Name (*)" class="form-control" />
						</div>
						
						<!-- Mobile Number 1-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="mobilenumber1" cssClass="error alert alert-danger" />
							<form:input path="mobilenumber1" placeholder="Mobile Number 1(*)" class="form-control" />
						</div>
						
						<!-- Mobile Number 2-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="mobilenumber2" cssClass="error alert alert-danger" />
							<form:input path="mobilenumber2" placeholder="Mobile Number 2" class="form-control" />
						</div>
						<!-- Email-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="email" cssClass="error alert alert-danger" />
							<form:input path="email" placeholder="Email (*)" class="form-control" />
						</div>
						<!-- PAN -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="pan" cssClass="error alert alert-danger" />
							<form:input path="pan" placeholder="PAN (*)" class="form-control" />
						</div>
						<!-- GSTIN-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="gstin" cssClass="error alert alert-danger" />
							<form:input path="gstin" placeholder="GSTIN (*)" class="form-control" />
						</div>
						
						<!-- TDSAccountNumber-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="tdsAccountNumber" cssClass="error alert alert-danger" />
							<form:input path="tdsAccountNumber" placeholder="TDS Account Number" class="form-control" />
						</div>
						<!-- Address Line 1-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="addressLine1" cssClass="error alert alert-danger" />
							<form:input path="addressLine1" placeholder="Address Line 1 (*)" class="form-control" />
						</div>
						<!-- Address Line 2-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="addressLine2" cssClass="error alert alert-danger" />
							<form:input path="addressLine2" placeholder="Address Line 2" class="form-control" />
						</div>
						<!-- City-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="city" cssClass="error alert alert-danger" />
							<form:input path="city" placeholder="City (*)" class="form-control" />
						</div>
						<!-- PINCODE-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="pincode" cssClass="error alert alert-danger" />
							<form:input path="pincode" placeholder="PIN CODE (*)" class="form-control" />
						</div>
						
						<!-- Register Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Update Details</button>
							</div>
						</div>
						
					</form:form>
				</div>
					<form:form action="${pageContext.request.contextPath}/" 
						  	   >
					<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Back to Home</button>
							</div>
						</div>
					</form:form>

			</div>

		</div>

	</div>
	
</body>
</html>