<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html lang="en">

<head>
    
    <title>View Purchase Bill</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    <h1>View Purchase Bill</h1>
    <form:form action="${pageContext.request.contextPath}/" 
               modelAttribute="addelem"
               class="form-horizontal">
        <h3>Purchase voucher Id - </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">          
            <form:errors path="id" cssClass="error alert alert-danger" />
        <form:input path="id" placeholder="Purchase Bill Id (*)" class="form-control" readonly="true" />
        </div>
        <br>
        <h3>User Name - </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">          
            <form:errors path="userName" cssClass="error alert alert-danger" />
        <form:input path="userName" placeholder="User Name (*)" class="form-control" readonly="true" />
        <!-- Password -->
        </div>
        <br>
        <h3>Account Name - </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">          
            <form:errors path="accountName" cssClass="error alert alert-danger" />
        <form:input path="accountName" placeholder="User Name (*)" class="form-control" readonly="true" />
        <!-- Password -->
        </div>
        <br>
        <h3>Date - </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">          
            <form:errors path="date" cssClass="error alert alert-danger" />
            
            <form:input type="date" path="date" placeholder="Date (*)" class="form-control" readonly="true"/>
        </div>
        <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">
            <form:errors path="accountId" cssClass="error alert alert-danger" />
            <form:input type="hidden"  path="accountId" placeholder="Account id (*)" class="form-control" readonly="true"/>
        
                    
        </div>
        <br>
        <h3>Total Amount - </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">          
            <form:errors path="cost" cssClass="error alert alert-danger" />
            
            <form:input path="cost" placeholder="Credit (*)" class="form-control" readonly="true"/>
        </div>
        <br>
        <h3>Description - </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">          
            <form:errors path="description" cssClass="error alert alert-danger" />
            
            <form:input path="description" placeholder="Not Available" class="form-control" readonly="true" />
        </div>
        <br>
        <h3>Truck Details - </h3>
        <div style="margin-bottom: 25pxl;margin-left: 4pxl" class="input">          
            <form:errors path="trucknumber" cssClass="error alert alert-danger" />
            
            <form:input path="trucknumber" placeholder="Not Available" class="form-control" readonly="true" />
        </div>
        <br>
        <h3>Stock items for the current voucher -</h3>
  <div class="table-wrapper">
        <table class = "alt">
    <tr>
      <th>No.</th>
      <th>Stock Name</th>
      <th>Quantity</th>
      <th>Rate</th>
      <th>Tax</th>
      <th>Total(Incl. Taxes)</th>
      <th>Tax Breakup </th>
    </tr>
    <c:forEach items="${items}" var="thef" varStatus="status">
      <tr>
        <td style='white-space:nowrap;' align="center">${status.count}</td>
        <td style='white-space:nowrap;'><c:out value="${thef.itemName}"/></td>
        <td style='white-space:nowrap;'><c:out value="${thef.quantity}"/></td>
        <td style='white-space:nowrap;'><c:out value="${thef.rate}"/></td>
        <td style='white-space:nowrap;'><c:out value="${thef.tax}"/></td>
        <td style='white-space:nowrap;'><c:out value="${thef.totalAmount}" /></td>
        <td style='white-space:nowrap;'><c:out value="${thef.taxBreakup}"/></td>
      </tr>
      <input type="hidden" name="theform[${status.index}].id" value="${thef.id}"/>
      <input type="hidden" name="theform[${ status.index }].itemName" value="${thef.itemName}" readonly="true"/>
      <input type="hidden" name="theform[${ status.index }].quantity" value="${thef.quantity}" readonly="true"/>
      <input type="hidden" name="theform[${ status.index }].rate" value="${thef.rate}" readonly="true"/>
      <input type="hidden" name="theform[${ status.index }].tax" value="${thef.tax}" readonly="true"/>
      <input type="hidden" name="theform[${ status.index }].totalAmount" value="${thef.totalAmount}" readonly="true" />
      <input type="hidden" name="theform[${ status.index }].taxBreakup" value="${thef.taxBreakup}" readonly="true"/>
            
    </c:forEach>
    </table>
    </div>
    </form:form>
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