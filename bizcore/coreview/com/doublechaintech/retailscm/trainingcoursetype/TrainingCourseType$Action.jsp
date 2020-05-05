
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty trainingCourseType}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A TrainingCourseType" style="color: green">${userContext.localeMap['training_course_type']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['training_course_type.id']}</span> ${trainingCourseType.id}</li>
<li><span>${userContext.localeMap['training_course_type.code']}</span> ${trainingCourseType.code}</li>
<li><span>${userContext.localeMap['training_course_type.name']}</span> ${trainingCourseType.name}</li>
<li><span>${userContext.localeMap['training_course_type.description']}</span> ${trainingCourseType.description}</li>

	
	</ul>
</div>



</c:if>


