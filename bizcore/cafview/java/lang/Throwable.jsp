<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:20px;
	color: red;
}

</style>
<!-- App engine not work for  Throwable printStackTrace(writer)-->
<div class="message">
            ${result.message}<br/>
<textarea rows="20" cols="100">
${result}
<c:forEach var="stackframe" items="${result.stackTrace}">	${stackframe}
</c:forEach>
<c:if test="${not empty result.cause }">
Caused By ${result.cause}
<c:forEach var="stackframe" items="${result.cause.stackTrace}">	${stackframe}
</c:forEach>
</c:if> 

</textarea>
</div>
