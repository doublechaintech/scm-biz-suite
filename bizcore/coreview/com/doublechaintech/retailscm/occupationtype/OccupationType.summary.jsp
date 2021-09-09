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
<section><h3>职位类型(${result.id})</h3><table >
<tr><td class='th'>代码</td><td >${result.code}</td><td class='th'>描述</td><td >${result.description}</td></tr><tr><td class='th'>详细描述</td><td >${result.detailDescription}</td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.employeeList}">
	<c:forEach items="${result.employeeList}" var="item">
<section><h3>员工(${item.id})</h3><table >
<tr><td class='th'>头衔</td><td >${item.title}</td><td class='th'>部门</td><td >${item.department.displayName}</td></tr><tr><td class='th'>姓</td><td >${item.familyName}</td><td class='th'>名</td><td >${item.givenName}</td></tr><tr><td class='th'>电子邮件</td><td >${item.email}</td><td class='th'>城市</td><td >${item.city}</td></tr><tr><td class='th'>地址</td><td >${item.address}</td><td class='th'>手机</td><td >${item.cellPhone}</td></tr><tr><td class='th'>职业</td><td >${item.occupation.displayName}</td><td class='th'>负责</td><td >${item.responsibleFor.displayName}</td></tr><tr><td class='th'>目前工资等级</td><td >${item.currentSalaryGrade.displayName}</td><td class='th'>工资账户</td><td >${item.salaryAccount}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if></section>
