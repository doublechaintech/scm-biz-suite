
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty eventAttendance}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A EventAttendance" style="color: green">${userContext.localeMap['event_attendance']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['event_attendance.id']}</span> ${eventAttendance.id}</li>
<li><span>${userContext.localeMap['event_attendance.name']}</span> ${eventAttendance.name}</li>
<li><span>${userContext.localeMap['event_attendance.description']}</span> ${eventAttendance.description}</li>

	
	</ul>
</div>



</c:if>


