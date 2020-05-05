
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStore}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A RetailStore" style="color: green">${userContext.localeMap['retail_store']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store.id']}</span> ${retailStore.id}</li>
<li><span>${userContext.localeMap['retail_store.name']}</span> ${retailStore.name}</li>
<li><span>${userContext.localeMap['retail_store.telephone']}</span> ${retailStore.telephone}</li>
<li><span>${userContext.localeMap['retail_store.owner']}</span> ${retailStore.owner}</li>
<li><span>${userContext.localeMap['retail_store.founded']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStore.founded}" /></li>
<li><span>${userContext.localeMap['retail_store.latitude']}</span> ${retailStore.latitude}</li>
<li><span>${userContext.localeMap['retail_store.longitude']}</span> ${retailStore.longitude}</li>
<li><span>${userContext.localeMap['retail_store.description']}</span> ${retailStore.description}</li>
<li><span>${userContext.localeMap['retail_store.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStore.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


