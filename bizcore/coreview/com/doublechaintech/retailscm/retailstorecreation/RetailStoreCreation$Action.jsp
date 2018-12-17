
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreCreation}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A RetailStoreCreation" style="color: green">${userContext.localeMap['retail_store_creation']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store_creation.id']}</span> ${retailStoreCreation.id}</li>
<li><span>${userContext.localeMap['retail_store_creation.comment']}</span> ${retailStoreCreation.comment}</li>

	
	</ul>
</div>



</c:if>


