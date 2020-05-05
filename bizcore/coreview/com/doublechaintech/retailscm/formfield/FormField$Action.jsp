
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty formField}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A FormField" style="color: green">${userContext.localeMap['form_field']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['form_field.id']}</span> ${formField.id}</li>
<li><span>${userContext.localeMap['form_field.label']}</span> ${formField.label}</li>
<li><span>${userContext.localeMap['form_field.locale_key']}</span> ${formField.localeKey}</li>
<li><span>${userContext.localeMap['form_field.parameter_name']}</span> ${formField.parameterName}</li>
<li><span>${userContext.localeMap['form_field.type']}</span> ${formField.type}</li>
<li><span>${userContext.localeMap['form_field.placeholder']}</span> ${formField.placeholder}</li>
<li><span>${userContext.localeMap['form_field.default_value']}</span> ${formField.defaultValue}</li>
<li><span>${userContext.localeMap['form_field.description']}</span> ${formField.description}</li>
<li><span>${userContext.localeMap['form_field.field_group']}</span> ${formField.fieldGroup}</li>
<li><span>${userContext.localeMap['form_field.minimum_value']}</span> ${formField.minimumValue}</li>
<li><span>${userContext.localeMap['form_field.maximum_value']}</span> ${formField.maximumValue}</li>
<li><span>${userContext.localeMap['form_field.required']}</span> ${formField.required}</li>
<li><span>${userContext.localeMap['form_field.disabled']}</span> ${formField.disabled}</li>
<li><span>${userContext.localeMap['form_field.custom_rendering']}</span> ${formField.customRendering}</li>
<li><span>${userContext.localeMap['form_field.candidate_values']}</span> ${formField.candidateValues}</li>
<li><span>${userContext.localeMap['form_field.suggest_values']}</span> ${formField.suggestValues}</li>

	
	</ul>
</div>



</c:if>


