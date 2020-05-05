
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeSalarySheet}">
<div class="col-xs-12 col-md-12 section">
	<b title="A EmployeeSalarySheet"> 
		${userContext.localeMap['employee_salary_sheet']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
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
<span class="summary-label">${userContext.localeMap['employee_salary_sheet.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['employee_salary_sheet.base_salary']}</span>
<span ><fmt:formatNumber type="currency"  value="${result.baseSalary}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['employee_salary_sheet.bonus']}</span>
<span ><fmt:formatNumber type="currency"  value="${result.bonus}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['employee_salary_sheet.reward']}</span>
<span ><fmt:formatNumber type="currency"  value="${result.reward}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['employee_salary_sheet.personal_tax']}</span>
<span ><fmt:formatNumber type="currency"  value="${result.personalTax}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['employee_salary_sheet.social_security']}</span>
<span ><fmt:formatNumber type="currency"  value="${result.socialSecurity}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['employee_salary_sheet.housing_found']}</span>
<span ><fmt:formatNumber type="currency"  value="${result.housingFound}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['employee_salary_sheet.job_insurance']}</span>
<span ><fmt:formatNumber type="currency"  value="${result.jobInsurance}" /></span>
</div>

	</div>
	
</div>

</c:if>




