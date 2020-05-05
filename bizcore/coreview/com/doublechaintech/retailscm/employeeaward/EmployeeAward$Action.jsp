
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeAward}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A EmployeeAward" style="color: green">${userContext.localeMap['employee_award']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['employee_award.id']}</span> ${employeeAward.id}</li>
<li><span>${userContext.localeMap['employee_award.complete_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeAward.completeTime}" /></li>
<li><span>${userContext.localeMap['employee_award.type']}</span> ${employeeAward.type}</li>
<li><span>${userContext.localeMap['employee_award.remark']}</span> ${employeeAward.remark}</li>

	
	</ul>
</div>



</c:if>


