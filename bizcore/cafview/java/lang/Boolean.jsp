<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:20px;
}

</style>

<div class="message">
	<c:if test="${result}" >执行成功</c:if><c:if test="${not result}" >执行失败</c:if>
</div>
