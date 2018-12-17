
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplyOrderDelivery}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SupplyOrderDelivery" style="color: green">${userContext.localeMap['supply_order_delivery']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['supply_order_delivery.id']}</span> ${supplyOrderDelivery.id}</li>
<li><span>${userContext.localeMap['supply_order_delivery.who']}</span> ${supplyOrderDelivery.who}</li>
<li><span>${userContext.localeMap['supply_order_delivery.delivery_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${supplyOrderDelivery.deliveryTime}" /></li>

	
	</ul>
</div>



</c:if>


