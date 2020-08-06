<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty keypairIdentityList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['keypair_identity']}! 
		 <a href="./${ownerBeanName}Manager/addKeypairIdentity/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty keypairIdentityList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("keypairIdentityList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['keypair_identity']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addKeypairIdentity/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'keypairIdentityList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${keypairIdentityListName};${keypairIdentityListName}CurrentPage=${page.pageNumber};${keypairIdentityListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='keypairIdentityListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['keypair_identity.id']}</th>
</c:if>
<c:if test="${param.referName ne 'publicKey'}">
	<th>${userContext.localeMap['keypair_identity.public_key']}</th>
</c:if>
<c:if test="${param.referName ne 'keyType'}">
	<th>${userContext.localeMap['keypair_identity.key_type']}</th>
</c:if>
<c:if test="${param.referName ne 'secUser'}">
	<th>${userContext.localeMap['keypair_identity.sec_user']}</th>
</c:if>
<c:if test="${param.referName ne 'createTime'}">
	<th>${userContext.localeMap['keypair_identity.create_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${keypairIdentityList}">
				<tr currentVersion='${item.version}' id="keypairIdentity-${item.id}" ><td><a class="link-action-removed" href="./keypairIdentityManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'publicKey'}">	<td contenteditable='true' class='edit-value'  propertyToChange='publicKey' storedCellValue='${item.publicKey}' prefix='${ownerBeanName}Manager/updateKeypairIdentity/${result.id}/${item.id}/'><a title='${item.publicKey}'>${fn:substring(item.publicKey,0,10)}...</a></td>
</c:if><c:if test="${param.referName ne 'keyType'}">
	<td class="select_candidate_td"
			data-candidate-method="./keypairIdentityManager/requestCandidateKeyType/${ownerBeanName}/${item.id}/"
			data-switch-method="./keypairIdentityManager/transferToAnotherKeyType/${item.id}/"
			data-link-template="./publicKeyTypeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.keyType}">
			<a href='./publicKeyTypeManager/view/${item.keyType.id}/'>${item.keyType.displayName}</a>
			</c:if>
			<c:if test="${empty  item.keyType}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'secUser'}">
	<td class="select_candidate_td"
			data-candidate-method="./keypairIdentityManager/requestCandidateSecUser/${ownerBeanName}/${item.id}/"
			data-switch-method="./keypairIdentityManager/transferToAnotherSecUser/${item.id}/"
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
<c:if test="${param.referName ne 'createTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='createTime' storedCellValue='${item.createTime}' prefix='${ownerBeanName}Manager/updateKeypairIdentity/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.createTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeKeypairIdentity/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyKeypairIdentityFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


