<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>



<style>
	
	table{
	  border: 1px solid black;
	  border-collapse: collapse;
	  width: 100%;
	  font-size: 12px;
	  padding: 5px;
	}
	th {
	  border: 1px solid black;
	  border-collapse: collapse;
	  font-size: 12px;
	  padding: 5px;
	  text-align: center;
	  background-color: lightgray;
	}
	td {
	  border: 1px solid black;
	  border-collapse: collapse;
	  
	  font-size: 10px;
	  padding-left: 5px;
	}
	
	/**/
	.table ,.tbody {
		all:unset;
		border: 1px solid black;
		
		width:100%;
	}

	.tr {
		all:unset;
		
		width: 25%;
	}

	.td {
		border: 1px solid red;
		border:initial;
		all:unset;
		text-align: justify;
		
		outline: none;
		font-size: 10px;
	  	padding: 5px;
		background-color: darkblue;
		word-break: break-all;
		
	}
	.th {
		width:"80px";
		background-color: lightgray;

		font-size: 10px;
		font-family: "Gill Sans Extrabold", sans-serif;
		padding: 5px;
		text-align: left;
		word-break: break-all;		
	}
	
</style>
<section><h3>账套(${result.id})</h3><table >
<tr><td class='th'>名称</td><td >${result.name}</td><td class='th'>年组</td><td >${result.yearSet}</td></tr><tr><td class='th'>生效日期</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.effectiveDate}" /></td><td class='th'>会计制度</td><td >${result.accountingSystem}</td></tr><tr><td class='th'>本币代码</td><td >${result.domesticCurrencyCode}</td><td class='th'>本币名称</td><td >${result.domesticCurrencyName}</td></tr><tr><td class='th'>开户银行</td><td >${result.openingBank}</td><td class='th'>帐户号码</td><td >${result.accountNumber}</td></tr><tr><td class='th'>双链小超</td><td >${result.retailStore.displayName}</td><td class='th'>产品供应商</td><td >${result.goodsSupplier.displayName}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.accountingSubjectList}">
<section><h3>会计科目</h3>
<table><tr>
<tr>
<th>ID</th><th>会计科目代码</th><th>会计科目名称</th><th>会计科目类别代码</th><th>会计科目类别名称</th><th>账套</th></tr>	<c:forEach items="${result.accountingSubjectList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.accountingSubjectCode}</td><td>${item.accountingSubjectName}</td><td>${item.accountingSubjectClassCode}</td><td>${item.accountingSubjectClassName}</td><td>${item.accountSet.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.accountingPeriodList}">
<section><h3>会计期间</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>开始日期</th><th>结束日期</th><th>账套</th></tr>	<c:forEach items="${result.accountingPeriodList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.startDate}" /></td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.endDate}" /></td><td>${item.accountSet.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.accountingDocumentTypeList}">
<section><h3>会计凭证类型</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>描述</th><th>会计期间</th></tr>	<c:forEach items="${result.accountingDocumentTypeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.description}</td><td>${item.accountingPeriod.displayName}</td></tr></c:forEach></table>
</section>
</c:if></section>
