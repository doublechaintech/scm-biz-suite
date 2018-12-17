
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty goodsPackaging}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A GoodsPackaging" style="color: green">${userContext.localeMap['goods_packaging']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['goods_packaging.id']}</span> ${goodsPackaging.id}</li>
<li><span>${userContext.localeMap['goods_packaging.package_name']}</span> ${goodsPackaging.packageName}</li>
<li><span>${userContext.localeMap['goods_packaging.rfid']}</span> ${goodsPackaging.rfid}</li>
<li><span>${userContext.localeMap['goods_packaging.package_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${goodsPackaging.packageTime}" /></li>
<li><span>${userContext.localeMap['goods_packaging.description']}</span> ${goodsPackaging.description}</li>

	
	</ul>
</div>



</c:if>


