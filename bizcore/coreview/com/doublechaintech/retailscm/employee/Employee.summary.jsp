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
<section><h3>员工(${result.id})</h3><table >
<tr><td class='th'>头衔</td><td >${result.title}</td><td class='th'>部门</td><td >${result.department.displayName}</td></tr><tr><td class='th'>姓</td><td >${result.familyName}</td><td class='th'>名</td><td >${result.givenName}</td></tr><tr><td class='th'>电子邮件</td><td >${result.email}</td><td class='th'>城市</td><td >${result.city}</td></tr><tr><td class='th'>地址</td><td >${result.address}</td><td class='th'>手机</td><td >${result.cellPhone}</td></tr><tr><td class='th'>职业</td><td >${result.occupation.displayName}</td><td class='th'>负责</td><td >${result.responsibleFor.displayName}</td></tr><tr><td class='th'>目前工资等级</td><td >${result.currentSalaryGrade.displayName}</td><td class='th'>工资账户</td><td >${result.salaryAccount}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.employeeCompanyTrainingList}">
<section><h3>员工参与的公司培训</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>训练</th><th>评分</th></tr>	<c:forEach items="${result.employeeCompanyTrainingList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td>${item.training.displayName}</td><td>${item.scoring.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeSkillList}">
<section><h3>员工技能</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>技能类型</th><th>描述</th></tr>	<c:forEach items="${result.employeeSkillList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td>${item.skillType.displayName}</td><td>${item.description}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeePerformanceList}">
<section><h3>员工绩效</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>绩效评价</th></tr>	<c:forEach items="${result.employeePerformanceList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td>${item.performanceComment}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeWorkExperienceList}">
<section><h3>员工工作经验</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>开始</th><th>结束</th><th>公司</th><th>描述</th></tr>	<c:forEach items="${result.employeeWorkExperienceList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.start}" /></td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.end}" /></td><td>${item.company}</td><td>${item.description}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeLeaveList}">
<section><h3>请假记录</h3>
<table><tr>
<tr>
<th>ID</th><th>谁</th><th>类型</th><th>请假时长</th><th>备注</th></tr>	<c:forEach items="${result.employeeLeaveList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.who.displayName}</td><td>${item.type.displayName}</td><td>${item.leaveDurationHour}</td><td>${item.remark}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeInterviewList}">
<section><h3>员工面试</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>面试类型</th><th>备注</th></tr>	<c:forEach items="${result.employeeInterviewList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td>${item.interviewType.displayName}</td><td>${item.remark}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeAttendanceList}">
<section><h3>员工考勤</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>进入时间</th><th>离开的时候</th><th>持续时间</th><th>备注</th></tr>	<c:forEach items="${result.employeeAttendanceList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.enterTime}" /></td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.leaveTime}" /></td><td>${item.durationHours}</td><td>${item.remark}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeQualifierList}">
<section><h3>员工资质</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>合格的时间</th><th>类型</th><th>水平</th><th>备注</th></tr>	<c:forEach items="${result.employeeQualifierList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.qualifiedTime}" /></td><td>${item.type}</td><td>${item.level}</td><td>${item.remark}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeEducationList}">
<section><h3>员工教育</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>完成时间</th><th>类型</th><th>备注</th></tr>	<c:forEach items="${result.employeeEducationList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.completeTime}" /></td><td>${item.type}</td><td>${item.remark}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeAwardList}">
<section><h3>员工嘉奖</h3>
<table><tr>
<tr>
<th>ID</th><th>员工</th><th>完成时间</th><th>类型</th><th>备注</th></tr>	<c:forEach items="${result.employeeAwardList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.employee.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.completeTime}" /></td><td>${item.type}</td><td>${item.remark}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeSalarySheetList}">
	<c:forEach items="${result.employeeSalarySheetList}" var="item">
<section><h3>工资单(${item.id})</h3><table >
<tr><td class='th'>员工</td><td >${item.employee.displayName}</td><td class='th'>目前工资等级</td><td >${item.currentSalaryGrade.displayName}</td></tr><tr><td class='th'>基本工资</td><td >${item.baseSalary}</td><td class='th'>奖金</td><td >${item.bonus}</td></tr><tr><td class='th'>奖励</td><td >${item.reward}</td><td class='th'>个人所得税</td><td >${item.personalTax}</td></tr><tr><td class='th'>社会保险</td><td >${item.socialSecurity}</td><td class='th'>住房公积金</td><td >${item.housingFound}</td></tr><tr><td class='th'>失业保险</td><td >${item.jobInsurance}</td><td class='th'>工资支付</td><td >${item.payingOff.displayName}</td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.payingOffList}">
<section><h3>工资支付</h3>
<table><tr>
<tr>
<th>ID</th><th>谁</th><th>支付</th><th>支付时间</th><th>金额</th></tr>	<c:forEach items="${result.payingOffList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.who}</td><td>${item.paidFor.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.paidTime}" /></td><td>${item.amount}</td></tr></c:forEach></table>
</section>
</c:if></section>
