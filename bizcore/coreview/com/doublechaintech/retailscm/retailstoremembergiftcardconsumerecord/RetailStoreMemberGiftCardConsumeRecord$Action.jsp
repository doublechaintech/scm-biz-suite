
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreMemberGiftCardConsumeRecord}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A RetailStoreMemberGiftCardConsumeRecord" style="color: green">${userContext.localeMap['retail_store_member_gift_card_consume_record']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store_member_gift_card_consume_record.id']}</span> ${retailStoreMemberGiftCardConsumeRecord.id}</li>
<li><span>${userContext.localeMap['retail_store_member_gift_card_consume_record.occure_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStoreMemberGiftCardConsumeRecord.occureTime}" /></li>
<li><span>${userContext.localeMap['retail_store_member_gift_card_consume_record.number']}</span> ${retailStoreMemberGiftCardConsumeRecord.number}</li>
<li><span>${userContext.localeMap['retail_store_member_gift_card_consume_record.amount']}</span> <fmt:formatNumber type="currency"  value="${retailStoreMemberGiftCardConsumeRecord.amount}" /></li>

	
	</ul>
</div>



</c:if>


