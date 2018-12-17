
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty consumerOrderShipment}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ConsumerOrderShipment" style="color: green">${userContext.localeMap['consumer_order_shipment']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['consumer_order_shipment.id']}</span> ${consumerOrderShipment.id}</li>
<li><span>${userContext.localeMap['consumer_order_shipment.who']}</span> ${consumerOrderShipment.who}</li>
<li><span>${userContext.localeMap['consumer_order_shipment.ship_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${consumerOrderShipment.shipTime}" /></li>

	
	</ul>
</div>



</c:if>


