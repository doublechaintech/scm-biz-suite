
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty candidateElement}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A CandidateElement" style="color: green">${userContext.localeMap['candidate_element']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['candidate_element.id']}</span> ${candidateElement.id}</li>
<li><span>${userContext.localeMap['candidate_element.name']}</span> ${candidateElement.name}</li>
<li><span>${userContext.localeMap['candidate_element.type']}</span> ${candidateElement.type}</li>
<li><span>${userContext.localeMap['candidate_element.image']}</span> ${candidateElement.image}</li>

	
	</ul>
</div>



</c:if>


