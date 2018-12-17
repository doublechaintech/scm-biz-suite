
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<fmt:setLocale value="zh_CN"/>
<c:set var="ownerBeanName" value="secUser" scope="request"/>
<c:set var="ownerClassName" value="SecUser" scope="request"/>

<!DOCTYPE html>
<html lang="en">

<head>
	<base href="${baseURL}/" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${userContext.localeMap['@system_name']}</title>

    <!-- Bootstrap Core CSS -->
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./bootstrap/signin.css" rel="stylesheet">
    <!-- Custom CSS -->
     <link href="./bootstrap/sec-user.css" rel="stylesheet">
     <link href="./bootstrap/font-awesome.min.css" rel="stylesheet">
    <script src="./scripts/modernizr.min.js" type="text/javascript"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    

    <!-- Page Content -->
    <div class="container">
    
    	
    	<div class="row">
        <div class="col-xs-12 col-lg-12 col-lm-12 col-xm-12 text-center sysname">
       
        <h1>${userContext.localeMap['@system_name']}</h1>
        
        </div>
       </div>
    
		
      <jsp:include page="../userapp/UserApp$Blocks.jsp" />

 


    </div>
    <!-- /.container -->
    
    
 <div id="footer">
  <div class="col-xs-12 navbar-inverse navbar-fixed-bottom">
  <div class="row" id="bottomNav">
   <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-home"></i><br/>${userContext.localeMap['@home_page']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br/>${userContext.localeMap['@message']}</a>
    </div>

    <div class="col-xs-3 text-center"><a href="./secUserManager/manage//">
    	<i class="glyphicon glyphicon-user"></i><br/>${userContext.localeMap['@account']}</a>
    </div>
    <div class="col-xs-3 text-center"><a href="./secUserManager/showlogin/">
    	<i class="glyphicon glyphicon-user"></i><br/>${userContext.localeMap['@log_out']}</a>
    </div>
  </div>
  </div>
</div><!-- /.footer -->


    <!-- jQuery -->
    <script src="./scripts/jquery-1.9.1.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./bootstrap/bootstrap.min.js"></script>
   
 

</body>

</html>

