<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
  
  <title>View Sale Voucher</title>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
  <!-- Reference Bootstrap files -->
  <link rel="stylesheet"
     href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

  <h3>View Sale Voucher by Schedule</h3>
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
  <form:form action="${pageContext.request.contextPath}/view/salebillbetweendatesbyschedule" 
           modelAttribute="theform"
           class="form-horizontal">
    <!-- Password -->
    <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">      
      <form:errors path="startDate" cssClass="error alert alert-danger" />
      Start Date : <form:input type="date"  path="startDate" placeholder="Date (*)" class="form-control" />
    </div>
    <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">      
      <form:errors path="endDate" cssClass="error alert alert-danger" />
      End Date : <form:input type="date"  path="endDate" placeholder="Date (*)" class="form-control" />
    </div>
    <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">
      <form:errors path="scheduleId" cssClass="error alert alert-danger" />
      Select Schedule: <form:select path="scheduleId">
        <form:option value="${ null }" label = "Select a Schedule from this List (*)"></form:option>
        <c:forEach var="oneschedule" items="${items}">
          <form:option value="${oneschedule.getId()}" label = "${ oneschedule.getScheduleName() }"></form:option>
        </c:forEach>
      </form:select>  
          
    </div>
    <!-- Register Button -->
    <div style="margin-top: 10px; margin-left:4px" class="form-group">            
      <div class="col-sm-6 controls">
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
  </form:form>
  
  <h4><c:if test="${ id != null }" >
    For the Schedule (${ id.getScheduleName() })</c:if></h4>
   <c:if test = "${ status != null }" ><h4>
    Overall Status - ${ status } and it sums to a value of ${ price }</h4>
    <h4>List of Sale Vouchers are - </h4></c:if>
  <c:if test = "${ theList != null }">
  <br>
  <startcounter>
  <c:forEach var="schedule" items="${theList}">
    <c:url var="schedulelink" value="/view/specificsalebill">
      <c:param name="id" value="${schedule.getId()}" />
    </c:url><br>
    <number><a href="${schedulelink}"><c:out value="Date - ${schedule.getDate()} | Account Name - ${ schedule.getAccountName() } | Cost - ${ schedule.getCost() }"/></a></number>
    <br>
  </c:forEach>
  </startcounter>
  </c:if>
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