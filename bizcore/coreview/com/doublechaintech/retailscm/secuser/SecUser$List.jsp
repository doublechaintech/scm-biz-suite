<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty secUserList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['sec_user']}! 
		 <a href="./${ownerBeanName}Manager/addSecUser/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty secUserList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("secUserList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['sec_user']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addSecUser/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'secUserList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${secUserListName};${secUserListName}CurrentPage=${page.pageNumber};${secUserListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='secUserListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['sec_user.id']}</th>
</c:if>
<c:if test="${param.referName ne 'login'}">
	<th>${userContext.localeMap['sec_user.login']}</th>
</c:if>
<c:if test="${param.referName ne 'mobile'}">
	<th>${userContext.localeMap['sec_user.mobile']}</th>
</c:if>
<c:if test="${param.referName ne 'email'}">
	<th>${userContext.localeMap['sec_user.email']}</th>
</c:if>
<c:if test="${param.referName ne 'pwd'}">
	<th>${userContext.localeMap['sec_user.pwd']}</th>
</c:if>
<c:if test="${param.referName ne 'weixinOpenid'}">
	<th>${userContext.localeMap['sec_user.weixin_openid']}</th>
</c:if>
<c:if test="${param.referName ne 'weixinAppid'}">
	<th>${userContext.localeMap['sec_user.weixin_appid']}</th>
</c:if>
<c:if test="${param.referName ne 'accessToken'}">
	<th>${userContext.localeMap['sec_user.access_token']}</th>
</c:if>
<c:if test="${param.referName ne 'verificationCode'}">
	<th>${userContext.localeMap['sec_user.verification_code']}</th>
</c:if>
<c:if test="${param.referName ne 'verificationCodeExpire'}">
	<th>${userContext.localeMap['sec_user.verification_code_expire']}</th>
</c:if>
<c:if test="${param.referName ne 'lastLoginTime'}">
	<th>${userContext.localeMap['sec_user.last_login_time']}</th>
</c:if>
<c:if test="${param.referName ne 'domain'}">
	<th>${userContext.localeMap['sec_user.domain']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${secUserList}">
				<tr currentVersion='${item.version}' id="secUser-${item.id}" ><td><a class="link-action-removed" href="./secUserManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'login'}">	<td contenteditable='true' class='edit-value'  propertyToChange='login' storedCellValue='${item.login}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.login}</td>
</c:if><c:if test="${param.referName ne 'mobile'}">	<td contenteditable='true' class='edit-value'  propertyToChange='mobile' storedCellValue='${item.maskedMobile}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.maskedMobile}</td>
</c:if><c:if test="${param.referName ne 'email'}">	<td contenteditable='true' class='edit-value'  propertyToChange='email' storedCellValue='${item.email}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.email}</td>
</c:if><c:if test="${param.referName ne 'pwd'}">	<td contenteditable='true' class='edit-value'  propertyToChange='pwd' storedCellValue='${item.maskedPwd}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.maskedPwd}</td>
</c:if><c:if test="${param.referName ne 'weixinOpenid'}">	<td contenteditable='true' class='edit-value'  propertyToChange='weixinOpenid' storedCellValue='${item.weixinOpenid}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.weixinOpenid}</td>
</c:if><c:if test="${param.referName ne 'weixinAppid'}">	<td contenteditable='true' class='edit-value'  propertyToChange='weixinAppid' storedCellValue='${item.weixinAppid}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.weixinAppid}</td>
</c:if><c:if test="${param.referName ne 'accessToken'}">	<td contenteditable='true' class='edit-value'  propertyToChange='accessToken' storedCellValue='${item.accessToken}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.accessToken}</td>
</c:if><c:if test="${param.referName ne 'verificationCode'}">	<td contenteditable='true' class='edit-value'  propertyToChange='verificationCode' storedCellValue='${item.verificationCode}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.verificationCode}</td>
</c:if><c:if test="${param.referName ne 'verificationCodeExpire'}">	<td contenteditable='true' class='edit-value'  propertyToChange='verificationCodeExpire' storedCellValue='${item.verificationCodeExpire}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.verificationCodeExpire}" /></td>
</c:if><c:if test="${param.referName ne 'lastLoginTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastLoginTime' storedCellValue='${item.lastLoginTime}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastLoginTime}" /></td>
</c:if><c:if test="${param.referName ne 'domain'}">
	<td class="select_candidate_td"
			data-candidate-method="./secUserManager/requestCandidateDomain/${ownerBeanName}/${item.id}/"
			data-switch-method="./secUserManager/transferToAnotherDomain/${item.id}/"
			data-link-template="./userDomainManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.domain}">
			<a href='./userDomainManager/view/${item.domain.id}/'>${item.domain.displayName}</a>
			</c:if>
			<c:if test="${empty  item.domain}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>

				<td>

				<a href='#${ownerBeanName}Manager/removeSecUser/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copySecUserFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


