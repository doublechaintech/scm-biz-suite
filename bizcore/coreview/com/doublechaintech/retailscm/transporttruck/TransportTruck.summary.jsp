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
<section><h3>运输车(${result.id})</h3><table >
<tr><td class='th'>名称</td><td >${result.name}</td><td class='th'>车牌号码</td><td >${result.plateNumber}</td></tr><tr><td class='th'>联系电话</td><td >${result.contactNumber}</td><td class='th'>汽车牌照号码</td><td >${result.vehicleLicenseNumber}</td></tr><tr><td class='th'>发动机号</td><td >${result.engineNumber}</td><td class='th'>制造日期</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.makeDate}" /></td></tr><tr><td class='th'>里程</td><td >${result.mileage}</td><td class='th'>车身颜色</td><td >${result.bodyColor}</td></tr><tr><td class='th'>业主</td><td >${result.owner.displayName}</td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.transportTaskList}">
	<c:forEach items="${result.transportTaskList}" var="item">
<section><h3>运输任务(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>开始</td><td >${item.start}</td></tr><tr><td class='th'>开始时间</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${item.beginTime}" /></td><td class='th'>结束</td><td >${item.end.displayName}</td></tr><tr><td class='th'>司机</td><td >${item.driver.displayName}</td><td class='th'>卡车</td><td >${item.truck.displayName}</td></tr><tr><td class='th'>属于</td><td >${item.belongsTo.displayName}</td><td class='th'>纬度</td><td >${item.latitude}</td></tr><tr><td class='th'>经度</td><td >${item.longitude}</td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if></section>
