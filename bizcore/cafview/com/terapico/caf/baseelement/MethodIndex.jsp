<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<base href="${baseURL}/" /> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Bean Manage Console</title>
<script src="../scripts/jquery-1.9.1.js" type="text/javascript"></script>
<script src="../scripts/common.js" type="text/javascript"></script>
<style>
.toolbar {
	width: 100%; height: 40px; 	float:left; 	
	font-size: 20px; text-align: left; 	padding-left: 10px;
	padding-top: 10px; background: #111111; 	
	overflow:auto; 	border: 1px solid black;
	color: white; letter-spacing:2px
}
.menu {
	width: 20%; 	 	
	float:left; 	
	font-size: 20px; text-align: left; 	padding-left: 30px;
	padding-top: 30px; 	background: #eeeeee; 	overflow:auto;
	margin: 0; height: 100%
}
.content {
	width: 70%; 	height: 630px; 	text-align: center; 	
	#border: 1px solid grey; 
	#padding-top: 800px;
	float:right; 	background: #ffffff;
	padding-top: 30px; 
}

html,body{
	margin: 0; padding: 0; height: 100%; overflow:hidden;
}

</style>

<script>


	

	$(document).ready(function() {
		//alert($(location).attr('href'));
		var currentURL=$(location).attr('href');
		var index=currentURL.indexOf("#");
		if(index<0){
			return;
		}		
		var methodName=currentURL.substring(index+1);
		reqURI =  encodeURIComponent(methodName) + "/";		
		fillResult(reqURI,"#content");
		
	});
</script>
</head>

<body>
	<div class="toolbar" >Spring Beans</div>
	<div class="menu" >

          <c:forEach var="method" items="${result.items}">  <a href="#${method.name}" class="action">${method.friendName}</a><br/></c:forEach>
	</div>
	<div class="content" id="content">Home Info</div>
</body>
</html>
