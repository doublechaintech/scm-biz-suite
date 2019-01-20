
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreMemberCoupon}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A RetailStoreMemberCoupon" style="color: green">${userContext.localeMap['retail_store_member_coupon']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store_member_coupon.id']}</span> ${retailStoreMemberCoupon.id}</li>
<li><span>${userContext.localeMap['retail_store_member_coupon.name']}</span> ${retailStoreMemberCoupon.name}</li>
<li><span>${userContext.localeMap['retail_store_member_coupon.number']}</span> ${retailStoreMemberCoupon.number}</li>
<li><span>${userContext.localeMap['retail_store_member_coupon.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStoreMemberCoupon.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


