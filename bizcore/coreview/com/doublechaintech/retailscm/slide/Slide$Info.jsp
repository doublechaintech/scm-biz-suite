
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty slide}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Slide">${userContext.localeMap['slide']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./slideManager/view/${slide.id}/"> ${slide.id}</a></li>
<li><span>${userContext.localeMap['slide.name']}</span> ${slide.name}</li>
<li><span>${userContext.localeMap['slide.display_order']}</span> ${slide.displayOrder}</li>
<li><span>${userContext.localeMap['slide.image_url']}</span> ${slide.imageUrl}</li>
<li><span>${userContext.localeMap['slide.video_url']}</span> ${slide.videoUrl}</li>
<li><span>${userContext.localeMap['slide.link_to_url']}</span> ${slide.linkToUrl}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




