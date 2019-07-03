
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeAttendance}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A EmployeeAttendance">${userContext.localeMap['employee_attendance']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./employeeAttendanceManager/view/${employeeAttendance.id}/"> ${employeeAttendance.id}</a></li>
<li><span>${userContext.localeMap['employee_attendance.enter_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeAttendance.enterTime}" /></li>
<li><span>${userContext.localeMap['employee_attendance.leave_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeAttendance.leaveTime}" /></li>
<li><span>${userContext.localeMap['employee_attendance.duration_hours']}</span> ${employeeAttendance.durationHours}</li>
<li><span>${userContext.localeMap['employee_attendance.remark']}</span> ${employeeAttendance.remark}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




