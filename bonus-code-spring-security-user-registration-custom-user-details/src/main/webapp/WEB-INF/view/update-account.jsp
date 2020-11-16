<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
    
    <title>Update Account</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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

    <div>
        
        <div id="loginbox" style="margin-top: 50px;"
            class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
            
            <div class="panel panel-primary">

                <div class="panel-heading">
                    <div class="panel-title">Update Account</div>
                </div>

                <div style="padding-top: 30px" class="panel-body">

                    <!-- Registration Form -->
                    <form:form action="${pageContext.request.contextPath}/update/account" 
                               modelAttribute="theform"
                               class="form-horizontal">

                     
                        <form:hidden path="prev"/>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="accountName" cssClass="error alert alert-danger" />
                            
                            Enter new Account Name (*): <form:input path="accountName" placeholder="Account Name (*)" class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="addressLine1" cssClass="error alert alert-danger" />
                            
                            Enter new Address Line1 (*)): <form:input path="addressLine1" placeholder="Address Line 1" class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="addressLine2" cssClass="error alert alert-danger" />
                            
                            Enter new Address Line2: <form:input path="addressLine2" placeholder="Address Line 2" class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="city" cssClass="error alert alert-danger" />
                            
                            Enter new City (*): <form:input path="city" placeholder="City" class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="pincode" cssClass="error alert alert-danger" />
                            
                            Enter new Pincode (*): <form:input path="pincode" placeholder="Pincode" class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="HsnNumber" cssClass="error alert alert-danger" />
                            
                            Enter new HsnNumber: <form:input path="HsnNumber" placeholder="Hsn Number" class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="guarantorName" cssClass="error alert alert-danger" />
                            
                            Enter new Guarantor Name (*): <form:input path="guarantorName" placeholder="Guarantor Name" class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="mobileNumber1" cssClass="error alert alert-danger" />
                            
                            Enter new Mobile Number (*): <form:input path="mobileNumber1" placeholder="Mobile Number" class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="mobileNumber2" cssClass="error alert alert-danger" />
                            
                            Enter new Alternative Mobile Number : <form:input path="mobileNumber2" placeholder="Alternate Mobile Number" class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="pan" cssClass="error alert alert-danger" />
                            
                            Enter new Pan: <form:input path="pan" placeholder="Pan " class="form-control"/>
                        </div>
                        <!-- Password -->
                        <div style="margin-bottom: 25px" class="input-account">
                            <span class="input-account-addon"><i class="glyphicon glyphicon-lock"></i></span> 
                            <form:errors path="confirmPassword" cssClass="error alert alert-danger" />
                            
                            Confirm Password:<form:password path="confirmPassword" placeholder="Confirm Password(*)" class="form-control"/>
                        </div>
                        <div style="margin-top: 10px" class="form-account">                       
                            <div class="col-sm-6 controls">
                                <button type="submit" class="btn btn-primary">Update</button>
                            </div>
                        </div>
                    </form:form>
                    <br>
                    <button type="submit" class="btn btn-primary" onclick="history.go(-1);" > Back </button>
                    
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
                    
                </div>

            </div>

        </div>

    </div>
    </body>
</html>