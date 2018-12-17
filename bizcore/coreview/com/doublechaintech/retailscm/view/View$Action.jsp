
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty view}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A View" style="color: green">${userContext.localeMap['view']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['view.id']}</span> ${view.id}</li>
<li><span>${userContext.localeMap['view.who']}</span> ${view.who}</li>
<li><span>${userContext.localeMap['view.assessment']}</span> ${view.assessment}</li>
<li><span>${userContext.localeMap['view.interview_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${view.interviewTime}" /></li>

	
	</ul>
</div>



</c:if>


