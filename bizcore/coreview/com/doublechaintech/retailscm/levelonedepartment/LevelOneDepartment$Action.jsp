
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty levelOneDepartment}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A LevelOneDepartment" style="color: green">${userContext.localeMap['level_one_department']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['level_one_department.id']}</span> ${levelOneDepartment.id}</li>
<li><span>${userContext.localeMap['level_one_department.name']}</span> ${levelOneDepartment.name}</li>
<li><span>${userContext.localeMap['level_one_department.description']}</span> ${levelOneDepartment.description}</li>
<li><span>${userContext.localeMap['level_one_department.manager']}</span> ${levelOneDepartment.manager}</li>
<li><span>${userContext.localeMap['level_one_department.founded']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${levelOneDepartment.founded}" /></li>

	
	</ul>
</div>



</c:if>


