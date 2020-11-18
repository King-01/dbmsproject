<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta charset="utf-8" />
</head>

<body>
	<!-- Header -->
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
	<div style="margin-left: 50px" >
	<section id="main" class="wrapper">
	<h1>Adding Account and checkout for Purchase Bill</h1>
	 <form:form action="${pageContext.request.contextPath}/process/purchasebill" 
               modelAttribute="addelem"
               class="form-horizontal">
        <form:hidden path="userName"/>
        <form:hidden path="accountName"/>
        <!-- Password -->
        <h3>Date : </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4px" class="input">          
            <form:errors path="date" cssClass="error alert alert-danger" />
							<div class="6u 12u$(small)">
            <form:input type="date" style="margin-left:4px" path="date" placeholder="Date (*)" class="form-control" />
        </div>
        </div>
        <br>
        <h3> Select Account: </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4px" class="input">
            <form:errors path="accountId" cssClass="error alert alert-danger" />
							<div class="6u 12u$(small)">
           <form:select path="accountId" style="margin-left:4px">
                <form:option value="${ null }" label = "Select a Account from this List (*)"></form:option>
                <c:forEach var="oneschedule" items="${listofaccounts}">
                    <form:option value="${oneschedule.getId()}" label = "${ oneschedule.getAccountName() }"></form:option>
                </c:forEach>
            </form:select>  
                    </div>
        </div>
        <br>
        <h3>Description : </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4px" class="input">          
            <form:errors path="description" cssClass="error alert alert-danger" />
							<div class="6u 12u$(small)">
            <form:input path="description" style="margin-left:4px" placeholder="Description" class="form-control" />
        </div></div>
        <br>
        <h3>Truck Details : </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4px" class="input">          
            <form:errors path="trucknumber" cssClass="error alert alert-danger" />
							<div class="6u 12u$(small)">
            <form:input path="trucknumber" style="margin-left:4px" placeholder="Truck Details" class="form-control" />
        </div></div>
        <br>
        <h3>Stock items for the current voucher</h3>
									<div class="table-wrapper">
										<table class="alt">
		<tr>
			<th>No.</th>
			<th>Stock Name</th>
			<th>Quantity</th>
			<th>Rate</th>
			<th>Tax</th>
			<th>Total(Incl. Taxes)</th>
			<th>Tax Breakup </th>
		</tr>
		<c:forEach items="${addelem.theform}" var="thef" varStatus="status">
			<tr>
				<td style='white-space:nowrap;' align="center">${status.count}</td>
				<td style='white-space:nowrap;'><c:out value="${thef.stockitemName}"/></td>
				<td style='white-space:nowrap;'><c:out value="${thef.quantity}"/></td>
				<td style='white-space:nowrap;'><c:out value="${thef.rate}"/></td>
				<td style='white-space:nowrap;'><c:out value="${thef.tax}"/></td>
				<td style='white-space:nowrap;'><c:out value="${thef.total}" /></td>
				<td style='white-space:nowrap;'><c:out value="${thef.taxbreakup}"/></td>
			</tr>
			<input type="hidden" name="theform[${status.index}].stockitemquantity" value="${thef.stockitemquantity}"/>
			<input type="hidden" name="theform[${status.index}].id" value="${thef.id}"/>
			<input type="hidden" name="theform[${ status.index }].stockitemName" value="${thef.stockitemName}" readonly="true"/>
			<input type="hidden" name="theform[${ status.index }].quantity" value="${thef.quantity}" readonly="true"/>
			<input type="hidden" name="theform[${ status.index }].rate" value="${thef.rate}" readonly="true"/>
			<input type="hidden" name="theform[${ status.index }].tax" value="${thef.tax}" readonly="true"/>
			<input type="hidden" name="theform[${ status.index }].total" value="${thef.total}" readonly="true" />
			<input type="hidden" name="theform[${ status.index }].taxbreakup" value="${thef.taxbreakup}" readonly="true"/>
						
		</c:forEach>
		
	</table>
	</div>
	<br>
	<h3>Total Amount of bill : </h3>	
        <div style="margin-bottom: 25pxl;margin-left: 4px" class="input">          
            <form:errors path="cost" cssClass="error alert alert-danger" />
							<div class="6u 12u$(small)">
            <form:input path="cost" placeholder="Cost (*)" style="margin-left:4px" class="form-control" readonly="true"/>
        </div></div>
        <!-- Register Button -->
        <div style="margin-top: 10px; " class="form-group">                      
            <div class="col-sm-6 controls">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </form:form>
</section>
</div>
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