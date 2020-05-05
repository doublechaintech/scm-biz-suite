
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty mobileApp}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A MobileApp" style="color: green">${userContext.localeMap['mobile_app']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['mobile_app.id']}</span> ${mobileApp.id}</li>
<li><span>${userContext.localeMap['mobile_app.name']}</span> ${mobileApp.name}</li>

	
	</ul>
</div>



</c:if>


