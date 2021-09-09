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
<section><h3>双链小超全国运营中心(${result.id})</h3><table >
<tr><td class='th'>名称</td><td >${result.name}</td><td class='th'>服务号码</td><td >${result.serviceNumber}</td></tr><tr><td class='th'>成立</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.founded}" /></td><td class='th'>网站</td><td >${result.webSite}</td></tr><tr><td class='th'>地址</td><td >${result.address}</td><td class='th'>由</td><td >${result.operatedBy}</td></tr><tr><td class='th'>法定代表人</td><td >${result.legalRepresentative}</td><td class='th'>描述</td><td >${result.description}</td></tr></table>
</section>
<section><c:if test="${not empty result.catalogList}">
<section><h3>目录</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>业主</th><th>子数</th><th>金额</th></tr>	<c:forEach items="${result.catalogList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.owner.displayName}</td><td>${item.subCount}</td><td>${item.amount}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.retailStoreProvinceCenterList}">
<section><h3>双链小超省中心</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>成立</th><th>国</th><th>更新于</th></tr>	<c:forEach items="${result.retailStoreProvinceCenterList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.founded}" /></td><td>${item.country.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.retailStoreList}">
	<c:forEach items="${result.retailStoreList}" var="item">
<section><h3>双链小超(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>电话</td><td >${item.telephone}</td></tr><tr><td class='th'>业主</td><td >${item.owner}</td><td class='th'>城市服务中心</td><td >${item.cityServiceCenter.displayName}</td></tr><tr><td class='th'>成立</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${item.founded}" /></td><td class='th'>纬度</td><td >${item.latitude}</td></tr><tr><td class='th'>经度</td><td >${item.longitude}</td><td class='th'>描述</td><td >${item.description}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.retailStoreMemberList}">
<section><h3>生超会员</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>移动电话</th><th>业主</th></tr>	<c:forEach items="${result.retailStoreMemberList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.mobilePhone}</td><td>${item.owner.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.goodsSupplierList}">
	<c:forEach items="${result.goodsSupplierList}" var="item">
<section><h3>产品供应商(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>供应产品</td><td >${item.supplyProduct}</td></tr><tr><td class='th'>联系电话</td><td >${item.contactNumber}</td><td class='th'>描述</td><td >${item.description}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.supplyOrderList}">
<section><h3>供应订单</h3>
<table><tr>
<tr>
<th>ID</th><th>买方</th><th>卖方</th><th>头衔</th><th>总金额</th><th>更新于</th></tr>	<c:forEach items="${result.supplyOrderList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.buyer.displayName}</td><td>${item.seller.displayName}</td><td>${item.title}</td><td>${item.totalAmount}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.retailStoreOrderList}">
<section><h3>生超的订单</h3>
<table><tr>
<tr>
<th>ID</th><th>买方</th><th>卖方</th><th>头衔</th><th>总金额</th><th>更新于</th></tr>	<c:forEach items="${result.retailStoreOrderList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.buyer.displayName}</td><td>${item.seller.displayName}</td><td>${item.title}</td><td>${item.totalAmount}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.warehouseList}">
	<c:forEach items="${result.warehouseList}" var="item">
<section><h3>仓库(${item.id})</h3><table >
<tr><td class='th'>位置</td><td >${item.location}</td><td class='th'>联系电话</td><td >${item.contactNumber}</td></tr><tr><td class='th'>总面积</td><td >${item.totalArea}</td><td class='th'>纬度</td><td >${item.latitude}</td></tr><tr><td class='th'>经度</td><td >${item.longitude}</td><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.transportFleetList}">
<section><h3>运输车队</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>联系电话</th><th>业主</th><th>更新于</th></tr>	<c:forEach items="${result.transportFleetList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.contactNumber}</td><td>${item.owner.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.accountSetList}">
	<c:forEach items="${result.accountSetList}" var="item">
<section><h3>账套(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>年组</td><td >${item.yearSet}</td></tr><tr><td class='th'>生效日期</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${item.effectiveDate}" /></td><td class='th'>会计制度</td><td >${item.accountingSystem}</td></tr><tr><td class='th'>本币代码</td><td >${item.domesticCurrencyCode}</td><td class='th'>本币名称</td><td >${item.domesticCurrencyName}</td></tr><tr><td class='th'>开户银行</td><td >${item.openingBank}</td><td class='th'>帐户号码</td><td >${item.accountNumber}</td></tr><tr><td class='th'>双链小超</td><td >${item.retailStore.displayName}</td><td class='th'>产品供应商</td><td >${item.goodsSupplier.displayName}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.levelOneDepartmentList}">
<section><h3>一级部门</h3>
<table><tr>
<tr>
<th>ID</th><th>属于</th><th>名称</th><th>描述</th><th>经理</th><th>成立</th></tr>	<c:forEach items="${result.levelOneDepartmentList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.belongsTo.displayName}</td><td>${item.name}</td><td>${item.description}</td><td>${item.manager}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.founded}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.skillTypeList}">
<section><h3>技能类型</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>描述</th></tr>	<c:forEach items="${result.skillTypeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.description}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.responsibilityTypeList}">
<section><h3>责任类型</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>基本描述</th><th>详细描述</th></tr>	<c:forEach items="${result.responsibilityTypeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.baseDescription}</td><td>${item.detailDescription}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.terminationReasonList}">
<section><h3>雇佣终止的原因</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>描述</th></tr>	<c:forEach items="${result.terminationReasonList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.description}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.terminationTypeList}">
<section><h3>雇佣终止类型</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>基本描述</th><th>详细描述</th></tr>	<c:forEach items="${result.terminationTypeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.baseDescription}</td><td>${item.detailDescription}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.occupationTypeList}">
<section><h3>职位类型</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>描述</th><th>详细描述</th></tr>	<c:forEach items="${result.occupationTypeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.description}</td><td>${item.detailDescription}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.leaveTypeList}">
<section><h3>请假类型</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>描述</th><th>详细描述</th></tr>	<c:forEach items="${result.leaveTypeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.description}</td><td>${item.detailDescription}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.salaryGradeList}">
<section><h3>工资等级</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>名称</th><th>详细描述</th></tr>	<c:forEach items="${result.salaryGradeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.name}</td><td>${item.detailDescription}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.interviewTypeList}">
<section><h3>面试类型</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>描述</th><th>详细描述</th></tr>	<c:forEach items="${result.interviewTypeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.description}</td><td>${item.detailDescription}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.trainingCourseTypeList}">
<section><h3>培训课程类型</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>名称</th><th>描述</th></tr>	<c:forEach items="${result.trainingCourseTypeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.name}</td><td>${item.description}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.publicHolidayList}">
<section><h3>公共假日</h3>
<table><tr>
<tr>
<th>ID</th><th>代码</th><th>公司</th><th>名称</th><th>描述</th></tr>	<c:forEach items="${result.publicHolidayList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.code}</td><td>${item.company.displayName}</td><td>${item.name}</td><td>${item.description}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.employeeList}">
	<c:forEach items="${result.employeeList}" var="item">
<section><h3>员工(${item.id})</h3><table >
<tr><td class='th'>头衔</td><td >${item.title}</td><td class='th'>部门</td><td >${item.department.displayName}</td></tr><tr><td class='th'>姓</td><td >${item.familyName}</td><td class='th'>名</td><td >${item.givenName}</td></tr><tr><td class='th'>电子邮件</td><td >${item.email}</td><td class='th'>城市</td><td >${item.city}</td></tr><tr><td class='th'>地址</td><td >${item.address}</td><td class='th'>手机</td><td >${item.cellPhone}</td></tr><tr><td class='th'>职业</td><td >${item.occupation.displayName}</td><td class='th'>负责</td><td >${item.responsibleFor.displayName}</td></tr><tr><td class='th'>目前工资等级</td><td >${item.currentSalaryGrade.displayName}</td><td class='th'>工资账户</td><td >${item.salaryAccount}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.instructorList}">
	<c:forEach items="${result.instructorList}" var="item">
<section><h3>讲师(${item.id})</h3><table >
<tr><td class='th'>头衔</td><td >${item.title}</td><td class='th'>姓</td><td >${item.familyName}</td></tr><tr><td class='th'>名</td><td >${item.givenName}</td><td class='th'>手机</td><td >${item.cellPhone}</td></tr><tr><td class='th'>电子邮件</td><td >${item.email}</td><td class='th'>介绍</td><td >${item.introduction}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.companyTrainingList}">
	<c:forEach items="${result.companyTrainingList}" var="item">
<section><h3>公司培训(${item.id})</h3><table >
<tr><td class='th'>头衔</td><td >${item.title}</td><td class='th'>讲师</td><td >${item.instructor.displayName}</td></tr><tr><td class='th'>培训课程类型</td><td >${item.trainingCourseType.displayName}</td><td class='th'>时间开始</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${item.timeStart}" /></td></tr><tr><td class='th'>持续时间</td><td >${item.durationHours}</td><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></table>
</section>
</c:forEach></c:if></section>
