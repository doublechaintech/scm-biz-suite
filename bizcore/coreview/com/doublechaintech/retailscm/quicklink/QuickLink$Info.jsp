
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty quickLink}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A QuickLink">${userContext.localeMap['quick_link']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./quickLinkManager/view/${quickLink.id}/"> ${quickLink.id}</a></li>
<li><span>${userContext.localeMap['quick_link.name']}</span> ${quickLink.name}</li>
<li><span>${userContext.localeMap['quick_link.icon']}</span> ${quickLink.icon}</li>
<li><span>${userContext.localeMap['quick_link.image_path']}</span> ${quickLink.imagePath}</li>
<li><span>${userContext.localeMap['quick_link.link_target']}</span> ${quickLink.linkTarget}</li>
<li><span>${userContext.localeMap['quick_link.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${quickLink.createTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




