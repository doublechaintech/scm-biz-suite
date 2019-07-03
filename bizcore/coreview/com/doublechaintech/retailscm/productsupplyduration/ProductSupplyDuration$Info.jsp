
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty productSupplyDuration}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A ProductSupplyDuration">${userContext.localeMap['product_supply_duration']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./productSupplyDurationManager/view/${productSupplyDuration.id}/"> ${productSupplyDuration.id}</a></li>
<li><span>${userContext.localeMap['product_supply_duration.quantity']}</span> ${productSupplyDuration.quantity}</li>
<li><span>${userContext.localeMap['product_supply_duration.duration']}</span> ${productSupplyDuration.duration}</li>
<li><span>${userContext.localeMap['product_supply_duration.price']}</span> <fmt:formatNumber type="currency"  value="${productSupplyDuration.price}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




