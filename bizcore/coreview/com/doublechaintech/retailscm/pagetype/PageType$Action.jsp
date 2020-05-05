
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty pageType}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A PageType" style="color: green">${userContext.localeMap['page_type']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['page_type.id']}</span> ${pageType.id}</li>
<li><span>${userContext.localeMap['page_type.name']}</span> ${pageType.name}</li>
<li><span>${userContext.localeMap['page_type.code']}</span> ${pageType.code}</li>
<li><span>${userContext.localeMap['page_type.footer_tab']}</span> ${pageType.footerTab}</li>

	
	</ul>
</div>



</c:if>


