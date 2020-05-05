
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty keypairIdentify}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A KeypairIdentify" style="color: green">${userContext.localeMap['keypair_identify']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['keypair_identify.id']}</span> ${keypairIdentify.id}</li>
<li><span>${userContext.localeMap['keypair_identify.public_key']}</span> ${keypairIdentify.publicKey}</li>
<li><span>${userContext.localeMap['keypair_identify.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${keypairIdentify.createTime}" /></li>

	
	</ul>
</div>



</c:if>


