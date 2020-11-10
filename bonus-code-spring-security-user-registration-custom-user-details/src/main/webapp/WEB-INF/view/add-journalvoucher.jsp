<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Add Journal Voucher</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
	h2 {
	  left: 20px;
	  top: 5px;
	}
	.input {
		  width: 60%;
		  padding: 12px 20px;
		  margin: 8px 0;
		  box-sizing: border-box;
		}
		.left {
			float: left;
			width: 30%;
		}
		.right {
			float: right;
			width: 10%;
		}
		.upar:after {
		  content: "";
		  display: table;
		  clear: both;
		}
		.button {
		  background-color: #4CAF50; /* Green */
		  border: none;
		  color: white;
		  padding: 15px 32px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		  margin: 4px 2px;
		  cursor: pointer;
		}
		.button5 {
			background-color: #2C9CC8;
			padding: 10px 24px;
			border-radius: 12px;
		}
		.button5:hover {
		  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
		}
	</style>	
</head>

<body>
	<h3>Add Journal Voucher</h3>
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
	<form:form action="${pageContext.request.contextPath}/process/journalvoucher" 
		  	   modelAttribute="addelem"
		  	   class="form-horizontal">
		<form:hidden path="jvoucherId"/>
		<form:hidden path="userName"/>
		<form:hidden path="accountName"/>
		<!-- Password -->
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">			
			<form:errors path="creditTotal" cssClass="error alert alert-danger" />
			
			Date : <form:input type="date" path="date" placeholder="Date (*)" class="form-control" />
		</div>
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">
			<form:errors path="accountId" cssClass="error alert alert-danger" />
			Select Account: <form:select path="accountId">
				<form:option value="${ null }" label = "Select a Account from this List (*)"></form:option>
				<c:forEach var="oneschedule" items="${theaccountlist}">
					<form:option value="${oneschedule.getId()}" label = "${ oneschedule.getAccountName() }"></form:option>
				</c:forEach>
			</form:select>  
					
		</div>
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">			
			<form:errors path="creditTotal" cssClass="error alert alert-danger" />
			
			Credit : <form:input path="creditTotal" placeholder="Credit (*)" class="form-control" />
		</div>
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">			
			<form:errors path="debitTotal" cssClass="error alert alert-danger" />
			
			Debit : <form:input path="debitTotal" placeholder="Debit (*)" class="form-control" />
		</div>
		<div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">			
			<form:errors path="description" cssClass="error alert alert-danger" />
			
			Description : <form:input path="description" placeholder="Description" class="form-control" />
		</div>
		<!-- Register Button -->
		<div style="margin-top: 10px; margin-left:4px" class="form-group">						
			<div class="col-sm-6 controls">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</form:form>
	<button type="submit" style="margin-top : 8px; margin-left:15px" class="btn btn-primary" onclick="history.go(-1);" > Back </button>
	
	<form:form action="${pageContext.request.contextPath}/" 
	  	   >
		<button type="submit" style="margin-top : 8px; margin-left:15px" class="btn btn-primary">Back to Home</button>
	</form:form>
	
	<form:form action="${pageContext.request.contextPath}/logout" 
	  	   >
		<button type="submit" style="margin-top : 8px; margin-left:15px" class="btn btn-primary">logout</button>
	</form:form>
</body>
</html>