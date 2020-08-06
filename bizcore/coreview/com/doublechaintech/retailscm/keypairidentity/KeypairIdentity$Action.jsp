
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty keypairIdentity}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A KeypairIdentity" style="color: green">${userContext.localeMap['keypair_identity']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['keypair_identity.id']}</span> ${keypairIdentity.id}</li>
<li><span>${userContext.localeMap['keypair_identity.public_key']}</span> ${keypairIdentity.publicKey}</li>
<li><span>${userContext.localeMap['keypair_identity.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${keypairIdentity.createTime}" /></li>

	
	</ul>
</div>



</c:if>


