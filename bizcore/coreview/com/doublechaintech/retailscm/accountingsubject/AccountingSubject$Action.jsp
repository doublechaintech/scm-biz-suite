
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingSubject}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A AccountingSubject" style="color: green">${userContext.localeMap['accounting_subject']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['accounting_subject.id']}</span> ${accountingSubject.id}</li>
<li><span>${userContext.localeMap['accounting_subject.accounting_subject_code']}</span> ${accountingSubject.accountingSubjectCode}</li>
<li><span>${userContext.localeMap['accounting_subject.accounting_subject_name']}</span> ${accountingSubject.accountingSubjectName}</li>
<li><span>${userContext.localeMap['accounting_subject.accounting_subject_class_code']}</span> ${accountingSubject.accountingSubjectClassCode}</li>
<li><span>${userContext.localeMap['accounting_subject.accounting_subject_class_name']}</span> ${accountingSubject.accountingSubjectClassName}</li>

	
	</ul>
</div>



</c:if>


