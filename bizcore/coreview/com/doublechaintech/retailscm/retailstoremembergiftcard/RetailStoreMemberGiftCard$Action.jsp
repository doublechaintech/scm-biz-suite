
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreMemberGiftCard}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A RetailStoreMemberGiftCard" style="color: green">${userContext.localeMap['retail_store_member_gift_card']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store_member_gift_card.id']}</span> ${retailStoreMemberGiftCard.id}</li>
<li><span>${userContext.localeMap['retail_store_member_gift_card.name']}</span> ${retailStoreMemberGiftCard.name}</li>
<li><span>${userContext.localeMap['retail_store_member_gift_card.number']}</span> ${retailStoreMemberGiftCard.number}</li>
<li><span>${userContext.localeMap['retail_store_member_gift_card.remain']}</span> <fmt:formatNumber type="currency"  value="${retailStoreMemberGiftCard.remain}" /></li>

	
	</ul>
</div>



</c:if>


