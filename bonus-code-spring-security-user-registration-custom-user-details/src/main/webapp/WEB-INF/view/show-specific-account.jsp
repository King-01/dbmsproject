<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>View Account</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
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
		<c:url var="schedulelink" value="/view/groupById">
			<c:param name="groupId" value="${scheduleId}" />
		</c:url><br>
		Group Name : <a href="${schedulelink}"><c:out value="${scheduleName}"/></a>
		<br>
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">View Account</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/view/updateaccount.to" 
						  	   modelAttribute="newaccount"
						  	   class="form-horizontal">

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="accountName" cssClass="error alert alert-danger" />
							
							<form:input path="accountName" placeholder="Account Name (*)" class="form-control" readonly="true"/>
						</div>
						<form:hidden path="groupId"/>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="guarantorName" cssClass="error alert alert-danger" />
							
							<form:input path="guarantorName" placeholder="Guarantor Name (*)" class="form-control" readonly="true" />
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="HsnNumber" cssClass="error alert alert-danger" />
							
							<form:input path="HsnNumber" placeholder="HSN Number " class="form-control"  readonly="true"/>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="email" cssClass="error alert alert-danger" />
							
							<form:input path="email" placeholder="Account holder email" class="form-control" readonly="true" />
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="mobileNumber1" cssClass="error alert alert-danger" />
							
							<form:input path="mobileNumber1" placeholder="Mobile Number (*)" class="form-control"  readonly="true"/>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="mobileNumber2" cssClass="error alert alert-danger" />
							
							<form:input path="mobileNumber2" placeholder="Alternate Mobile Number " class="form-control"  readonly="true" />
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="pan" cssClass="error alert alert-danger" />
							
							<form:input path="pan" placeholder="PAN" class="form-control" readonly="true" />
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="addressLine1" cssClass="error alert alert-danger" />
							
							<form:input path="addressLine1" placeholder="Address Line 1 (*)" class="form-control"   readonly="true"/>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="addressLine2" cssClass="error alert alert-danger" />
							
							<form:input path="addressLine2" placeholder="Address Line 2" class="form-control" readonly="true" />
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="City" cssClass="error alert alert-danger" />
							
							<form:input path="City" placeholder="City (*)" class="form-control readonly="true""  />
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="pincode" cssClass="error alert alert-danger" />
							
							<form:input path="pincode" placeholder="PIN Code (*)" class="form-control" readonly="true" />
						</div>
						<!-- Register Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Update Details</button>
							</div>
						</div>
					</form:form>
				</div>
					<br>
					<br>
					<button type="submit" style="margin-left:15px" class="btn btn-primary" onclick="history.go(-1);" > Back </button>
					<br>
					<br>
					<form:form action="${pageContext.request.contextPath}/" 
					  	   >
						<button type="submit" style="margin-left:15px" class="btn btn-primary">Back to Home</button>
					</form:form>
					
					<form:form action="${pageContext.request.contextPath}/logout" 
					  	   >
						<button type="submit" style="margin-left:15px" class="btn btn-primary">logout</button>
					</form:form>
			</div>

		</div>

	</div>
	</body>
</html>