
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty section}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Section" style="color: green">${userContext.localeMap['section']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['section.id']}</span> ${section.id}</li>
<li><span>${userContext.localeMap['section.title']}</span> ${section.title}</li>
<li><span>${userContext.localeMap['section.brief']}</span> ${section.brief}</li>
<li><span>${userContext.localeMap['section.icon']}</span> ${section.icon}</li>
<li><span>${userContext.localeMap['section.display_order']}</span> ${section.displayOrder}</li>
<li><span>${userContext.localeMap['section.view_group']}</span> ${section.viewGroup}</li>
<li><span>${userContext.localeMap['section.link_to_url']}</span> ${section.linkToUrl}</li>

	
	</ul>
</div>



</c:if>


