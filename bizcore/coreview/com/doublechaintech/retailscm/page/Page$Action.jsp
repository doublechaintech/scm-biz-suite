
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty page}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Page" style="color: green">${userContext.localeMap['page']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['page.id']}</span> ${page.id}</li>
<li><span>${userContext.localeMap['page.page_title']}</span> ${page.pageTitle}</li>
<li><span>${userContext.localeMap['page.link_to_url']}</span> ${page.linkToUrl}</li>
<li><span>${userContext.localeMap['page.display_order']}</span> ${page.displayOrder}</li>

	
	</ul>
</div>



</c:if>


