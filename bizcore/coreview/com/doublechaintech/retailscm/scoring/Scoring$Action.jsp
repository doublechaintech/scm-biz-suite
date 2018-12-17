
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty scoring}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Scoring" style="color: green">${userContext.localeMap['scoring']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['scoring.id']}</span> ${scoring.id}</li>
<li><span>${userContext.localeMap['scoring.scored_by']}</span> ${scoring.scoredBy}</li>
<li><span>${userContext.localeMap['scoring.score']}</span> ${scoring.score}</li>
<li><span>${userContext.localeMap['scoring.comment']}</span> ${scoring.comment}</li>

	
	</ul>
</div>



</c:if>


