<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<html>

<head>
	<title>View Page</title>
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

	<p>
			<a href="${pageContext.request.contextPath}/view/Schedule">View Schedules</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/group">View Groups</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/account">View Accounts</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/stockitem">View Stock Items</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/tax">View Tax</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/taxbystock">View Tax by Stock</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/stockbytax">View Stock by Taxes</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/alljournalvouchers">View All Journal Vouchers</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/journalvoucherbyaccount">View Journal Voucher By Account</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/allbankvouchers">View All Bank Vouchers</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/bankvoucherbyaccount">View Bank Voucher By Account</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/allcashvouchers">View All Cash Vouchers</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/cashvoucherbyaccount">View Cash Voucher By Account</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/cashvoucherbetweendates">View Cash Voucher By Dates/Account</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/cashvoucherbetweendatesbygroup">View Cash Voucher By Dates/Group</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/cashvoucherbetweendatesbyschedule">View Cash Voucher By Dates/Schedule</a>
			
	</p>
	  <p>
	      <a href="${pageContext.request.contextPath}/view/bankvoucherbetweendates">View Bank Voucher By Dates/Account</a>
	      
	  </p>
	  <p>
	      <a href="${pageContext.request.contextPath}/view/bankvoucherbetweendatesbygroup">View Bank Voucher By Dates/Group</a>
	      
	  </p>
	  <p>
	      <a href="${pageContext.request.contextPath}/view/bankvoucherbetweendatesbyschedule">View Bank Voucher By Dates/Schedule</a>
	      
	  </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/journalvoucherbetweendates">View Journal Voucher By Dates/Account</a>
          
      </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/journalvoucherbetweendatesbygroup">View Journal Voucher By Dates/Group</a>
          
      </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/journalvoucherbetweendatesbyschedule">View Journal Voucher By Dates/Schedule</a>
          
      </p>
	<p>
			<a href="${pageContext.request.contextPath}/view/allpurchasebillvouchers">View All Purchase Vouchers</a>
			
	</p>
	<p>
			<a href="${pageContext.request.contextPath}/view/purchasebillvoucherbyaccount">View Purchase Voucher By Account</a>
			
	</p>
      <p>
          <a href="${pageContext.request.contextPath}/view/purchasebillvoucherbetweendates">View Purchase Voucher By Dates/Account</a>
          
      </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/purchasebillvoucherbetweendatesbygroup">View Purchase Voucher By Dates/Group</a>
          
      </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/purchasebillvoucherbetweendatesbyschedule">View Purchase Voucher By Dates/Schedule</a>
          
      </p>
  <p>
      <a href="${pageContext.request.contextPath}/view/allsalebills">View All Sale Vouchers</a>
      
  </p>
  <p>
      <a href="${pageContext.request.contextPath}/view/salebillbyaccount">View Sale Voucher By Account</a>
      
  </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/salebillbetweendates">View Sale Voucher By Dates/Account</a>
          
      </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/salebillbetweendatesbygroup">View Sale Voucher By Dates/Group</a>
          
      </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/salebillbetweendatesbyschedule">View Sale Voucher By Dates/Schedule</a>
          
      </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/allbillbetweendates">View All Voucher By Dates/Account</a>
          
      </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/allbillbetweendatesbygroup">View All Vouchers By Dates/Group</a>
          
      </p>
      <p>
          <a href="${pageContext.request.contextPath}/view/allbillbetweendatesbyschedule">View All Vouchers By Dates/Schedule</a>
          
      </p>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/" 
			   method="POST">
	
		<input type="submit" value="Back to Home" />
	
	</form:form>
	
</body>
</html>