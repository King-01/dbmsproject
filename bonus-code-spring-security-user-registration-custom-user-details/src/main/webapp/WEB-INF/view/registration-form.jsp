<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Register Company</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<div>
		
		<div id="loginbox" style="margin-top: 30px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">Register New Company</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" 
						  	   modelAttribute="crmUser"
						  	   class="form-horizontal">

					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
								
									<!-- Check for registration error -->
									<c:if test="${registrationError != null}">
								
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											${registrationError}
										</div>
		
									</c:if>
																			
					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="userName" cssClass="error alert alert-danger" />
							
							<form:input path="userName" placeholder="username" class="form-control" />
						</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="password" cssClass="error alert alert-danger" />
							
							<form:password path="password" placeholder="password (*)" class="form-control" />
						</div>
						
						<!-- Confirm Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="matchingPassword" cssClass="error alert alert-danger" />
							<form:password path="matchingPassword" placeholder="confirm password (*)" class="form-control" />
						</div>
						
						<!-- Email-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<form:errors path="mobilenumber1" cssClass="error alert alert-danger" />
							<form:input path="mobilenumber1" placeholder="Mobile Number 1(*)" class="form-control" />
						</div>
						
						<!-- Email-->
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
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</div>
						
					</form:form>

				</div>

			</div>

		</div>

	</div>

</body>
</html>