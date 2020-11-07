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

	<div>
		
		<div id="loginbox" style="margin-top: 30px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">Change Your Password</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/updatePassword"
						  	   modelAttribute="UpdatePasswordUser"
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
							<form:errors path="confirmPassword" cssClass="error alert alert-danger" />
							<form:password path="confirmPassword" placeholder="Reenter current Password (*)" class="form-control" />
						</div>
						<!-- Display Name-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="changePassword" cssClass="error alert alert-danger" />
							<form:password path="changePassword" placeholder="Enter your new Password (*)" class="form-control" />
						</div>
						<!-- Display Name-->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="changeConfirmPassword" cssClass="error alert alert-danger" />
							<form:password path="changeConfirmPassword" placeholder="ReEnter your new Password (*)" class="form-control" />
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