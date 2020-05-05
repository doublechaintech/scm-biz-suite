
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingDocumentPosting}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A AccountingDocumentPosting" style="color: green">${userContext.localeMap['accounting_document_posting']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['accounting_document_posting.id']}</span> ${accountingDocumentPosting.id}</li>
<li><span>${userContext.localeMap['accounting_document_posting.who']}</span> ${accountingDocumentPosting.who}</li>
<li><span>${userContext.localeMap['accounting_document_posting.comments']}</span> ${accountingDocumentPosting.comments}</li>
<li><span>${userContext.localeMap['accounting_document_posting.make_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountingDocumentPosting.makeDate}" /></li>

	
	</ul>
</div>



</c:if>


