
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty secUserBlocking}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SecUserBlocking" style="color: green">${userContext.localeMap['sec_user_blocking']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['sec_user_blocking.id']}</span> ${secUserBlocking.id}</li>
<li><span>${userContext.localeMap['sec_user_blocking.who']}</span> ${secUserBlocking.who}</li>
<li><span>${userContext.localeMap['sec_user_blocking.block_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${secUserBlocking.blockTime}" /></li>
<li><span>${userContext.localeMap['sec_user_blocking.comments']}</span> ${secUserBlocking.comments}</li>

	
	</ul>
</div>



</c:if>


