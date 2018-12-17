
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty objectAccess}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A ObjectAccess">${userContext.localeMap['object_access']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./objectAccessManager/view/${objectAccess.id}/"> ${objectAccess.id}</a></li>
<li><span>${userContext.localeMap['object_access.name']}</span> ${objectAccess.name}</li>
<li><span>${userContext.localeMap['object_access.object_type']}</span> ${objectAccess.objectType}</li>
<li><span>${userContext.localeMap['object_access.list1']}</span> ${objectAccess.list1}</li>
<li><span>${userContext.localeMap['object_access.list2']}</span> ${objectAccess.list2}</li>
<li><span>${userContext.localeMap['object_access.list3']}</span> ${objectAccess.list3}</li>
<li><span>${userContext.localeMap['object_access.list4']}</span> ${objectAccess.list4}</li>
<li><span>${userContext.localeMap['object_access.list5']}</span> ${objectAccess.list5}</li>
<li><span>${userContext.localeMap['object_access.list6']}</span> ${objectAccess.list6}</li>
<li><span>${userContext.localeMap['object_access.list7']}</span> ${objectAccess.list7}</li>
<li><span>${userContext.localeMap['object_access.list8']}</span> ${objectAccess.list8}</li>
<li><span>${userContext.localeMap['object_access.list9']}</span> ${objectAccess.list9}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




