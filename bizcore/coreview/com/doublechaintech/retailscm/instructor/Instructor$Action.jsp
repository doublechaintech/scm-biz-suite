
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty instructor}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Instructor" style="color: green">${userContext.localeMap['instructor']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['instructor.id']}</span> ${instructor.id}</li>
<li><span>${userContext.localeMap['instructor.title']}</span> ${instructor.title}</li>
<li><span>${userContext.localeMap['instructor.family_name']}</span> ${instructor.familyName}</li>
<li><span>${userContext.localeMap['instructor.given_name']}</span> ${instructor.givenName}</li>
<li><span>${userContext.localeMap['instructor.cell_phone']}</span> ${instructor.maskedCellPhone}</li>
<li><span>${userContext.localeMap['instructor.email']}</span> ${instructor.email}</li>
<li><span>${userContext.localeMap['instructor.introduction']}</span> ${instructor.introduction}</li>
<li><span>${userContext.localeMap['instructor.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${instructor.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


