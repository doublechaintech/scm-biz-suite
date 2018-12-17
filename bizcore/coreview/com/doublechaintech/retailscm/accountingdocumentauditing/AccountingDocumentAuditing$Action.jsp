
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingDocumentAuditing}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A AccountingDocumentAuditing" style="color: green">${userContext.localeMap['accounting_document_auditing']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['accounting_document_auditing.id']}</span> ${accountingDocumentAuditing.id}</li>
<li><span>${userContext.localeMap['accounting_document_auditing.who']}</span> ${accountingDocumentAuditing.who}</li>
<li><span>${userContext.localeMap['accounting_document_auditing.comments']}</span> ${accountingDocumentAuditing.comments}</li>
<li><span>${userContext.localeMap['accounting_document_auditing.make_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountingDocumentAuditing.makeDate}" /></li>

	
	</ul>
</div>



</c:if>


