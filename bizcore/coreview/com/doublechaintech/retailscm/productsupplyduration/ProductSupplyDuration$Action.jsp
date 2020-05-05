
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty productSupplyDuration}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ProductSupplyDuration" style="color: green">${userContext.localeMap['product_supply_duration']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['product_supply_duration.id']}</span> ${productSupplyDuration.id}</li>
<li><span>${userContext.localeMap['product_supply_duration.quantity']}</span> ${productSupplyDuration.quantity}</li>
<li><span>${userContext.localeMap['product_supply_duration.duration']}</span> ${productSupplyDuration.duration}</li>
<li><span>${userContext.localeMap['product_supply_duration.price']}</span> <fmt:formatNumber type="currency"  value="${productSupplyDuration.price}" /></li>

	
	</ul>
</div>



</c:if>


