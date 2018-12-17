
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty formField}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A FormField">${userContext.localeMap['form_field']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./formFieldManager/view/${formField.id}/"> ${formField.id}</a></li>
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
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




