
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplyOrderLineItem}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SupplyOrderLineItem" style="color: green">${userContext.localeMap['supply_order_line_item']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['supply_order_line_item.id']}</span> ${supplyOrderLineItem.id}</li>
<li><span>${userContext.localeMap['supply_order_line_item.sku_id']}</span> ${supplyOrderLineItem.skuId}</li>
<li><span>${userContext.localeMap['supply_order_line_item.sku_name']}</span> ${supplyOrderLineItem.skuName}</li>
<li><span>${userContext.localeMap['supply_order_line_item.amount']}</span> <fmt:formatNumber type="currency"  value="${supplyOrderLineItem.amount}" /></li>
<li><span>${userContext.localeMap['supply_order_line_item.quantity']}</span> ${supplyOrderLineItem.quantity}</li>
<li><span>${userContext.localeMap['supply_order_line_item.unit_of_measurement']}</span> ${supplyOrderLineItem.unitOfMeasurement}</li>

	
	</ul>
</div>



</c:if>


