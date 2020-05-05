
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty terminationReason}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A TerminationReason" style="color: green">${userContext.localeMap['termination_reason']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['termination_reason.id']}</span> ${terminationReason.id}</li>
<li><span>${userContext.localeMap['termination_reason.code']}</span> ${terminationReason.code}</li>
<li><span>${userContext.localeMap['termination_reason.description']}</span> ${terminationReason.description}</li>

	
	</ul>
</div>



</c:if>


