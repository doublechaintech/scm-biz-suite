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
<section><h3>产品供应商(${result.id})</h3><table >
<tr><td class='th'>名称</td><td >${result.name}</td><td class='th'>供应产品</td><td >${result.supplyProduct}</td></tr><tr><td class='th'>联系电话</td><td >${result.contactNumber}</td><td class='th'>描述</td><td >${result.description}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.supplierProductList}">
<section><h3>供应商的产品</h3>
<table><tr>
<tr>
<th>ID</th><th>品名</th><th>产品描述</th><th>产品单元</th><th>供应商</th></tr>	<c:forEach items="${result.supplierProductList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.productName}</td><td>${item.productDescription}</td><td>${item.productUnit}</td><td>${item.supplier.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.supplyOrderList}">
<section><h3>供应订单</h3>
<table><tr>
<tr>
<th>ID</th><th>买方</th><th>卖方</th><th>头衔</th><th>总金额</th><th>更新于</th></tr>	<c:forEach items="${result.supplyOrderList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.buyer.displayName}</td><td>${item.seller.displayName}</td><td>${item.title}</td><td>${item.totalAmount}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.accountSetList}">
	<c:forEach items="${result.accountSetList}" var="item">
<section><h3>账套(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>年组</td><td >${item.yearSet}</td></tr><tr><td class='th'>生效日期</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${item.effectiveDate}" /></td><td class='th'>会计制度</td><td >${item.accountingSystem}</td></tr><tr><td class='th'>本币代码</td><td >${item.domesticCurrencyCode}</td><td class='th'>本币名称</td><td >${item.domesticCurrencyName}</td></tr><tr><td class='th'>开户银行</td><td >${item.openingBank}</td><td class='th'>帐户号码</td><td >${item.accountNumber}</td></tr><tr><td class='th'>双链小超</td><td >${item.retailStore.displayName}</td><td class='th'>产品供应商</td><td >${item.goodsSupplier.displayName}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if></section>
