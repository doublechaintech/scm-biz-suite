
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty professionInterview}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ProfessionInterview" style="color: green">${userContext.localeMap['profession_interview']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['profession_interview.id']}</span> ${professionInterview.id}</li>
<li><span>${userContext.localeMap['profession_interview.who']}</span> ${professionInterview.who}</li>
<li><span>${userContext.localeMap['profession_interview.interview_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${professionInterview.interviewTime}" /></li>
<li><span>${userContext.localeMap['profession_interview.comments']}</span> ${professionInterview.comments}</li>

	
	</ul>
</div>



</c:if>


