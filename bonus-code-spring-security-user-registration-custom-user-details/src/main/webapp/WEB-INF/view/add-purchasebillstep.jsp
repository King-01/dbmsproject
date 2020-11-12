<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Create Purchase Bill</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
	<h3>Add details about the Stock Items selected in previous Step for Purchase bill</h3>
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

	<!-- Registration Form -->
	<form:form action="${pageContext.request.contextPath}/add/purchasebill" 
		  	   modelAttribute="addelem"
		  	   class="form-horizontal"
		  	   onsubmit="return confirm('Once you proceed with wrong selection you will have to repeat the same process again, Are you Sure?') ? true : false;"
           
		  	   >
		<table>
		<tr>
			<th>No.</th>
			<th>Stock Name</th>
			<th>Quantity</th>
			<th>Rate</th>
			<th>Current Stock</th>
		</tr>
		<c:forEach items="${addelem.theStockPurchaseFormList}" var="theform" varStatus="status">
			<tr>
				<td align="center">${status.count}</td>
				<td><input name="theStockPurchaseFormList[${status.index}].stockitemName" value="${theform.stockitemName}" readonly="true"/></td>
				<td><input name="theStockPurchaseFormList[${status.index}].quantity" value="${theform.quantity}"/></td>
				<td><input name="theStockPurchaseFormList[${status.index}].rate" value="${theform.rate}"/></td>
				<td><input name="theStockPurchaseFormList[${status.index}].stockitemquantity" value="${theform.stockitemquantity}" readonly="true"/></td>
			</tr>
			<input type="hidden" name="theStockPurchaseFormList[${status.index}].id" value="${theform.id}" readonly="true"/>
			
		</c:forEach>
	</table>				<!-- Register Button -->
		<div style="margin-top: 10px" class="form-group">						
			<div class="col-sm-6 controls">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</form:form>
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

</body>
</html>