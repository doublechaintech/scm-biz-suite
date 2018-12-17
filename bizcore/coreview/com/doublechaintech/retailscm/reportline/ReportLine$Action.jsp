
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty reportLine}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ReportLine" style="color: green">${userContext.localeMap['report_line']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['report_line.id']}</span> ${reportLine.id}</li>
<li><span>${userContext.localeMap['report_line.name']}</span> ${reportLine.name}</li>
<li><span>${userContext.localeMap['report_line.january']}</span> <fmt:formatNumber type="currency"  value="${reportLine.january}" /></li>
<li><span>${userContext.localeMap['report_line.february']}</span> <fmt:formatNumber type="currency"  value="${reportLine.february}" /></li>
<li><span>${userContext.localeMap['report_line.march']}</span> <fmt:formatNumber type="currency"  value="${reportLine.march}" /></li>
<li><span>${userContext.localeMap['report_line.april']}</span> <fmt:formatNumber type="currency"  value="${reportLine.april}" /></li>
<li><span>${userContext.localeMap['report_line.may']}</span> <fmt:formatNumber type="currency"  value="${reportLine.may}" /></li>
<li><span>${userContext.localeMap['report_line.june']}</span> <fmt:formatNumber type="currency"  value="${reportLine.june}" /></li>
<li><span>${userContext.localeMap['report_line.july']}</span> <fmt:formatNumber type="currency"  value="${reportLine.july}" /></li>
<li><span>${userContext.localeMap['report_line.august']}</span> <fmt:formatNumber type="currency"  value="${reportLine.august}" /></li>
<li><span>${userContext.localeMap['report_line.september']}</span> <fmt:formatNumber type="currency"  value="${reportLine.september}" /></li>
<li><span>${userContext.localeMap['report_line.october']}</span> <fmt:formatNumber type="currency"  value="${reportLine.october}" /></li>
<li><span>${userContext.localeMap['report_line.november']}</span> <fmt:formatNumber type="currency"  value="${reportLine.november}" /></li>
<li><span>${userContext.localeMap['report_line.december']}</span> <fmt:formatNumber type="currency"  value="${reportLine.december}" /></li>

	
	</ul>
</div>



</c:if>


