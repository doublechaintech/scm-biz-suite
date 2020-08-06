<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty wechatMiniappIdentityList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['wechat_miniapp_identity']}! 
		 <a href="./${ownerBeanName}Manager/addWechatMiniappIdentity/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty wechatMiniappIdentityList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("wechatMiniappIdentityList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['wechat_miniapp_identity']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addWechatMiniappIdentity/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'wechatMiniappIdentityList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${wechatMiniappIdentityListName};${wechatMiniappIdentityListName}CurrentPage=${page.pageNumber};${wechatMiniappIdentityListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='wechatMiniappIdentityListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['wechat_miniapp_identity.id']}</th>
</c:if>
<c:if test="${param.referName ne 'openId'}">
	<th>${userContext.localeMap['wechat_miniapp_identity.open_id']}</th>
</c:if>
<c:if test="${param.referName ne 'appId'}">
	<th>${userContext.localeMap['wechat_miniapp_identity.app_id']}</th>
</c:if>
<c:if test="${param.referName ne 'secUser'}">
	<th>${userContext.localeMap['wechat_miniapp_identity.sec_user']}</th>
</c:if>
<c:if test="${param.referName ne 'createTime'}">
	<th>${userContext.localeMap['wechat_miniapp_identity.create_time']}</th>
</c:if>
<c:if test="${param.referName ne 'lastLoginTime'}">
	<th>${userContext.localeMap['wechat_miniapp_identity.last_login_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${wechatMiniappIdentityList}">
				<tr currentVersion='${item.version}' id="wechatMiniappIdentity-${item.id}" ><td><a class="link-action-removed" href="./wechatMiniappIdentityManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'openId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='openId' storedCellValue='${item.openId}' prefix='${ownerBeanName}Manager/updateWechatMiniappIdentity/${result.id}/${item.id}/'>${item.openId}</td>
</c:if><c:if test="${param.referName ne 'appId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='appId' storedCellValue='${item.appId}' prefix='${ownerBeanName}Manager/updateWechatMiniappIdentity/${result.id}/${item.id}/'>${item.appId}</td>
</c:if><c:if test="${param.referName ne 'secUser'}">
	<td class="select_candidate_td"
			data-candidate-method="./wechatMiniappIdentityManager/requestCandidateSecUser/${ownerBeanName}/${item.id}/"
			data-switch-method="./wechatMiniappIdentityManager/transferToAnotherSecUser/${item.id}/"
			data-link-template="./secUserManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.secUser}">
			<a href='./secUserManager/view/${item.secUser.id}/'>${item.secUser.displayName}</a>
			</c:if>
			<c:if test="${empty  item.secUser}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'createTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='createTime' storedCellValue='${item.createTime}' prefix='${ownerBeanName}Manager/updateWechatMiniappIdentity/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.createTime}" /></td>
</c:if><c:if test="${param.referName ne 'lastLoginTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastLoginTime' storedCellValue='${item.lastLoginTime}' prefix='${ownerBeanName}Manager/updateWechatMiniappIdentity/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastLoginTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeWechatMiniappIdentity/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyWechatMiniappIdentityFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


