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
<section><h3>培训课程类型(${result.id})</h3><table >
<tr><td class='th'>代码</td><td >${result.code}</td><td class='th'>名称</td><td >${result.name}</td></tr><tr><td class='th'>描述</td><td >${result.description}</td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.companyTrainingList}">
	<c:forEach items="${result.companyTrainingList}" var="item">
<section><h3>公司培训(${item.id})</h3><table >
<tr><td class='th'>头衔</td><td >${item.title}</td><td class='th'>讲师</td><td >${item.instructor.displayName}</td></tr><tr><td class='th'>培训课程类型</td><td >${item.trainingCourseType.displayName}</td><td class='th'>时间开始</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${item.timeStart}" /></td></tr><tr><td class='th'>持续时间</td><td >${item.durationHours}</td><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></table>
</section>
</c:forEach></c:if></section>
