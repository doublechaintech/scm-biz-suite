
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty offerAcceptance}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A OfferAcceptance" style="color: green">${userContext.localeMap['offer_acceptance']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['offer_acceptance.id']}</span> ${offerAcceptance.id}</li>
<li><span>${userContext.localeMap['offer_acceptance.who']}</span> ${offerAcceptance.who}</li>
<li><span>${userContext.localeMap['offer_acceptance.accept_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${offerAcceptance.acceptTime}" /></li>
<li><span>${userContext.localeMap['offer_acceptance.comments']}</span> ${offerAcceptance.comments}</li>

	
	</ul>
</div>



</c:if>


