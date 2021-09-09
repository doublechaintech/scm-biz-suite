<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:20px;
}
.name {
	background-color: lightblue;
}
.value {
	word-break: break-all;
}
</style>

<div class="message">
	Map:<ul>
	<table>
	
	<c:forEach var="entry" items="${result}" varStatus="status">
	<tr>
		<td class="name"><c:out value="${entry.key}"/></td><td class="value"><c:out value="${entry.value}"/></td>
	</tr>
	</c:forEach>
	</table>
	</ul>
</div>
