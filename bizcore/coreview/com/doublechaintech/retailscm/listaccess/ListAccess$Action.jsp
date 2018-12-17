
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty listAccess}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ListAccess" style="color: green">${userContext.localeMap['list_access']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['list_access.id']}</span> ${listAccess.id}</li>
<li><span>${userContext.localeMap['list_access.name']}</span> ${listAccess.name}</li>
<li><span>${userContext.localeMap['list_access.internal_name']}</span> ${listAccess.internalName}</li>
<li><span>${userContext.localeMap['list_access.read_permission']}</span> ${listAccess.readPermission}</li>
<li><span>${userContext.localeMap['list_access.create_permission']}</span> ${listAccess.createPermission}</li>
<li><span>${userContext.localeMap['list_access.delete_permission']}</span> ${listAccess.deletePermission}</li>
<li><span>${userContext.localeMap['list_access.update_permission']}</span> ${listAccess.updatePermission}</li>
<li><span>${userContext.localeMap['list_access.execution_permission']}</span> ${listAccess.executionPermission}</li>

	
	</ul>
</div>



</c:if>


