
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty page}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Page">${userContext.localeMap['page']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./pageManager/view/${page.id}/"> ${page.id}</a></li>
<li><span>${userContext.localeMap['page.page_title']}</span> ${page.pageTitle}</li>
<li><span>${userContext.localeMap['page.link_to_url']}</span> ${page.linkToUrl}</li>
<li><span>${userContext.localeMap['page.display_order']}</span> ${page.displayOrder}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




