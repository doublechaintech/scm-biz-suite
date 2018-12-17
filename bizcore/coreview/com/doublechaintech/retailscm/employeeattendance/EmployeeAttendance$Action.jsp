
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeAttendance}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A EmployeeAttendance" style="color: green">${userContext.localeMap['employee_attendance']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['employee_attendance.id']}</span> ${employeeAttendance.id}</li>
<li><span>${userContext.localeMap['employee_attendance.enter_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeAttendance.enterTime}" /></li>
<li><span>${userContext.localeMap['employee_attendance.leave_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeAttendance.leaveTime}" /></li>
<li><span>${userContext.localeMap['employee_attendance.duration_hours']}</span> ${employeeAttendance.durationHours}</li>
<li><span>${userContext.localeMap['employee_attendance.remark']}</span> ${employeeAttendance.remark}</li>

	
	</ul>
</div>



</c:if>


