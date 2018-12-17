<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:20px;
}

</style>

<div class="message">
           Please configurate ${result} <%-- (a ${result.class.name}) --%> 
           
           <textarea rows="40" cols="80">${rootResult.resultExpr}</textarea>
	
           
</div>
