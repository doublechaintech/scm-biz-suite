
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty interviewType}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A InterviewType" style="color: green">${userContext.localeMap['interview_type']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['interview_type.id']}</span> ${interviewType.id}</li>
<li><span>${userContext.localeMap['interview_type.code']}</span> ${interviewType.code}</li>
<li><span>${userContext.localeMap['interview_type.description']}</span> ${interviewType.description}</li>
<li><span>${userContext.localeMap['interview_type.detail_description']}</span> ${interviewType.detailDescription}</li>

	
	</ul>
</div>



</c:if>


