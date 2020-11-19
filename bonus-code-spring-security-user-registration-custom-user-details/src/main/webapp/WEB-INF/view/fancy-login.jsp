<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html lang="en">

<head>
  
  <title>Login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
  <!-- Reference Bootstrap files -->
  <link rel="stylesheet"
     href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  body {
  background:#FAF3EC;
   font-family: 'Roboto';
}
::-webkit-input-placeholder { /* Chrome/Opera/Safari */
  color: #748194;
}
::-moz-placeholder { /* Firefox 19+ */
  color: #748194;
}
:-ms-input-placeholder { /* IE 10+ */
  color: #748194;
}
:-moz-placeholder { /* Firefox 18- */
  color: #748194;
}
.container{
   display:none;
   position:absolute;
  width: auto;
  height:auto;
  top: calc(50% - 240px);
  left: calc(40% - 160px);
   border-radius:15px 15px 15px 15px;
}
.c1{
   box-shadow:0 0 10px grey;
   background-color:white;
   width:300px;
   height:500px;
   display:inline-block;
   border-radius:15px 15px 15px 15px;
}

.c11{
   background-image:url('https://i.pinimg.com/736x/b8/09/22/b80922f6ea2daaf36a6627378662803b--deck-of-cards-phone-wallpapers.jpg');
   background-size:300px 400px;
   background-repeat: no-repeat;
   background-color:white;
   width:300px;
   height:400px;
   display:inline-block;
   position:absolute;
   z-index:4;
   border-radius:15px 15px 200px 200px;
}
#left, #right {
   color:white;
   display: inline-block;
   width:146px;
   height: 500px;
   background-color:white;
   cursor:pointer;
}
#left{
   border-radius:15px 0px 0px 15px;
}
#right{
   border-radius:15px 15px 15px 0px;
}
.left_hover{
   color:#EE9BA3;
   box-shadow: 5px 0 18px -10px #333;
   z-index:1;
   position:absolute;
}
.right_hover{
   box-shadow: -5px 0 15px -10px #333;
   z-index:1;
   position:absolute;
}
.s1class{
   color:#748194;
   position:absolute;
   bottom:0;
   left:63%;
   margin-left: -50%;
}
.s1class span,  .s2class span{
   display:block;
}
.su{
   font-size:20px;
}
.s2class{
   color:#748194;
   position:absolute;
   bottom:0;
   right:63%;
   margin-right: -50%;
}
.mainhead{
   color:white;
   font-size:24px;
   text-align:center;
   margin-top:50px;
}
.mainp{
   color:white;
   font-size:13px;
   text-align:center;
   margin-top:10px;
}
.c2{
   background-color:white;
   width:300px;
   height:500px;
   border-radius:15px;
   position:absolute;
   left:370px;
   display:inline-block;
}
.username{
   font-weight: bold;
   width: 200px;
   margin: 0 35px 20px ;
   height: 35px;
   padding: 6px 15px;
   border-radius: 5px;
   outline: none;
   border: none;
   background: #F6F7F9;
   color: #748194;
   font-size: 14px;
}
.btn{
   font-weight: bold;
   width: 230px;
   margin: 0 35px 20px ;
   height: 45px;
   padding: 6px 15px;
   border-radius: 5px;
   outline: none;
   border: none;
   background: #EE9BA3;
   color: white;
   font-size: 14px;
}
.signup1{
   color:#748194;
   font-size:30px;
   text-align:center;
}
a{
   text-decoration: none;
}
.signup2{
   color:#748194;
   font-size:20px;
   text-align:center;
}
.signup{
   display:initial;
}
.signin{
   display:initial;
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
<div class="container">
   <div class="c1">
      
      <div class="c11">
         <h1 class="mainhead">Merchant-Manager</h1>
         <p class="mainp">Just click the buttons below to toggle between SignIn & SignUp</p>
      </div>
      <div id="left"><h1 class="s1class"><span>SIGN</span><span class="su">IN</span>
      </h1></div>
      <div id="right"><h1 class="s2class"><span>SIGN</span><span class="su">UP</span></h1></div>
   </div>
   <div class="c2">
      <form class="signup">
         <h1 class="signup1">SIGN UP</h1>
         <br><br><br><br>
         
      <div>
        <a href="${pageContext.request.contextPath}/register/showRegistrationForm" class="btn " role="button" aria-pressed="true">Click here to Register</a>
      </div>
    </form>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" 
              method="POST" class="form-horizontal signin">
                  <!-- Check for login error -->
                
                  <c:if test="${param.error != null}">
                    
                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                      Invalid username and password.
                    </div>
    
                  </c:if>
                    
                  <!-- Check for logout -->

                  <c:if test="${param.logout != null}">
                                
                    <div class="alert alert-success col-xs-offset-1 col-xs-10">
                      You have been logged out.
                    </div>
                    
                  </c:if>
   			<h1 class="signup1">SIGN IN</h1>
      
            <!-- User name -->
            <h4>Enter your Username - </h4>
            <div style="margin-bottom: 25px" class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
              
              <input type="text" name="username" placeholder="username" class="form-control">
            </div>
			<h4>Enter your Password - </h4>
            <!-- Password -->
            <div style="margin-bottom: 25px" class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
              
              <input type="password" name="password" placeholder="password" class="form-control" >
            </div>

            <!-- Login/Submit Button -->
            <div style="margin-top: 10px" class="form-group">           
              <div class="col-sm-6 controls">
                <button type="submit" class="btn btn-success">Login</button>
              </div>
            </div>

          </form:form>>
      
   </div>
</div>
  <script>
  $(document).ready(function(){
       $(".container").fadeIn(1000);
       $(".s2class").css({"color":"#EE9BA3"});
       $(".s1class").css({"color":"#748194"}); 
       $("#left").removeClass("left_hover");
       $("#right").addClass("right_hover");
       $(".signin").css({"display":"none"});
       $(".signup").css({"display":""});
    });
    $("#right").click(function(){
       $("#left").removeClass("left_hover");
       $(".s2class").css({"color":"#EE9BA3"});
       $(".s1class").css({"color":"#748194"});
       $("#right").addClass("right_hover");
       $(".signin").css({"display":"none"});
       $(".signup").css({"display":""});
    });
    $("#left").click(function(){
       $(".s1class").css({"color":"#EE9BA3"});
       $(".s2class").css({"color":"#748194"}); 
       $("#right").removeClass("right_hover");
       $("#left").addClass("left_hover");
       $(".signup").css({"display":"none"});
       $(".signin").css({"display":""});
    });
  </script>
</body>
</html>