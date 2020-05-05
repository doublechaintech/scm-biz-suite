
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeEducation}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A EmployeeEducation" style="color: green">${userContext.localeMap['employee_education']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['employee_education.id']}</span> ${employeeEducation.id}</li>
<li><span>${userContext.localeMap['employee_education.complete_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeEducation.completeTime}" /></li>
<li><span>${userContext.localeMap['employee_education.type']}</span> ${employeeEducation.type}</li>
<li><span>${userContext.localeMap['employee_education.remark']}</span> ${employeeEducation.remark}</li>

	
	</ul>
</div>



</c:if>


