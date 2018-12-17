
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<!DOCTYPE html>
<!-- saved from url=(0049)http://v4-alpha.getbootstrap.com/examples/signin/ -->
<html lang="en" slick-uniqueid="3">
<head>

	<base href="${baseURL}/" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./bootstrap/signin.css" rel="stylesheet">
  <style type="text/css">* {
 text-shadow: transparent 0px 0px 0px, rgba(0,0,0,0.68) 0px 0px 0px !important; 
}</style><style id="style-1-cropbar-clipper">/* Copyright 2014 Evernote Corporation. All rights reserved. */
.en-markup-crop-options {
    top: 18px !important;
    left: 50% !important;
    margin-left: -100px !important;
    width: 200px !important;
    border: 2px rgba(255,255,255,.38) solid !important;
    border-radius: 4px !important;
}

.en-markup-crop-options div div:first-of-type {
    margin-left: 0px !important;
}
</style>



</head>

  <body data-feedly-mini="yes">

    <div class="container">
      <c:if test="${not empty result.errorMessageList}" > 
    	 <ul>   	
    	<c:forEach var="item" items="${result.errorMessageList}">
  		<div class="alert alert-danger">
   			${item.sourcePosition} ${item.body}
		</div>
    	</c:forEach>
    	</ul>
   
    </c:if>

      <form class="form-signin" method="post" action="./secUserManager/login/userId/password/">
        <h2 class="form-signin-heading sysname">请输入用户名和密码</h2>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="inputEmail" name="userId" class="form-control" placeholder="用户名" required="" autofocus="">
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required="">
        <input type="hidden" name="" value="abcv0N0qcok4FeDLxU1rv" required="">
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container 	private String usernameParmeter;
	private String passwordParmeter;-->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./bootstrap/ie10-viewport-bug-workaround.js"></script>
	<script src="./bootstrap/jquery.min.js"></script>

<script>
  	
		//alert($(location).attr('href'));
		var oldLink=location.href;
		var index=oldLink.indexOf("?__logout__");
		if(index>0){
			var newLink=oldLink.substring(0,index);
			history.pushState({}, '', newLink);
			console.log(newLink);
		}

	
</script>

</body></html>





