<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty reportLineList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['report_line']}! 
		 <a href="./${ownerBeanName}Manager/addReportLine/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty reportLineList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("reportLineList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['report_line']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addReportLine/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'reportLineList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${reportLineListName};${reportLineListName}CurrentPage=${page.pageNumber};${reportLineListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='reportLineListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['report_line.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['report_line.name']}</th>
</c:if>
<c:if test="${param.referName ne 'owner'}">
	<th>${userContext.localeMap['report_line.owner']}</th>
</c:if>
<c:if test="${param.referName ne 'january'}">
	<th>${userContext.localeMap['report_line.january']}</th>
</c:if>
<c:if test="${param.referName ne 'february'}">
	<th>${userContext.localeMap['report_line.february']}</th>
</c:if>
<c:if test="${param.referName ne 'march'}">
	<th>${userContext.localeMap['report_line.march']}</th>
</c:if>
<c:if test="${param.referName ne 'april'}">
	<th>${userContext.localeMap['report_line.april']}</th>
</c:if>
<c:if test="${param.referName ne 'may'}">
	<th>${userContext.localeMap['report_line.may']}</th>
</c:if>
<c:if test="${param.referName ne 'june'}">
	<th>${userContext.localeMap['report_line.june']}</th>
</c:if>
<c:if test="${param.referName ne 'july'}">
	<th>${userContext.localeMap['report_line.july']}</th>
</c:if>
<c:if test="${param.referName ne 'august'}">
	<th>${userContext.localeMap['report_line.august']}</th>
</c:if>
<c:if test="${param.referName ne 'september'}">
	<th>${userContext.localeMap['report_line.september']}</th>
</c:if>
<c:if test="${param.referName ne 'october'}">
	<th>${userContext.localeMap['report_line.october']}</th>
</c:if>
<c:if test="${param.referName ne 'november'}">
	<th>${userContext.localeMap['report_line.november']}</th>
</c:if>
<c:if test="${param.referName ne 'december'}">
	<th>${userContext.localeMap['report_line.december']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${reportLineList}">
				<tr currentVersion='${item.version}' id="reportLine-${item.id}" ><td><a class="link-action-removed" href="./reportLineManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'owner'}">
	<td class="select_candidate_td"
			data-candidate-method="./reportLineManager/requestCandidateOwner/${ownerBeanName}/${item.id}/"
			data-switch-method="./reportLineManager/transferToAnotherOwner/${item.id}/"
			data-link-template="./reportManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.owner}">
			<a href='./reportManager/view/${item.owner.id}/'>${item.owner.displayName}</a>
			</c:if>
			<c:if test="${empty  item.owner}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'january'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='january' storedCellValue='${item.january}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.january}" /></td>
</c:if><c:if test="${param.referName ne 'february'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='february' storedCellValue='${item.february}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.february}" /></td>
</c:if><c:if test="${param.referName ne 'march'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='march' storedCellValue='${item.march}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.march}" /></td>
</c:if><c:if test="${param.referName ne 'april'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='april' storedCellValue='${item.april}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.april}" /></td>
</c:if><c:if test="${param.referName ne 'may'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='may' storedCellValue='${item.may}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.may}" /></td>
</c:if><c:if test="${param.referName ne 'june'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='june' storedCellValue='${item.june}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.june}" /></td>
</c:if><c:if test="${param.referName ne 'july'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='july' storedCellValue='${item.july}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.july}" /></td>
</c:if><c:if test="${param.referName ne 'august'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='august' storedCellValue='${item.august}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.august}" /></td>
</c:if><c:if test="${param.referName ne 'september'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='september' storedCellValue='${item.september}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.september}" /></td>
</c:if><c:if test="${param.referName ne 'october'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='october' storedCellValue='${item.october}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.october}" /></td>
</c:if><c:if test="${param.referName ne 'november'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='november' storedCellValue='${item.november}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.november}" /></td>
</c:if><c:if test="${param.referName ne 'december'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='december' storedCellValue='${item.december}' prefix='${ownerBeanName}Manager/updateReportLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.december}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeReportLine/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyReportLineFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


