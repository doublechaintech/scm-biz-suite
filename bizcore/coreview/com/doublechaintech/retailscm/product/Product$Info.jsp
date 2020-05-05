
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty product}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Product">${userContext.localeMap['product']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./productManager/view/${product.id}/"> ${product.id}</a></li>
<li><span>${userContext.localeMap['product.name']}</span> ${product.name}</li>
<li><span>${userContext.localeMap['product.origin']}</span> ${product.origin}</li>
<li><span>${userContext.localeMap['product.remark']}</span> ${product.remark}</li>
<li><span>${userContext.localeMap['product.brand']}</span> ${product.brand}</li>
<li><span>${userContext.localeMap['product.picture']}</span> ${product.picture}</li>
<li><span>${userContext.localeMap['product.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${product.lastUpdateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




