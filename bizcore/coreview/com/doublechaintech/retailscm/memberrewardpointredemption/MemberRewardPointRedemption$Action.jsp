
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty memberRewardPointRedemption}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A MemberRewardPointRedemption" style="color: green">${userContext.localeMap['member_reward_point_redemption']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['member_reward_point_redemption.id']}</span> ${memberRewardPointRedemption.id}</li>
<li><span>${userContext.localeMap['member_reward_point_redemption.name']}</span> ${memberRewardPointRedemption.name}</li>
<li><span>${userContext.localeMap['member_reward_point_redemption.point']}</span> ${memberRewardPointRedemption.point}</li>

	
	</ul>
</div>



</c:if>


