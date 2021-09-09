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
<section><h3>会计科目(${result.id})</h3><table >
<tr><td class='th'>会计科目代码</td><td >${result.accountingSubjectCode}</td><td class='th'>会计科目名称</td><td >${result.accountingSubjectName}</td></tr><tr><td class='th'>会计科目类别代码</td><td >${result.accountingSubjectClassCode}</td><td class='th'>会计科目类别名称</td><td >${result.accountingSubjectClassName}</td></tr><tr><td class='th'>账套</td><td >${result.accountSet.displayName}</td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.accountingDocumentLineList}">
	<c:forEach items="${result.accountingDocumentLineList}" var="item">
<section><h3>会计凭证行(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>代码</td><td >${item.code}</td></tr><tr><td class='th'>直接</td><td >${item.direct}</td><td class='th'>金额</td><td >${item.amount}</td></tr><tr><td class='th'>属于</td><td >${item.belongsTo.displayName}</td><td class='th'>会计科目</td><td >${item.accountingSubject.displayName}</td></tr></table>
</section>
</c:forEach></c:if></section>
