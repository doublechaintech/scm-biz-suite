
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty salaryGrade}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SalaryGrade" style="color: green">${userContext.localeMap['salary_grade']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['salary_grade.id']}</span> ${salaryGrade.id}</li>
<li><span>${userContext.localeMap['salary_grade.code']}</span> ${salaryGrade.code}</li>
<li><span>${userContext.localeMap['salary_grade.name']}</span> ${salaryGrade.name}</li>
<li><span>${userContext.localeMap['salary_grade.detail_description']}</span> ${salaryGrade.detailDescription}</li>

	
	</ul>
</div>



</c:if>


