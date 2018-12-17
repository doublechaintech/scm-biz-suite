
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty goodsAllocation}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A GoodsAllocation" style="color: green">${userContext.localeMap['goods_allocation']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['goods_allocation.id']}</span> ${goodsAllocation.id}</li>
<li><span>${userContext.localeMap['goods_allocation.location']}</span> ${goodsAllocation.location}</li>
<li><span>${userContext.localeMap['goods_allocation.latitude']}</span> ${goodsAllocation.latitude}</li>
<li><span>${userContext.localeMap['goods_allocation.longitude']}</span> ${goodsAllocation.longitude}</li>

	
	</ul>
</div>



</c:if>


