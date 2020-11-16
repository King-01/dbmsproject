<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
  
  <title>View Journal Voucher</title>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
  <!-- Reference Bootstrap files -->
  <link rel="stylesheet"
     href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
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

<body>
  <h3>View Journal Voucher by Group</h3>
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
  <form:form action="${pageContext.request.contextPath}/view/journalvoucherbetweendatesbygroup" 
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
      <form:errors path="groupId" cssClass="error alert alert-danger" />
      Select Group: <form:select path="groupId">
        <form:option value="${ null }" label = "Select a Group from this List (*)"></form:option>
        <c:forEach var="oneschedule" items="${items}">
          <form:option value="${oneschedule.getId()}" label = "${ oneschedule.getGroupName() }"></form:option>
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
    For the Group (${ id.getGroupName() })</c:if></h4>
   <c:if test = "${ status != null }" ><h4>
    Overall Status - ${ status } and it sums to a value of ${ price }</h4>
    <h4>List of Journal Vouchers are - </h4></c:if>
  <c:if test = "${ theList != null }">
  <br>
  <startcounter>
  <c:forEach var="schedule" items="${theList}">
    <c:url var="schedulelink" value="/view/specificjournalvoucher">
      <c:param name="jvoucherId" value="${schedule.getJvoucherId()}" />
    </c:url><br>
    <number><a href="${schedulelink}"><c:out value="Date - ${schedule.getDate()} | Account Name - ${ schedule.getAccountName() } | Debit - ${ schedule.getDebitTotal() } | Credit - ${ schedule.getCreditTotal() }"/></a></number>
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