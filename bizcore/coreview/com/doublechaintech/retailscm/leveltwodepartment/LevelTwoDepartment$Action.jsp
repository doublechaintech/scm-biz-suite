
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty levelTwoDepartment}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A LevelTwoDepartment" style="color: green">${userContext.localeMap['level_two_department']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['level_two_department.id']}</span> ${levelTwoDepartment.id}</li>
<li><span>${userContext.localeMap['level_two_department.name']}</span> ${levelTwoDepartment.name}</li>
<li><span>${userContext.localeMap['level_two_department.description']}</span> ${levelTwoDepartment.description}</li>
<li><span>${userContext.localeMap['level_two_department.founded']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${levelTwoDepartment.founded}" /></li>

	
	</ul>
</div>



</c:if>


