
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty section}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Section">${userContext.localeMap['section']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./sectionManager/view/${section.id}/"> ${section.id}</a></li>
<li><span>${userContext.localeMap['section.title']}</span> ${section.title}</li>
<li><span>${userContext.localeMap['section.brief']}</span> ${section.brief}</li>
<li><span>${userContext.localeMap['section.icon']}</span> ${section.icon}</li>
<li><span>${userContext.localeMap['section.display_order']}</span> ${section.displayOrder}</li>
<li><span>${userContext.localeMap['section.view_group']}</span> ${section.viewGroup}</li>
<li><span>${userContext.localeMap['section.link_to_url']}</span> ${section.linkToUrl}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




