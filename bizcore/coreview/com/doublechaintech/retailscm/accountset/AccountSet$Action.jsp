
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountSet}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A AccountSet" style="color: green">${userContext.localeMap['account_set']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['account_set.id']}</span> ${accountSet.id}</li>
<li><span>${userContext.localeMap['account_set.name']}</span> ${accountSet.name}</li>
<li><span>${userContext.localeMap['account_set.year_set']}</span> ${accountSet.yearSet}</li>
<li><span>${userContext.localeMap['account_set.effective_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountSet.effectiveDate}" /></li>
<li><span>${userContext.localeMap['account_set.accounting_system']}</span> ${accountSet.accountingSystem}</li>
<li><span>${userContext.localeMap['account_set.domestic_currency_code']}</span> ${accountSet.domesticCurrencyCode}</li>
<li><span>${userContext.localeMap['account_set.domestic_currency_name']}</span> ${accountSet.domesticCurrencyName}</li>
<li><span>${userContext.localeMap['account_set.opening_bank']}</span> ${accountSet.openingBank}</li>
<li><span>${userContext.localeMap['account_set.account_number']}</span> ${accountSet.accountNumber}</li>
<li><span>${userContext.localeMap['account_set.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountSet.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


