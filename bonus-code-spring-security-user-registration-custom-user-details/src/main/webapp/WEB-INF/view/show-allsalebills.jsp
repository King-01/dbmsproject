  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>View All Sale Vouchers</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=15, shrink-to-fit=no">
  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
</style>
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

  <h4>Overall for all the sale vouchers, current status - ${ status } and its value is ${ tot }- </h4>
  <br>
  <startcounter>
  <c:forEach var="schedule" items="${items}">
    <c:url var="schedulelink" value="/view/specificsalebill">
      <c:param name="id" value="${schedule.getId()}" />
    </c:url><br>
    <number><a href="${schedulelink}"><c:out value="Date - ${schedule.getDate()} | Account Name - ${ schedule.getAccountName() } | Cost - ${ schedule.getCost() }"/></a></number>
    <br>
  </c:forEach>
  </startcounter>
  <button type="submit" class="btn btn-primary" onclick="history.go(-1);" > Back </button>
          <br>
          <br>
          <form:form action="${pageContext.request.contextPath}/" 
                 >
            <button type="submit" class="btn btn-primary">Back to Home</button>
          </form:form>
          <br>
          <form:form action="${pageContext.request.contextPath}/logout" 
                 >
            <button type="submit" class="btn btn-primary">logout</button>
          </form:form>
  
</body>

</html>