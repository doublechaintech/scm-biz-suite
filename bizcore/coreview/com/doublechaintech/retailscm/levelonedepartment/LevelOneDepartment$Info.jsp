
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty levelOneDepartment}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A LevelOneDepartment">${userContext.localeMap['level_one_department']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./levelOneDepartmentManager/view/${levelOneDepartment.id}/"> ${levelOneDepartment.id}</a></li>
<li><span>${userContext.localeMap['level_one_department.name']}</span> ${levelOneDepartment.name}</li>
<li><span>${userContext.localeMap['level_one_department.description']}</span> ${levelOneDepartment.description}</li>
<li><span>${userContext.localeMap['level_one_department.manager']}</span> ${levelOneDepartment.manager}</li>
<li><span>${userContext.localeMap['level_one_department.founded']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${levelOneDepartment.founded}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




