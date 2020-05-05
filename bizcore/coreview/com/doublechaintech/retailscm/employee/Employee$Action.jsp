
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employee}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Employee" style="color: green">${userContext.localeMap['employee']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['employee.id']}</span> ${employee.id}</li>
<li><span>${userContext.localeMap['employee.title']}</span> ${employee.title}</li>
<li><span>${userContext.localeMap['employee.family_name']}</span> ${employee.familyName}</li>
<li><span>${userContext.localeMap['employee.given_name']}</span> ${employee.givenName}</li>
<li><span>${userContext.localeMap['employee.email']}</span> ${employee.email}</li>
<li><span>${userContext.localeMap['employee.city']}</span> ${employee.city}</li>
<li><span>${userContext.localeMap['employee.address']}</span> ${employee.address}</li>
<li><span>${userContext.localeMap['employee.cell_phone']}</span> ${employee.maskedCellPhone}</li>
<li><span>${userContext.localeMap['employee.salary_account']}</span> ${employee.salaryAccount}</li>
<li><span>${userContext.localeMap['employee.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${employee.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


