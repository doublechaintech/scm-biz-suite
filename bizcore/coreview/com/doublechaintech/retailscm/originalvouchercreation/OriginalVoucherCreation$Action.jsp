
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty originalVoucherCreation}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A OriginalVoucherCreation" style="color: green">${userContext.localeMap['original_voucher_creation']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['original_voucher_creation.id']}</span> ${originalVoucherCreation.id}</li>
<li><span>${userContext.localeMap['original_voucher_creation.who']}</span> ${originalVoucherCreation.who}</li>
<li><span>${userContext.localeMap['original_voucher_creation.comments']}</span> ${originalVoucherCreation.comments}</li>
<li><span>${userContext.localeMap['original_voucher_creation.make_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${originalVoucherCreation.makeDate}" /></li>

	
	</ul>
</div>



</c:if>


