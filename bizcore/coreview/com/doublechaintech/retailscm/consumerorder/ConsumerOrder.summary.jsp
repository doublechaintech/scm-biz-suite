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
<section><h3>消费者订单(${result.id})</h3><table >
<tr><td class='th'>头衔</td><td >${result.title}</td><td class='th'>消费者</td><td >${result.consumer.displayName}</td></tr><tr><td class='th'>商场</td><td >${result.store.displayName}</td><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.lastUpdateTime}" /></td></tr></table>
</section>
<section><c:if test="${not empty result.consumerOrderLineItemList}">
	<c:forEach items="${result.consumerOrderLineItemList}" var="item">
<section><h3>消费者订单行项目(${item.id})</h3><table >
<tr><td class='th'>订单</td><td >${item.bizOrder.displayName}</td><td class='th'>产品ID</td><td >${item.skuId}</td></tr><tr><td class='th'>产品名称</td><td >${item.skuName}</td><td class='th'>价格</td><td >${item.price}</td></tr><tr><td class='th'>数量</td><td >${item.quantity}</td><td class='th'>金额</td><td >${item.amount}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.consumerOrderShippingGroupList}">
<section><h3>消费订单送货分组</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>订单</th><th>金额</th></tr>	<c:forEach items="${result.consumerOrderShippingGroupList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.bizOrder.displayName}</td><td>${item.amount}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.consumerOrderPaymentGroupList}">
<section><h3>消费者订单付款组</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>订单</th><th>卡号码</th></tr>	<c:forEach items="${result.consumerOrderPaymentGroupList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.bizOrder.displayName}</td><td>${item.cardNumber}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.consumerOrderPriceAdjustmentList}">
<section><h3>消费品价格调整</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>订单</th><th>金额</th><th>供应商</th></tr>	<c:forEach items="${result.consumerOrderPriceAdjustmentList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.bizOrder.displayName}</td><td>${item.amount}</td><td>${item.provider}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.retailStoreMemberGiftCardConsumeRecordList}">
<section><h3>零售门店会员卡消费记录</h3>
<table><tr>
<tr>
<th>ID</th><th>发生时间</th><th>业主</th><th>订单</th><th>数</th><th>金额</th></tr>	<c:forEach items="${result.retailStoreMemberGiftCardConsumeRecordList}" var="item">
	<tr>
<td>${item.id}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.occureTime}" /></td><td>${item.owner.displayName}</td><td>${item.bizOrder.displayName}</td><td>${item.number}</td><td>${item.amount}</td></tr></c:forEach></table>
</section>
</c:if></section>
