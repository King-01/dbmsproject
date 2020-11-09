<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>View Stock Item</title>
	
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
					<div class="panel-title">Stock Item</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/" 
						  	   modelAttribute="newstockitem"
						  	   class="form-horizontal">

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="stockItemName" cssClass="error alert alert-danger" />
							
							<form:input path="stockItemName" placeholder="Stock item name (*)" class="form-control" readonly="true"/>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="hsnGroup" cssClass="error alert alert-danger" />
							
							<form:input path="hsnGroup" placeholder="HSN Group " class="form-control" readonly="true" />
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="mandiTax" cssClass="error alert alert-danger" />
							
							<form:input path="mandiTax" placeholder="Mandi Tax (*)(In percent) " class="form-control" readonly="true"/>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="kkFee" cssClass="error alert alert-danger" />
							
							<form:input path="kkFee" placeholder="KK Fee (*)(In percent)" class="form-control" readonly="true"/>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="labourCharge" cssClass="error alert alert-danger" />
							
							<form:input path="labourCharge" placeholder="labour Charge (*)(In percent)" class="form-control" readonly="true"/>
						</div>
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="packing" cssClass="error alert alert-danger" />
							
							<form:input path="packing" placeholder="packing" class="form-control" readonly="true"/>
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