
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeWorkExperience}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A EmployeeWorkExperience" style="color: green">${userContext.localeMap['employee_work_experience']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['employee_work_experience.id']}</span> ${employeeWorkExperience.id}</li>
<li><span>${userContext.localeMap['employee_work_experience.start']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeWorkExperience.start}" /></li>
<li><span>${userContext.localeMap['employee_work_experience.end']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeWorkExperience.end}" /></li>
<li><span>${userContext.localeMap['employee_work_experience.company']}</span> ${employeeWorkExperience.company}</li>
<li><span>${userContext.localeMap['employee_work_experience.description']}</span> ${employeeWorkExperience.description}</li>

	
	</ul>
</div>



</c:if>


