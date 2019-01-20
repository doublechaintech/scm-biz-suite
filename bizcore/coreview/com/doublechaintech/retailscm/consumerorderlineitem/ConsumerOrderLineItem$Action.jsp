
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty consumerOrderLineItem}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ConsumerOrderLineItem" style="color: green">${userContext.localeMap['consumer_order_line_item']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['consumer_order_line_item.id']}</span> ${consumerOrderLineItem.id}</li>
<li><span>${userContext.localeMap['consumer_order_line_item.sku_id']}</span> ${consumerOrderLineItem.skuId}</li>
<li><span>${userContext.localeMap['consumer_order_line_item.sku_name']}</span> ${consumerOrderLineItem.skuName}</li>
<li><span>${userContext.localeMap['consumer_order_line_item.price']}</span> <fmt:formatNumber type="currency"  value="${consumerOrderLineItem.price}" /></li>
<li><span>${userContext.localeMap['consumer_order_line_item.quantity']}</span> ${consumerOrderLineItem.quantity}</li>
<li><span>${userContext.localeMap['consumer_order_line_item.amount']}</span> <fmt:formatNumber type="currency"  value="${consumerOrderLineItem.amount}" /></li>
<li><span>${userContext.localeMap['consumer_order_line_item.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${consumerOrderLineItem.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


