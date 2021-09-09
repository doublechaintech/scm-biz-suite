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
<section><h3>生超会员(${result.id})</h3><table >
<tr><td class='th'>名称</td><td >${result.name}</td><td class='th'>移动电话</td><td >${result.mobilePhone}</td></tr></table>
</section>
<section><c:if test="${not empty result.consumerOrderList}">
<section><h3>消费者订单</h3>
<table><tr>
<tr>
<th>ID</th><th>头衔</th><th>消费者</th><th>商场</th><th>更新于</th></tr>	<c:forEach items="${result.consumerOrderList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.title}</td><td>${item.consumer.displayName}</td><td>${item.store.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.retailStoreMemberCouponList}">
<section><h3>生超会员优惠券</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>业主</th><th>数</th><th>更新于</th></tr>	<c:forEach items="${result.retailStoreMemberCouponList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.owner.displayName}</td><td>${item.number}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.memberWishlistList}">
<section><h3>会员收藏</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>业主</th></tr>	<c:forEach items="${result.memberWishlistList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.owner.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.memberRewardPointList}">
<section><h3>会员奖励点</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>点</th><th>业主</th></tr>	<c:forEach items="${result.memberRewardPointList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.point}</td><td>${item.owner.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.memberRewardPointRedemptionList}">
<section><h3>会员奖励点赎回</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>点</th><th>业主</th></tr>	<c:forEach items="${result.memberRewardPointRedemptionList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.point}</td><td>${item.owner.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.retailStoreMemberAddressList}">
<section><h3>零售店会员地址</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>业主</th><th>移动电话</th><th>地址</th></tr>	<c:forEach items="${result.retailStoreMemberAddressList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.owner.displayName}</td><td>${item.mobilePhone}</td><td>${item.address}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.retailStoreMemberGiftCardList}">
<section><h3>零售店会员礼品卡</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>业主</th><th>数</th><th>保持</th></tr>	<c:forEach items="${result.retailStoreMemberGiftCardList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.owner.displayName}</td><td>${item.number}</td><td>${item.remain}</td></tr></c:forEach></table>
</section>
</c:if></section>
