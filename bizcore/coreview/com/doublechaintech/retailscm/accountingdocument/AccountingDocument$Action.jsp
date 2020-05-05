
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingDocument}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A AccountingDocument" style="color: green">${userContext.localeMap['accounting_document']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['accounting_document.id']}</span> ${accountingDocument.id}</li>
<li><span>${userContext.localeMap['accounting_document.name']}</span> ${accountingDocument.name}</li>
<li><span>${userContext.localeMap['accounting_document.accounting_document_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountingDocument.accountingDocumentDate}" /></li>

	
	</ul>
</div>



</c:if>


