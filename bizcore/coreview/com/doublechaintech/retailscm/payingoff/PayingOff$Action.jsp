
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty payingOff}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A PayingOff" style="color: green">${userContext.localeMap['paying_off']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['paying_off.id']}</span> ${payingOff.id}</li>
<li><span>${userContext.localeMap['paying_off.who']}</span> ${payingOff.who}</li>
<li><span>${userContext.localeMap['paying_off.paid_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${payingOff.paidTime}" /></li>
<li><span>${userContext.localeMap['paying_off.amount']}</span> <fmt:formatNumber type="currency"  value="${payingOff.amount}" /></li>

	
	</ul>
</div>



</c:if>


