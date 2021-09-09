<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:30px;
	color: red;
}

</style>

<div class="message">
${result.message}!
</div>
