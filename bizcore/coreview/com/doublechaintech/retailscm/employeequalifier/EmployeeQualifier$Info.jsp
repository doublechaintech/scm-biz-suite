
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeQualifier}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A EmployeeQualifier">${userContext.localeMap['employee_qualifier']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./employeeQualifierManager/view/${employeeQualifier.id}/"> ${employeeQualifier.id}</a></li>
<li><span>${userContext.localeMap['employee_qualifier.qualified_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employeeQualifier.qualifiedTime}" /></li>
<li><span>${userContext.localeMap['employee_qualifier.type']}</span> ${employeeQualifier.type}</li>
<li><span>${userContext.localeMap['employee_qualifier.level']}</span> ${employeeQualifier.level}</li>
<li><span>${userContext.localeMap['employee_qualifier.remark']}</span> ${employeeQualifier.remark}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




