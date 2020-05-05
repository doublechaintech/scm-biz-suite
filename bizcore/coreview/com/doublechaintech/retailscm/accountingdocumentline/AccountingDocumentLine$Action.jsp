
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingDocumentLine}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A AccountingDocumentLine" style="color: green">${userContext.localeMap['accounting_document_line']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['accounting_document_line.id']}</span> ${accountingDocumentLine.id}</li>
<li><span>${userContext.localeMap['accounting_document_line.name']}</span> ${accountingDocumentLine.name}</li>
<li><span>${userContext.localeMap['accounting_document_line.code']}</span> ${accountingDocumentLine.code}</li>
<li><span>${userContext.localeMap['accounting_document_line.direct']}</span> ${accountingDocumentLine.direct}</li>
<li><span>${userContext.localeMap['accounting_document_line.amount']}</span> <fmt:formatNumber type="currency"  value="${accountingDocumentLine.amount}" /></li>

	
	</ul>
</div>



</c:if>


