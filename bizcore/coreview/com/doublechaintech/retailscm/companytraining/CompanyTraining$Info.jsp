
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty companyTraining}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A CompanyTraining">${userContext.localeMap['company_training']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./companyTrainingManager/view/${companyTraining.id}/"> ${companyTraining.id}</a></li>
<li><span>${userContext.localeMap['company_training.title']}</span> ${companyTraining.title}</li>
<li><span>${userContext.localeMap['company_training.time_start']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${companyTraining.timeStart}" /></li>
<li><span>${userContext.localeMap['company_training.duration_hours']}</span> ${companyTraining.durationHours}</li>
<li><span>${userContext.localeMap['company_training.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${companyTraining.lastUpdateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




