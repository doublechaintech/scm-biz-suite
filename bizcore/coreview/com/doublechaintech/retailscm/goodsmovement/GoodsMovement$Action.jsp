
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty goodsMovement}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A GoodsMovement" style="color: green">${userContext.localeMap['goods_movement']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['goods_movement.id']}</span> ${goodsMovement.id}</li>
<li><span>${userContext.localeMap['goods_movement.move_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${goodsMovement.moveTime}" /></li>
<li><span>${userContext.localeMap['goods_movement.facility']}</span> ${goodsMovement.facility}</li>
<li><span>${userContext.localeMap['goods_movement.facility_id']}</span> ${goodsMovement.facilityId}</li>
<li><span>${userContext.localeMap['goods_movement.from_ip']}</span> ${goodsMovement.fromIp}</li>
<li><span>${userContext.localeMap['goods_movement.user_agent']}</span> ${goodsMovement.userAgent}</li>
<li><span>${userContext.localeMap['goods_movement.session_id']}</span> ${goodsMovement.sessionId}</li>
<li><span>${userContext.localeMap['goods_movement.latitude']}</span> ${goodsMovement.latitude}</li>
<li><span>${userContext.localeMap['goods_movement.longitude']}</span> ${goodsMovement.longitude}</li>

	
	</ul>
</div>



</c:if>


