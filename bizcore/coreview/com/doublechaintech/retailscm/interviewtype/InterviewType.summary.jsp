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
<section><h3>面试类型(${result.id})</h3><table >
<tr><td class='th'>代码</td><td >${result.code}</td><td class='th'>描述</td><td >${result.description}</td></tr><tr><td class='th'>详细描述</td><td >${result.detailDescription}</td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.employeeInterviewList}">
<section><h3>员工面试</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>面试类型</th><th>备注</th></tr>	<c:forEach items="${result.employeeInterviewList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td>${item.interviewType.displayName}</td><td>${item.remark}</td></tr></c:forEach></table>
</section>
</c:if></section>
