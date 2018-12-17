
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplyOrderPaymentGroup}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SupplyOrderPaymentGroup" style="color: green">${userContext.localeMap['supply_order_payment_group']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['supply_order_payment_group.id']}</span> ${supplyOrderPaymentGroup.id}</li>
<li><span>${userContext.localeMap['supply_order_payment_group.name']}</span> ${supplyOrderPaymentGroup.name}</li>
<li><span>${userContext.localeMap['supply_order_payment_group.card_number']}</span> ${supplyOrderPaymentGroup.cardNumber}</li>

	
	</ul>
</div>



</c:if>


