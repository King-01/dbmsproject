<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>

<head>
<title>View Groups</title>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=15, shrink-to-fit=no">
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta charset="utf-8" /><style>
startcounter {
  list-style-type: none;
  counter-reset: css-counter 0; /* initializes counter to 0; use -1 for zero-based numbering */
}

startcounter number {
  counter-increment: css-counter 1; /* Increase the counter by 1. */
}

startcounter number:before {
  content: counter(css-counter) ". "; /* Apply counter before children's content. */
}
</style>
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

	<h4>Stock Items - </h4>
	<startcounter>
	<c:forEach var="schedule" items="${listofstockitems}">
		<c:url var="schedulelink" value="/view/stockItemById">
			<c:param name="stockItemId" value="${schedule.getId()}" />
		</c:url><br>
		<number><a href="${schedulelink}"><c:out value="${schedule.getStockItemName()}"/></a></number>
		
	</c:forEach>
	</startcounter>
	<form:form action="${pageContext.request.contextPath}/add/stockitem" 
					  	   >
	<div style="margin-top: 10px" class="form-group">						
			<div class="col-sm-6 controls">
				<button type="submit" class="btn btn-primary">Add Stock Item</button>
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