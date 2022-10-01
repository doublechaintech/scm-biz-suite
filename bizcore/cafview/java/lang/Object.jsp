<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:20px;
}

.textbox{

	width: 100%;
	height: 90vh;
}
</style>

<div class="message">

Please configure ${result} <br/>

<textarea  class="textbox">
${rootResult.resultExpr}
</textarea>
	
           
</div>
