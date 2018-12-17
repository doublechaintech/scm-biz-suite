
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty consumerOrderPriceAdjustment}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ConsumerOrderPriceAdjustment" style="color: green">${userContext.localeMap['consumer_order_price_adjustment']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['consumer_order_price_adjustment.id']}</span> ${consumerOrderPriceAdjustment.id}</li>
<li><span>${userContext.localeMap['consumer_order_price_adjustment.name']}</span> ${consumerOrderPriceAdjustment.name}</li>
<li><span>${userContext.localeMap['consumer_order_price_adjustment.amount']}</span> <fmt:formatNumber type="currency"  value="${consumerOrderPriceAdjustment.amount}" /></li>
<li><span>${userContext.localeMap['consumer_order_price_adjustment.provider']}</span> ${consumerOrderPriceAdjustment.provider}</li>

	
	</ul>
</div>



</c:if>


