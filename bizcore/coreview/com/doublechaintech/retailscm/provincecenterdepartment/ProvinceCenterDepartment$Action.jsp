
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty provinceCenterDepartment}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ProvinceCenterDepartment" style="color: green">${userContext.localeMap['province_center_department']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['province_center_department.id']}</span> ${provinceCenterDepartment.id}</li>
<li><span>${userContext.localeMap['province_center_department.name']}</span> ${provinceCenterDepartment.name}</li>
<li><span>${userContext.localeMap['province_center_department.founded']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${provinceCenterDepartment.founded}" /></li>
<li><span>${userContext.localeMap['province_center_department.manager']}</span> ${provinceCenterDepartment.manager}</li>

	
	</ul>
</div>



</c:if>


