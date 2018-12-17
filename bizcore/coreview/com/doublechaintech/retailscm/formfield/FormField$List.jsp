<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty formFieldList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['form_field']}! 
		 <a href="./${ownerBeanName}Manager/addFormField/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty formFieldList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("formFieldList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['form_field']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addFormField/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'formFieldList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${formFieldListName};${formFieldListName}CurrentPage=${page.pageNumber};${formFieldListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='formFieldListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['form_field.id']}</th>
</c:if>
<c:if test="${param.referName ne 'label'}">
	<th>${userContext.localeMap['form_field.label']}</th>
</c:if>
<c:if test="${param.referName ne 'localeKey'}">
	<th>${userContext.localeMap['form_field.locale_key']}</th>
</c:if>
<c:if test="${param.referName ne 'parameterName'}">
	<th>${userContext.localeMap['form_field.parameter_name']}</th>
</c:if>
<c:if test="${param.referName ne 'type'}">
	<th>${userContext.localeMap['form_field.type']}</th>
</c:if>
<c:if test="${param.referName ne 'form'}">
	<th>${userContext.localeMap['form_field.form']}</th>
</c:if>
<c:if test="${param.referName ne 'placeholder'}">
	<th>${userContext.localeMap['form_field.placeholder']}</th>
</c:if>
<c:if test="${param.referName ne 'defaultValue'}">
	<th>${userContext.localeMap['form_field.default_value']}</th>
</c:if>
<c:if test="${param.referName ne 'description'}">
	<th>${userContext.localeMap['form_field.description']}</th>
</c:if>
<c:if test="${param.referName ne 'fieldGroup'}">
	<th>${userContext.localeMap['form_field.field_group']}</th>
</c:if>
<c:if test="${param.referName ne 'minimumValue'}">
	<th>${userContext.localeMap['form_field.minimum_value']}</th>
</c:if>
<c:if test="${param.referName ne 'maximumValue'}">
	<th>${userContext.localeMap['form_field.maximum_value']}</th>
</c:if>
<c:if test="${param.referName ne 'required'}">
	<th>${userContext.localeMap['form_field.required']}</th>
</c:if>
<c:if test="${param.referName ne 'disabled'}">
	<th>${userContext.localeMap['form_field.disabled']}</th>
</c:if>
<c:if test="${param.referName ne 'customRendering'}">
	<th>${userContext.localeMap['form_field.custom_rendering']}</th>
</c:if>
<c:if test="${param.referName ne 'candidateValues'}">
	<th>${userContext.localeMap['form_field.candidate_values']}</th>
</c:if>
<c:if test="${param.referName ne 'suggestValues'}">
	<th>${userContext.localeMap['form_field.suggest_values']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${formFieldList}">
				<tr currentVersion='${item.version}' id="formField-${item.id}" ><td><a class="link-action-removed" href="./formFieldManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'label'}">	<td contenteditable='true' class='edit-value'  propertyToChange='label' storedCellValue='${item.label}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.label}</td>
</c:if><c:if test="${param.referName ne 'localeKey'}">	<td contenteditable='true' class='edit-value'  propertyToChange='localeKey' storedCellValue='${item.localeKey}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.localeKey}</td>
</c:if><c:if test="${param.referName ne 'parameterName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='parameterName' storedCellValue='${item.parameterName}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.parameterName}</td>
</c:if><c:if test="${param.referName ne 'type'}">	<td contenteditable='true' class='edit-value'  propertyToChange='type' storedCellValue='${item.type}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.type}</td>
</c:if><c:if test="${param.referName ne 'form'}">
	<td class="select_candidate_td"
			data-candidate-method="./formFieldManager/requestCandidateForm/${ownerBeanName}/${item.id}/"
			data-switch-method="./formFieldManager/transferToAnotherForm/${item.id}/"
			data-link-template="./genericFormManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.form}">
			<a href='./genericFormManager/view/${item.form.id}/'>${item.form.displayName}</a>
			</c:if>
			<c:if test="${empty  item.form}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'placeholder'}">	<td contenteditable='true' class='edit-value'  propertyToChange='placeholder' storedCellValue='${item.placeholder}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.placeholder}</td>
</c:if><c:if test="${param.referName ne 'defaultValue'}">	<td contenteditable='true' class='edit-value'  propertyToChange='defaultValue' storedCellValue='${item.defaultValue}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.defaultValue}</td>
</c:if><c:if test="${param.referName ne 'description'}">	<td contenteditable='true' class='edit-value'  propertyToChange='description' storedCellValue='${item.description}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.description}</td>
</c:if><c:if test="${param.referName ne 'fieldGroup'}">	<td contenteditable='true' class='edit-value'  propertyToChange='fieldGroup' storedCellValue='${item.fieldGroup}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.fieldGroup}</td>
</c:if><c:if test="${param.referName ne 'minimumValue'}">	<td contenteditable='true' class='edit-value'  propertyToChange='minimumValue' storedCellValue='${item.minimumValue}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.minimumValue}</td>
</c:if><c:if test="${param.referName ne 'maximumValue'}">	<td contenteditable='true' class='edit-value'  propertyToChange='maximumValue' storedCellValue='${item.maximumValue}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.maximumValue}</td>
</c:if><c:if test="${param.referName ne 'required'}">	<td contenteditable='true' class='edit-value'  propertyToChange='required' storedCellValue='${item.required}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.required}</td>
</c:if><c:if test="${param.referName ne 'disabled'}">	<td contenteditable='true' class='edit-value'  propertyToChange='disabled' storedCellValue='${item.disabled}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.disabled}</td>
</c:if><c:if test="${param.referName ne 'customRendering'}">	<td contenteditable='true' class='edit-value'  propertyToChange='customRendering' storedCellValue='${item.customRendering}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.customRendering}</td>
</c:if><c:if test="${param.referName ne 'candidateValues'}">	<td contenteditable='true' class='edit-value'  propertyToChange='candidateValues' storedCellValue='${item.candidateValues}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.candidateValues}</td>
</c:if><c:if test="${param.referName ne 'suggestValues'}">	<td contenteditable='true' class='edit-value'  propertyToChange='suggestValues' storedCellValue='${item.suggestValues}' prefix='${ownerBeanName}Manager/updateFormField/${result.id}/${item.id}/'>${item.suggestValues}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeFormField/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyFormFieldFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


