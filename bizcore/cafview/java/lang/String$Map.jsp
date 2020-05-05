<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:20px;
}

</style>
	<c:forEach var="entry" items="${myMap}">
 
</c:forEach>
<div class="message">
	Map:<ul>
	<c:forEach var="item" items="${myMap}" varStatus="status">
	
	<li> Key: <c:out value="${entry.key}"/>Value: <c:out value="${entry.value}"/></li>

	
	</c:forEach>
	</ul>
</div>
