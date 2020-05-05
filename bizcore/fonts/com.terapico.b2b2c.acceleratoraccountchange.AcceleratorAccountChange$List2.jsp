
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@page import='java.util.*,com.terapico.b2b2c.*'%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>


	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<c:if test="${not empty result.acceleratorAccountChangeList}"> 加速器账户变化 </c:if>
		
		<c:if test="${empty result.acceleratorAccountChangeList}"> 没有找到加速器账户变化!</c:if>
		 </div>
	</div>

    <c:if test="${not empty result.acceleratorAccountChangeList}" >
<div class="table-responsive">

<%
	//this is the only resolution for serlvet 2.5, EL2.2 will be much better
	BaseEntity result=(BaseEntity)request.getAttribute("result");
	
%>

<c:set var="pages" value="<%=result.flexibleListOf("acceleratorAccountChangeListPagination")%>" />

<c:forEach var="page" items="${pages}"> 
<c:if test='${page.selected}' >
<a href='#decorationAcceleratorManager/loadDecorationAccelerator/${result.id}/acceleratorAccountChangeList;acceleratorAccountChangeListCurrentPage=${page.pageNumber}/' class='page-action btn btn-danger btn-md submit'>${page.title}</a>
</c:if>
<c:if test='${ not page.selected }' >
<a href='#decorationAcceleratorManager/loadDecorationAccelerator/${result.id}/acceleratorAccountChangeList;acceleratorAccountChangeListCurrentPage=${page.pageNumber}/' class='page-action btn btn-info btn-md submit'>${page.title}</a>
</c:if>

</c:forEach>


	<table class="table table-striped">
		<thead><tr>
		<th>序号</th><th>变化类型</th><th>数量</th><th>描述</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.acceleratorAccountChangeList}">
				<tr><td><a class="link-action" href="#acceleratorAccountChangeManager/loadAcceleratorAccountChangeDetail/${item.id}/"> ${item.id}</a></td>
<td>${item.changeType}</td><td><fmt:formatNumber type="currency"  value="${item.amount}" /></td><td>${item.description}</td></tr>
			</c:forEach>
		
		</tbody>
	</table>	
	
	
</div></c:if>


