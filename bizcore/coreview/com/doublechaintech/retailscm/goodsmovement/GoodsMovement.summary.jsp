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
<section><h3>货物移动(${result.id})</h3><table >
<tr><td class='th'>移动时间</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.moveTime}" /></td><td class='th'>设施</td><td >${result.facility}</td></tr><tr><td class='th'>设备ID</td><td >${result.facilityId}</td><td class='th'>从IP</td><td >${result.fromIp}</td></tr><tr><td class='th'>用户代理</td><td >${result.userAgent}</td><td class='th'>会话ID</td><td >${result.sessionId}</td></tr><tr><td class='th'>纬度</td><td >${result.latitude}</td><td class='th'>经度</td><td >${result.longitude}</td></tr><tr><td class='th'>货物</td><td >${result.goods.displayName}</td><td class='th'></td><td ></td></tr></table>
</section>
<section></section>
