
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty transportTaskTrack}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A TransportTaskTrack" style="color: green">${userContext.localeMap['transport_task_track']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['transport_task_track.id']}</span> ${transportTaskTrack.id}</li>
<li><span>${userContext.localeMap['transport_task_track.track_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${transportTaskTrack.trackTime}" /></li>
<li><span>${userContext.localeMap['transport_task_track.latitude']}</span> ${transportTaskTrack.latitude}</li>
<li><span>${userContext.localeMap['transport_task_track.longitude']}</span> ${transportTaskTrack.longitude}</li>

	
	</ul>
</div>



</c:if>


