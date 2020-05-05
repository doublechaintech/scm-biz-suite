
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStore}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A RetailStore">${userContext.localeMap['retail_store']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./retailStoreManager/view/${retailStore.id}/"> ${retailStore.id}</a></li>
<li><span>${userContext.localeMap['retail_store.name']}</span> ${retailStore.name}</li>
<li><span>${userContext.localeMap['retail_store.telephone']}</span> ${retailStore.telephone}</li>
<li><span>${userContext.localeMap['retail_store.owner']}</span> ${retailStore.owner}</li>
<li><span>${userContext.localeMap['retail_store.founded']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStore.founded}" /></li>
<li><span>${userContext.localeMap['retail_store.latitude']}</span> ${retailStore.latitude}</li>
<li><span>${userContext.localeMap['retail_store.longitude']}</span> ${retailStore.longitude}</li>
<li><span>${userContext.localeMap['retail_store.description']}</span> ${retailStore.description}</li>
<li><span>${userContext.localeMap['retail_store.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStore.lastUpdateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




