
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty formAction}">
<div class="col-xs-12 col-md-12 section">
	<b title="A FormAction"> 
		${userContext.localeMap['form_action']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		
		
	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'main' eq action.actionGroup}">
		
		
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		
		
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['form_action.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['form_action.label']}</span>
<span >${result.label}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['form_action.locale_key']}</span>
<span >${result.localeKey}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['form_action.action_key']}</span>
<span >${result.actionKey}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['form_action.level']}</span>
<span >${result.level}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['form_action.url']}</span>
<span >${result.url}</span>
</div>

	</div>
	
</div>

</c:if>







<c:if test="false">
<div class="col-xs-12 col-md-12">
	<b title="A Order">Summary</b>
	<hr/>
	<div>
		<div class="col-xs-12 col-md-3 summary-section">
		<span class="summary-lable">Order ID</span> <span ></span>
		</div>
		<div class="col-xs-12 col-md-3 summary-section">
		<span class="summary-lable">Order Title</span> <span ></span>
		</div>
		<div class="col-xs-12 col-md-3 summary-section">
		<span class="summary-lable">Order Type</span> <span ></span>
		</div>
		<div class="col-xs-12 col-md-3 summary-section">
		<span class="summary-lable">Order Amount</span> <span ></span>
		</div>
	</div>
	<hr/>
</div>



</c:if>










