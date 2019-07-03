
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty sku}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Sku">${userContext.localeMap['sku']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./skuManager/view/${sku.id}/"> ${sku.id}</a></li>
<li><span>${userContext.localeMap['sku.name']}</span> ${sku.name}</li>
<li><span>${userContext.localeMap['sku.size']}</span> ${sku.size}</li>
<li><span>${userContext.localeMap['sku.barcode']}</span> ${sku.barcode}</li>
<li><span>${userContext.localeMap['sku.package_type']}</span> ${sku.packageType}</li>
<li><span>${userContext.localeMap['sku.net_content']}</span> ${sku.netContent}</li>
<li><span>${userContext.localeMap['sku.price']}</span> <fmt:formatNumber type="currency"  value="${sku.price}" /></li>
<li><span>${userContext.localeMap['sku.picture']}</span> ${sku.picture}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




