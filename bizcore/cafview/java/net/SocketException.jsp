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
            网络错误 ${result.message}<br/>
            <textarea rows="20" cols="100"><%
	java.lang.Throwable t=(Throwable)request.getAttribute("result");
	java.io.PrintWriter writer = response.getWriter();
	t.printStackTrace(writer);

%></textarea>
</div>
