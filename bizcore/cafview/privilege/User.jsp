<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:30px;

}

.labelgroup{
	width: 20%; 	 	
	float:left; 	
	text-align: right; 	padding-left: 30px;
	padding-top: 30px; 	
	overflow:auto;
	margin: 0; height: 100%
}
.valuegroup{
	width: 75%; 	
	text-align: left;
	float:right; 	
	background: #ffffff;

	padding-top: 30px; 
}

</style>

<div class="message">
	<div class="labelgroup">
		ID:<br/>
		User:<br/>
		Pass:<br/>
	</div>
	<div class="valuegroup">
		${result.id}<br/>
		${result.username}<br/>
		${result.password} <br/>
</div>

</div>
