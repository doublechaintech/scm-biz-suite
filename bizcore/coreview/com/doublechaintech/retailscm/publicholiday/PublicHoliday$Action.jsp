
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty publicHoliday}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A PublicHoliday" style="color: green">${userContext.localeMap['public_holiday']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['public_holiday.id']}</span> ${publicHoliday.id}</li>
<li><span>${userContext.localeMap['public_holiday.code']}</span> ${publicHoliday.code}</li>
<li><span>${userContext.localeMap['public_holiday.name']}</span> ${publicHoliday.name}</li>
<li><span>${userContext.localeMap['public_holiday.description']}</span> ${publicHoliday.description}</li>

	
	</ul>
</div>



</c:if>


