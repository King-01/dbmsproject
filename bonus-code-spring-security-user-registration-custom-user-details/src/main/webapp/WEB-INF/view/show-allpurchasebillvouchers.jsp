<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>

<head>
<title>View All Purchase Vouchers</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=15, shrink-to-fit=no">
  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
	<c:if test = "${ (items.size() != 0) && (items != null) }" >
  <h2>Overall for all the purchase vouchers, current status - ${ status } and its value is ${ tot }- </h2>
  <br><startcounter>
	<div class="table-wrapper">
	<table class = "alt">
	<thead>
	<tr>
	<th>No. </th>
	<th>Date</th>
	<th>Account Name</th>
	<th>Cost / Debit</th>
	<th>Link</th>
	</tr></thead>
	<tbody>
  <c:forEach var="schedule" items="${items}">
    <c:url var="schedulelink" value="/view/specificpurchasebillvoucher">
      <c:param name="id" value="${schedule.getId()}" />
    </c:url>
		<tr>
		<td><number></number></td>
    	<td>${schedule.getDate()}</td>
    	<td>${ schedule.getAccountName() } </td>
    	<td>${ schedule.getCost() }</td>
    	<td><a href="${schedulelink}"><c:out value="Click Here"/></a></td>
    </tr></c:forEach>
  </tbody>
  </table>
  </div>
	</startcounter>
	</c:if>
	<c:if test = "${ (items.size() == 0) || (items == null) }" >
  <h2> Nothing to show </h2>
  </c:if>
  
  </div>
  </section>
		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<h2>Get In Touch</h2>
					<ul class="actions">
						<li><span class="icon fa-phone"></span> (+91) 97825-65081</li>
						<li><span class="icon fa-envelope"></span> <a href="https://mail.google.com/mail/?view=cm&fs=1&tf=1&to=aasavbadera.cse18@iitbhu.ac.in">aasavbadera.cse18@iitbhu.ac.in</a></li>
						<li><span class="icon fa-map-marker"></span> H-2-A, Jawahar Nagar, Kota, Rajasthan</li>
					</ul>
				</div>
				<div class="copyright">
					&copy; King_01 Design <a href="https://templated.co">TEMPLATED</a>. Images <a href="https://unsplash.com">Unsplash</a>.
				</div>
			</footer>	
</body>

</html>