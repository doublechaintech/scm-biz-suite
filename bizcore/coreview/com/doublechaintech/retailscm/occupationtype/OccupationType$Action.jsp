
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty occupationType}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A OccupationType" style="color: green">${userContext.localeMap['occupation_type']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['occupation_type.id']}</span> ${occupationType.id}</li>
<li><span>${userContext.localeMap['occupation_type.code']}</span> ${occupationType.code}</li>
<li><span>${userContext.localeMap['occupation_type.description']}</span> ${occupationType.description}</li>
<li><span>${userContext.localeMap['occupation_type.detail_description']}</span> ${occupationType.detailDescription}</li>

	
	</ul>
</div>



</c:if>


