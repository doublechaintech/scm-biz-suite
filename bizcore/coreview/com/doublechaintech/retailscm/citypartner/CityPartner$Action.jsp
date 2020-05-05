
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty cityPartner}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A CityPartner" style="color: green">${userContext.localeMap['city_partner']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['city_partner.id']}</span> ${cityPartner.id}</li>
<li><span>${userContext.localeMap['city_partner.name']}</span> ${cityPartner.name}</li>
<li><span>${userContext.localeMap['city_partner.mobile']}</span> ${cityPartner.maskedMobile}</li>
<li><span>${userContext.localeMap['city_partner.description']}</span> ${cityPartner.description}</li>
<li><span>${userContext.localeMap['city_partner.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${cityPartner.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


