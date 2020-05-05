
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreCountryCenter}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A RetailStoreCountryCenter">${userContext.localeMap['retail_store_country_center']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./retailStoreCountryCenterManager/view/${retailStoreCountryCenter.id}/"> ${retailStoreCountryCenter.id}</a></li>
<li><span>${userContext.localeMap['retail_store_country_center.name']}</span> ${retailStoreCountryCenter.name}</li>
<li><span>${userContext.localeMap['retail_store_country_center.service_number']}</span> ${retailStoreCountryCenter.serviceNumber}</li>
<li><span>${userContext.localeMap['retail_store_country_center.founded']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStoreCountryCenter.founded}" /></li>
<li><span>${userContext.localeMap['retail_store_country_center.web_site']}</span> ${retailStoreCountryCenter.webSite}</li>
<li><span>${userContext.localeMap['retail_store_country_center.address']}</span> ${retailStoreCountryCenter.address}</li>
<li><span>${userContext.localeMap['retail_store_country_center.operated_by']}</span> ${retailStoreCountryCenter.operatedBy}</li>
<li><span>${userContext.localeMap['retail_store_country_center.legal_representative']}</span> ${retailStoreCountryCenter.legalRepresentative}</li>
<li><span>${userContext.localeMap['retail_store_country_center.description']}</span> ${retailStoreCountryCenter.description}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




