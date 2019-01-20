
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty storageSpace}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A StorageSpace" style="color: green">${userContext.localeMap['storage_space']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['storage_space.id']}</span> ${storageSpace.id}</li>
<li><span>${userContext.localeMap['storage_space.location']}</span> ${storageSpace.location}</li>
<li><span>${userContext.localeMap['storage_space.contact_number']}</span> ${storageSpace.contactNumber}</li>
<li><span>${userContext.localeMap['storage_space.total_area']}</span> ${storageSpace.totalArea}</li>
<li><span>${userContext.localeMap['storage_space.latitude']}</span> ${storageSpace.latitude}</li>
<li><span>${userContext.localeMap['storage_space.longitude']}</span> ${storageSpace.longitude}</li>
<li><span>${userContext.localeMap['storage_space.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${storageSpace.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


