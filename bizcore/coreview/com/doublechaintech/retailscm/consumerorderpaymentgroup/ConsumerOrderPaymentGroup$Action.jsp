
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty consumerOrderPaymentGroup}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ConsumerOrderPaymentGroup" style="color: green">${userContext.localeMap['consumer_order_payment_group']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['consumer_order_payment_group.id']}</span> ${consumerOrderPaymentGroup.id}</li>
<li><span>${userContext.localeMap['consumer_order_payment_group.name']}</span> ${consumerOrderPaymentGroup.name}</li>
<li><span>${userContext.localeMap['consumer_order_payment_group.card_number']}</span> ${consumerOrderPaymentGroup.cardNumber}</li>

	
	</ul>
</div>



</c:if>


