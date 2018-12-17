
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplyOrderShippingGroup}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SupplyOrderShippingGroup" style="color: green">${userContext.localeMap['supply_order_shipping_group']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['supply_order_shipping_group.id']}</span> ${supplyOrderShippingGroup.id}</li>
<li><span>${userContext.localeMap['supply_order_shipping_group.name']}</span> ${supplyOrderShippingGroup.name}</li>
<li><span>${userContext.localeMap['supply_order_shipping_group.amount']}</span> <fmt:formatNumber type="currency"  value="${supplyOrderShippingGroup.amount}" /></li>

	
	</ul>
</div>



</c:if>


