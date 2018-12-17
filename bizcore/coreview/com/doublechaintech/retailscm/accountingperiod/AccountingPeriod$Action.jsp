
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingPeriod}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A AccountingPeriod" style="color: green">${userContext.localeMap['accounting_period']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['accounting_period.id']}</span> ${accountingPeriod.id}</li>
<li><span>${userContext.localeMap['accounting_period.name']}</span> ${accountingPeriod.name}</li>
<li><span>${userContext.localeMap['accounting_period.start_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountingPeriod.startDate}" /></li>
<li><span>${userContext.localeMap['accounting_period.end_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountingPeriod.endDate}" /></li>

	
	</ul>
</div>



</c:if>


