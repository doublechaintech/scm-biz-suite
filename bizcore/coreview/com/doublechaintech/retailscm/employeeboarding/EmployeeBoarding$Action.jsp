
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeBoarding}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A EmployeeBoarding" style="color: green">${userContext.localeMap['employee_boarding']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['employee_boarding.id']}</span> ${employeeBoarding.id}</li>
<li><span>${userContext.localeMap['employee_boarding.who']}</span> ${employeeBoarding.who}</li>
<li><span>${userContext.localeMap['employee_boarding.employ_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeBoarding.employTime}" /></li>
<li><span>${userContext.localeMap['employee_boarding.comments']}</span> ${employeeBoarding.comments}</li>

	
	</ul>
</div>



</c:if>


