
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty quickLink}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A QuickLink" style="color: green">${userContext.localeMap['quick_link']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['quick_link.id']}</span> ${quickLink.id}</li>
<li><span>${userContext.localeMap['quick_link.name']}</span> ${quickLink.name}</li>
<li><span>${userContext.localeMap['quick_link.icon']}</span> ${quickLink.icon}</li>
<li><span>${userContext.localeMap['quick_link.image_path']}</span> ${quickLink.imagePath}</li>
<li><span>${userContext.localeMap['quick_link.link_target']}</span> ${quickLink.linkTarget}</li>
<li><span>${userContext.localeMap['quick_link.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${quickLink.createTime}" /></li>

	
	</ul>
</div>



</c:if>


