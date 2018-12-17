
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty originalVoucherConfirmation}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A OriginalVoucherConfirmation" style="color: green">${userContext.localeMap['original_voucher_confirmation']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['original_voucher_confirmation.id']}</span> ${originalVoucherConfirmation.id}</li>
<li><span>${userContext.localeMap['original_voucher_confirmation.who']}</span> ${originalVoucherConfirmation.who}</li>
<li><span>${userContext.localeMap['original_voucher_confirmation.comments']}</span> ${originalVoucherConfirmation.comments}</li>
<li><span>${userContext.localeMap['original_voucher_confirmation.make_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${originalVoucherConfirmation.makeDate}" /></li>

	
	</ul>
</div>



</c:if>


