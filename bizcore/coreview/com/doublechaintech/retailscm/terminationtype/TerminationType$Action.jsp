
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty terminationType}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A TerminationType" style="color: green">${userContext.localeMap['termination_type']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['termination_type.id']}</span> ${terminationType.id}</li>
<li><span>${userContext.localeMap['termination_type.code']}</span> ${terminationType.code}</li>
<li><span>${userContext.localeMap['termination_type.base_description']}</span> ${terminationType.baseDescription}</li>
<li><span>${userContext.localeMap['termination_type.detail_description']}</span> ${terminationType.detailDescription}</li>

	
	</ul>
</div>



</c:if>


