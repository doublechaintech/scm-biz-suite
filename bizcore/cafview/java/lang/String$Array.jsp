<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:20px;
}

</style>

<div class="message">
	strings:<ul><c:forEach var="item" items="${result}" varStatus="status">
	
	<li>${status.index}: ${item}</li>
	
	
	</c:forEach></ul>
</div>
