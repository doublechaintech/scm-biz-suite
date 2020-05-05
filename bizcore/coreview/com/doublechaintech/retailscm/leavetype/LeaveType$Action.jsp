
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty leaveType}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A LeaveType" style="color: green">${userContext.localeMap['leave_type']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['leave_type.id']}</span> ${leaveType.id}</li>
<li><span>${userContext.localeMap['leave_type.code']}</span> ${leaveType.code}</li>
<li><span>${userContext.localeMap['leave_type.description']}</span> ${leaveType.description}</li>
<li><span>${userContext.localeMap['leave_type.detail_description']}</span> ${leaveType.detailDescription}</li>

	
	</ul>
</div>



</c:if>


