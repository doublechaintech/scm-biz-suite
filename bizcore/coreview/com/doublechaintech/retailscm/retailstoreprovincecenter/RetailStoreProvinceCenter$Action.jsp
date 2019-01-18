
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreProvinceCenter}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A RetailStoreProvinceCenter" style="color: green">${userContext.localeMap['retail_store_province_center']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store_province_center.id']}</span> ${retailStoreProvinceCenter.id}</li>
<li><span>${userContext.localeMap['retail_store_province_center.name']}</span> ${retailStoreProvinceCenter.name}</li>
<li><span>${userContext.localeMap['retail_store_province_center.founded']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStoreProvinceCenter.founded}" /></li>
<li><span>${userContext.localeMap['retail_store_province_center.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStoreProvinceCenter.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


