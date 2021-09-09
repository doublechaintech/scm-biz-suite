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
<section><h3>货物(${result.id})</h3><table >
<tr><td class='th'>名称</td><td >${result.name}</td><td class='th'>RFID</td><td >${result.rfid}</td></tr><tr><td class='th'>计量单位</td><td >${result.uom}</td><td class='th'>最大包装</td><td >${result.maxPackage}</td></tr><tr><td class='th'>到期时间</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.expireTime}" /></td><td class='th'>SKU</td><td >${result.sku.displayName}</td></tr><tr><td class='th'>收货区</td><td >${result.receivingSpace.displayName}</td><td class='th'>货位</td><td >${result.goodsAllocation.displayName}</td></tr><tr><td class='th'>智能托盘</td><td >${result.smartPallet.displayName}</td><td class='th'>发货区</td><td >${result.shippingSpace.displayName}</td></tr><tr><td class='th'>运输任务</td><td >${result.transportTask.displayName}</td><td class='th'>双链小超</td><td >${result.retailStore.displayName}</td></tr><tr><td class='th'>订单</td><td >${result.bizOrder.displayName}</td><td class='th'>生超的订单</td><td >${result.retailStoreOrder.displayName}</td></tr></table>
</section>
<section><c:if test="${not empty result.goodsMovementList}">
	<c:forEach items="${result.goodsMovementList}" var="item">
<section><h3>货物移动(${item.id})</h3><table >
<tr><td class='th'>移动时间</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.moveTime}" /></td><td class='th'>设施</td><td >${item.facility}</td></tr><tr><td class='th'>设备ID</td><td >${item.facilityId}</td><td class='th'>从IP</td><td >${item.fromIp}</td></tr><tr><td class='th'>用户代理</td><td >${item.userAgent}</td><td class='th'>会话ID</td><td >${item.sessionId}</td></tr><tr><td class='th'>纬度</td><td >${item.latitude}</td><td class='th'>经度</td><td >${item.longitude}</td></tr><tr><td class='th'>货物</td><td >${item.goods.displayName}</td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if></section>
