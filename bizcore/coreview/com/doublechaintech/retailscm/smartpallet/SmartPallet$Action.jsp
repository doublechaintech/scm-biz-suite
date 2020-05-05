
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty smartPallet}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SmartPallet" style="color: green">${userContext.localeMap['smart_pallet']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['smart_pallet.id']}</span> ${smartPallet.id}</li>
<li><span>${userContext.localeMap['smart_pallet.location']}</span> ${smartPallet.location}</li>
<li><span>${userContext.localeMap['smart_pallet.contact_number']}</span> ${smartPallet.contactNumber}</li>
<li><span>${userContext.localeMap['smart_pallet.total_area']}</span> ${smartPallet.totalArea}</li>
<li><span>${userContext.localeMap['smart_pallet.latitude']}</span> ${smartPallet.latitude}</li>
<li><span>${userContext.localeMap['smart_pallet.longitude']}</span> ${smartPallet.longitude}</li>
<li><span>${userContext.localeMap['smart_pallet.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${smartPallet.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


