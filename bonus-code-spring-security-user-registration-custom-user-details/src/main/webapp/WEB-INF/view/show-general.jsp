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
		
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-primary">

				<div class="panel-heading">
					<div class="panel-title">View Tax Stock</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/process/stocktaxhandler" 
						  	   modelAttribute="addelem"
						  	   class="form-horizontal">
						<form:hidden path = "id" />
							
					<c:if test="${items != null}" >
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="stockId" cssClass="error alert alert-danger" />
							Select Stock Item : <form:select path="stockId">
								<form:option value="${ stockitemid.getId() }" label = "${ stockitemId.getStockItemName() }"></form:option>
								<c:forEach var="oneschedule" items="${items}">
									<c:if test = "${ stockitemid.getId() != oneschedule.getId() }" >
										<form:option value="${oneschedule.getId()}" label = "${ oneschedule.getStockItemName() }"></form:option>
									</c:if>
								</c:forEach>
							</form:select>  
						
					</div>
					</c:if>
					<c:if test = "${ items == null }" >
					<form:hidden path = "stockId" />
					</c:if>
						<c:if test="${taxes != null}" >
					<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							<form:errors path="taxId" cssClass="error alert alert-danger" />
							Select Tax: <form:select path="taxId">
								<form:option value="${ taxid.getId() }" label = "${ taxid.getTaxName() }"></form:option>
								<c:forEach var="oneschedule" items="${taxes}">
									<c:if test = "${ taxid.getId() != oneschedule.getId() }" >
										<form:option value="${oneschedule.getId()}" label = "${ oneschedule.getTaxName() } | ${ oneschedule.getTaxPercent() }%"></form:option>
									</c:if>
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