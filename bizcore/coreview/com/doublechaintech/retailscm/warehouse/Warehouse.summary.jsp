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
<section><h3>仓库(${result.id})</h3><table >
<tr><td class='th'>位置</td><td >${result.location}</td><td class='th'>联系电话</td><td >${result.contactNumber}</td></tr><tr><td class='th'>总面积</td><td >${result.totalArea}</td><td class='th'>纬度</td><td >${result.latitude}</td></tr><tr><td class='th'>经度</td><td >${result.longitude}</td><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.lastUpdateTime}" /></td></tr></table>
</section>
<section><c:if test="${not empty result.storageSpaceList}">
	<c:forEach items="${result.storageSpaceList}" var="item">
<section><h3>存货区(${item.id})</h3><table >
<tr><td class='th'>位置</td><td >${item.location}</td><td class='th'>联系电话</td><td >${item.contactNumber}</td></tr><tr><td class='th'>总面积</td><td >${item.totalArea}</td><td class='th'>仓库</td><td >${item.warehouse.displayName}</td></tr><tr><td class='th'>纬度</td><td >${item.latitude}</td><td class='th'>经度</td><td >${item.longitude}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.smartPalletList}">
	<c:forEach items="${result.smartPalletList}" var="item">
<section><h3>智能托盘(${item.id})</h3><table >
<tr><td class='th'>位置</td><td >${item.location}</td><td class='th'>联系电话</td><td >${item.contactNumber}</td></tr><tr><td class='th'>总面积</td><td >${item.totalArea}</td><td class='th'>纬度</td><td >${item.latitude}</td></tr><tr><td class='th'>经度</td><td >${item.longitude}</td><td class='th'>仓库</td><td >${item.warehouse.displayName}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.supplierSpaceList}">
	<c:forEach items="${result.supplierSpaceList}" var="item">
<section><h3>供应商的空间(${item.id})</h3><table >
<tr><td class='th'>位置</td><td >${item.location}</td><td class='th'>联系电话</td><td >${item.contactNumber}</td></tr><tr><td class='th'>总面积</td><td >${item.totalArea}</td><td class='th'>仓库</td><td >${item.warehouse.displayName}</td></tr><tr><td class='th'>纬度</td><td >${item.latitude}</td><td class='th'>经度</td><td >${item.longitude}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.receivingSpaceList}">
	<c:forEach items="${result.receivingSpaceList}" var="item">
<section><h3>收货区(${item.id})</h3><table >
<tr><td class='th'>位置</td><td >${item.location}</td><td class='th'>联系电话</td><td >${item.contactNumber}</td></tr><tr><td class='th'>描述</td><td >${item.description}</td><td class='th'>总面积</td><td >${item.totalArea}</td></tr><tr><td class='th'>仓库</td><td >${item.warehouse.displayName}</td><td class='th'>纬度</td><td >${item.latitude}</td></tr><tr><td class='th'>经度</td><td >${item.longitude}</td><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.shippingSpaceList}">
	<c:forEach items="${result.shippingSpaceList}" var="item">
<section><h3>发货区(${item.id})</h3><table >
<tr><td class='th'>位置</td><td >${item.location}</td><td class='th'>联系电话</td><td >${item.contactNumber}</td></tr><tr><td class='th'>总面积</td><td >${item.totalArea}</td><td class='th'>仓库</td><td >${item.warehouse.displayName}</td></tr><tr><td class='th'>纬度</td><td >${item.latitude}</td><td class='th'>经度</td><td >${item.longitude}</td></tr><tr><td class='th'>描述</td><td >${item.description}</td><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.damageSpaceList}">
	<c:forEach items="${result.damageSpaceList}" var="item">
<section><h3>残次货物存放区(${item.id})</h3><table >
<tr><td class='th'>位置</td><td >${item.location}</td><td class='th'>联系电话</td><td >${item.contactNumber}</td></tr><tr><td class='th'>总面积</td><td >${item.totalArea}</td><td class='th'>纬度</td><td >${item.latitude}</td></tr><tr><td class='th'>经度</td><td >${item.longitude}</td><td class='th'>仓库</td><td >${item.warehouse.displayName}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.warehouseAssetList}">
<section><h3>仓库资产</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>位置</th><th>业主</th><th>更新于</th></tr>	<c:forEach items="${result.warehouseAssetList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.position}</td><td>${item.owner.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if></section>
