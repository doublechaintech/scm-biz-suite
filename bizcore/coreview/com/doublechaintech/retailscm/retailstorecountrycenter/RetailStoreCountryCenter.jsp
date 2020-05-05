<%@ page import='java.util.*,com.doublechaintech.retailscm.*,com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter'%>

<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<!DOCTYPE html>
<html lang="en" slick-uniqueid="3"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${baseURL}/" />    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>  ${userContext.localeMap['@system_name']} </title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">
 	<link href="./bootstrap/jquery-ui.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./bootstrap/dashboard.css" rel="stylesheet">
    <link href="./bootstrap/font-awesome.min.css" rel="stylesheet">
   
   

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./bootstrap/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 <style type="text/css">* {
 text-shadow: transparent 0px 0px 0px, rgba(0,0,0,0.68) 0px 0px 0px !important; 
}

</style>


</head>

  <body >


    <div class="container-fluid">
      <div class="row">
      
        <div class="col-xs-12 col-sm-12  col-md-12  main">
          
          <div class="table-responsive" id="content">
          <!-- real content -->

<c:set var="ownerBeanName" value="retailStoreCountryCenter" scope="request"/>
<c:set var="ownerClassName" value="RetailStoreCountryCenter" scope="request"/>




<div id="msg"></div>

<div class="row">

	<div class="col-xs-12 col-md-12">
			    <c:if test="${not empty result.errorMessageList}" >
    <ul>
    	<c:forEach var="item" items="${result.errorMessageList}">
    		
    		<div class="alert alert-success">
   ${item.sourcePosition} ${item.body}
</div>
    	</c:forEach>
    	</ul>
    </c:if>
</div>



</div> <!--<div class="row">-->

<div class="row">
	
</div>

<div class="row">
	
	<div class="col-xs-12 col-md-12">

	<ul class="nav nav-tabs" id="navi-tabs">
	  <li class="active"><a data-toggle="tab" href="#summary" class="disabled"><i class="fa  fa-home"></i> ${userContext.localeMap['@summary']}</a></li>
	 
	<% RetailStoreCountryCenter result = (RetailStoreCountryCenter)request.getAttribute("result");  %>
			<li><a data-toggle="tab" href="#catalogList" class="disabled"> ${userContext.localeMap['catalog']}</a></li>
			<li><a data-toggle="tab" href="#retailStoreProvinceCenterList" class="disabled"> ${userContext.localeMap['retail_store_province_center']}</a></li>
			<li><a data-toggle="tab" href="#retailStoreList" class="disabled"> ${userContext.localeMap['retail_store']}</a></li>
			<li><a data-toggle="tab" href="#retailStoreMemberList" class="disabled"> ${userContext.localeMap['retail_store_member']}</a></li>
			<li><a data-toggle="tab" href="#goodsSupplierList" class="disabled"> ${userContext.localeMap['goods_supplier']}</a></li>
			<li><a data-toggle="tab" href="#supplyOrderList" class="disabled"> ${userContext.localeMap['supply_order']}</a></li>
			<li><a data-toggle="tab" href="#retailStoreOrderList" class="disabled"> ${userContext.localeMap['retail_store_order']}</a></li>
			<li><a data-toggle="tab" href="#warehouseList" class="disabled"> ${userContext.localeMap['warehouse']}</a></li>
			<li><a data-toggle="tab" href="#transportFleetList" class="disabled"> ${userContext.localeMap['transport_fleet']}</a></li>
			<li><a data-toggle="tab" href="#accountSetList" class="disabled"> ${userContext.localeMap['account_set']}</a></li>
			<li><a data-toggle="tab" href="#levelOneDepartmentList" class="disabled"> ${userContext.localeMap['level_one_department']}</a></li>
			<li><a data-toggle="tab" href="#skillTypeList" class="disabled"> ${userContext.localeMap['skill_type']}</a></li>
			<li><a data-toggle="tab" href="#responsibilityTypeList" class="disabled"> ${userContext.localeMap['responsibility_type']}</a></li>
			<li><a data-toggle="tab" href="#terminationReasonList" class="disabled"> ${userContext.localeMap['termination_reason']}</a></li>
			<li><a data-toggle="tab" href="#terminationTypeList" class="disabled"> ${userContext.localeMap['termination_type']}</a></li>
			<li><a data-toggle="tab" href="#occupationTypeList" class="disabled"> ${userContext.localeMap['occupation_type']}</a></li>
			<li><a data-toggle="tab" href="#leaveTypeList" class="disabled"> ${userContext.localeMap['leave_type']}</a></li>
			<li><a data-toggle="tab" href="#salaryGradeList" class="disabled"> ${userContext.localeMap['salary_grade']}</a></li>
			<li><a data-toggle="tab" href="#interviewTypeList" class="disabled"> ${userContext.localeMap['interview_type']}</a></li>
			<li><a data-toggle="tab" href="#trainingCourseTypeList" class="disabled"> ${userContext.localeMap['training_course_type']}</a></li>
			<li><a data-toggle="tab" href="#publicHolidayList" class="disabled"> ${userContext.localeMap['public_holiday']}</a></li>
			<li><a data-toggle="tab" href="#employeeList" class="disabled"> ${userContext.localeMap['employee']}</a></li>
			<li><a data-toggle="tab" href="#instructorList" class="disabled"> ${userContext.localeMap['instructor']}</a></li>
			<li><a data-toggle="tab" href="#companyTrainingList" class="disabled"> ${userContext.localeMap['company_training']}</a></li>
 
	</ul>
	</div>
</div>
<div class="tab-content"  id='tab-content'>
<div id="summary" class="tab-pane fade in active">
<div class="row">
	
	<div class="col-xs-12 col-md-12">
	
	</div>
</div>

<div class="row" desc="show parent objects">
	
	   
	<c:set var="retailStoreCountryCenter" value="${ result}" scope="request" />
<sky:include page="com/doublechaintech/retailscm/retailstorecountrycenter/RetailStoreCountryCenter$Summary.jsp" />

	
</div>

	
	

	







	





	</div><!-- end of <div id="summary" class="tab-pane fade in active">-->

	

		<c:if test='${not empty userContext.accessTokens["catalogList"] or ignoreListAccessControl}'>
		<c:set var="catalogList" value="${result.catalogList}" scope="request"/>
		<c:set var="catalogListName" value="catalogList" scope="request"/>
		<div id="catalogList" class="tab-pane fade sublist" refer-name="owner">
			<sky:include page="com/doublechaintech/retailscm/catalog/Catalog$List.jsp"
					referName="owner"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["retailStoreProvinceCenterList"] or ignoreListAccessControl}'>
		<c:set var="retailStoreProvinceCenterList" value="${result.retailStoreProvinceCenterList}" scope="request"/>
		<c:set var="retailStoreProvinceCenterListName" value="retailStoreProvinceCenterList" scope="request"/>
		<div id="retailStoreProvinceCenterList" class="tab-pane fade sublist" refer-name="country">
			<sky:include page="com/doublechaintech/retailscm/retailstoreprovincecenter/RetailStoreProvinceCenter$List.jsp"
					referName="country"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["retailStoreList"] or ignoreListAccessControl}'>
		<c:set var="retailStoreList" value="${result.retailStoreList}" scope="request"/>
		<c:set var="retailStoreListName" value="retailStoreList" scope="request"/>
		<div id="retailStoreList" class="tab-pane fade sublist" refer-name="retail_store_country_center">
			<sky:include page="com/doublechaintech/retailscm/retailstore/RetailStore$List.jsp"
					referName="retailStoreCountryCenter"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["retailStoreMemberList"] or ignoreListAccessControl}'>
		<c:set var="retailStoreMemberList" value="${result.retailStoreMemberList}" scope="request"/>
		<c:set var="retailStoreMemberListName" value="retailStoreMemberList" scope="request"/>
		<div id="retailStoreMemberList" class="tab-pane fade sublist" refer-name="owner">
			<sky:include page="com/doublechaintech/retailscm/retailstoremember/RetailStoreMember$List.jsp"
					referName="owner"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["goodsSupplierList"] or ignoreListAccessControl}'>
		<c:set var="goodsSupplierList" value="${result.goodsSupplierList}" scope="request"/>
		<c:set var="goodsSupplierListName" value="goodsSupplierList" scope="request"/>
		<div id="goodsSupplierList" class="tab-pane fade sublist" refer-name="belong_to">
			<sky:include page="com/doublechaintech/retailscm/goodssupplier/GoodsSupplier$List.jsp"
					referName="belongTo"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["supplyOrderList"] or ignoreListAccessControl}'>
		<c:set var="supplyOrderList" value="${result.supplyOrderList}" scope="request"/>
		<c:set var="supplyOrderListName" value="supplyOrderList" scope="request"/>
		<div id="supplyOrderList" class="tab-pane fade sublist" refer-name="buyer">
			<sky:include page="com/doublechaintech/retailscm/supplyorder/SupplyOrder$List.jsp"
					referName="buyer"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["retailStoreOrderList"] or ignoreListAccessControl}'>
		<c:set var="retailStoreOrderList" value="${result.retailStoreOrderList}" scope="request"/>
		<c:set var="retailStoreOrderListName" value="retailStoreOrderList" scope="request"/>
		<div id="retailStoreOrderList" class="tab-pane fade sublist" refer-name="seller">
			<sky:include page="com/doublechaintech/retailscm/retailstoreorder/RetailStoreOrder$List.jsp"
					referName="seller"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["warehouseList"] or ignoreListAccessControl}'>
		<c:set var="warehouseList" value="${result.warehouseList}" scope="request"/>
		<c:set var="warehouseListName" value="warehouseList" scope="request"/>
		<div id="warehouseList" class="tab-pane fade sublist" refer-name="owner">
			<sky:include page="com/doublechaintech/retailscm/warehouse/Warehouse$List.jsp"
					referName="owner"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["transportFleetList"] or ignoreListAccessControl}'>
		<c:set var="transportFleetList" value="${result.transportFleetList}" scope="request"/>
		<c:set var="transportFleetListName" value="transportFleetList" scope="request"/>
		<div id="transportFleetList" class="tab-pane fade sublist" refer-name="owner">
			<sky:include page="com/doublechaintech/retailscm/transportfleet/TransportFleet$List.jsp"
					referName="owner"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["accountSetList"] or ignoreListAccessControl}'>
		<c:set var="accountSetList" value="${result.accountSetList}" scope="request"/>
		<c:set var="accountSetListName" value="accountSetList" scope="request"/>
		<div id="accountSetList" class="tab-pane fade sublist" refer-name="country_center">
			<sky:include page="com/doublechaintech/retailscm/accountset/AccountSet$List.jsp"
					referName="countryCenter"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["levelOneDepartmentList"] or ignoreListAccessControl}'>
		<c:set var="levelOneDepartmentList" value="${result.levelOneDepartmentList}" scope="request"/>
		<c:set var="levelOneDepartmentListName" value="levelOneDepartmentList" scope="request"/>
		<div id="levelOneDepartmentList" class="tab-pane fade sublist" refer-name="belongs_to">
			<sky:include page="com/doublechaintech/retailscm/levelonedepartment/LevelOneDepartment$List.jsp"
					referName="belongsTo"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["skillTypeList"] or ignoreListAccessControl}'>
		<c:set var="skillTypeList" value="${result.skillTypeList}" scope="request"/>
		<c:set var="skillTypeListName" value="skillTypeList" scope="request"/>
		<div id="skillTypeList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/skilltype/SkillType$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["responsibilityTypeList"] or ignoreListAccessControl}'>
		<c:set var="responsibilityTypeList" value="${result.responsibilityTypeList}" scope="request"/>
		<c:set var="responsibilityTypeListName" value="responsibilityTypeList" scope="request"/>
		<div id="responsibilityTypeList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/responsibilitytype/ResponsibilityType$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["terminationReasonList"] or ignoreListAccessControl}'>
		<c:set var="terminationReasonList" value="${result.terminationReasonList}" scope="request"/>
		<c:set var="terminationReasonListName" value="terminationReasonList" scope="request"/>
		<div id="terminationReasonList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/terminationreason/TerminationReason$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["terminationTypeList"] or ignoreListAccessControl}'>
		<c:set var="terminationTypeList" value="${result.terminationTypeList}" scope="request"/>
		<c:set var="terminationTypeListName" value="terminationTypeList" scope="request"/>
		<div id="terminationTypeList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/terminationtype/TerminationType$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["occupationTypeList"] or ignoreListAccessControl}'>
		<c:set var="occupationTypeList" value="${result.occupationTypeList}" scope="request"/>
		<c:set var="occupationTypeListName" value="occupationTypeList" scope="request"/>
		<div id="occupationTypeList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/occupationtype/OccupationType$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["leaveTypeList"] or ignoreListAccessControl}'>
		<c:set var="leaveTypeList" value="${result.leaveTypeList}" scope="request"/>
		<c:set var="leaveTypeListName" value="leaveTypeList" scope="request"/>
		<div id="leaveTypeList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/leavetype/LeaveType$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["salaryGradeList"] or ignoreListAccessControl}'>
		<c:set var="salaryGradeList" value="${result.salaryGradeList}" scope="request"/>
		<c:set var="salaryGradeListName" value="salaryGradeList" scope="request"/>
		<div id="salaryGradeList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/salarygrade/SalaryGrade$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["interviewTypeList"] or ignoreListAccessControl}'>
		<c:set var="interviewTypeList" value="${result.interviewTypeList}" scope="request"/>
		<c:set var="interviewTypeListName" value="interviewTypeList" scope="request"/>
		<div id="interviewTypeList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/interviewtype/InterviewType$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["trainingCourseTypeList"] or ignoreListAccessControl}'>
		<c:set var="trainingCourseTypeList" value="${result.trainingCourseTypeList}" scope="request"/>
		<c:set var="trainingCourseTypeListName" value="trainingCourseTypeList" scope="request"/>
		<div id="trainingCourseTypeList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/trainingcoursetype/TrainingCourseType$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["publicHolidayList"] or ignoreListAccessControl}'>
		<c:set var="publicHolidayList" value="${result.publicHolidayList}" scope="request"/>
		<c:set var="publicHolidayListName" value="publicHolidayList" scope="request"/>
		<div id="publicHolidayList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/publicholiday/PublicHoliday$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeList"] or ignoreListAccessControl}'>
		<c:set var="employeeList" value="${result.employeeList}" scope="request"/>
		<c:set var="employeeListName" value="employeeList" scope="request"/>
		<div id="employeeList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/employee/Employee$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["instructorList"] or ignoreListAccessControl}'>
		<c:set var="instructorList" value="${result.instructorList}" scope="request"/>
		<c:set var="instructorListName" value="instructorList" scope="request"/>
		<div id="instructorList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/instructor/Instructor$List.jsp"
					referName="company"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["companyTrainingList"] or ignoreListAccessControl}'>
		<c:set var="companyTrainingList" value="${result.companyTrainingList}" scope="request"/>
		<c:set var="companyTrainingListName" value="companyTrainingList" scope="request"/>
		<div id="companyTrainingList" class="tab-pane fade sublist" refer-name="company">
			<sky:include page="com/doublechaintech/retailscm/companytraining/CompanyTraining$List.jsp"
					referName="company"/>
		</div>
	</c:if>

	

</div><!--<div class="tab-content" style="padding-top: 10px">-->




 <!-- /real content -->
          
          
          </div>
        </div><!--  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        </div><!-- <div class="row"> -->
        </div>
        
  
<div id="footer">
  <div class="col-xs-12 navbar-inverse navbar-fixed-bottom">
  <div class="row" id="bottomNav">
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-home"></i><br/>${userContext.localeMap['@home_page']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>${userContext.localeMap['@message']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>${userContext.localeMap['@message']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/showlogin/">
    	<i class="glyphicon glyphicon-user"></i><br>${userContext.localeMap['@log_out']}</a>
    </div>
  </div>
  </div>
</div>   <!-- --><!-- /.footer -->
        
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./bootstrap/jquery.min.js"></script>
    <script src="./bootstrap/jquery-ui.min.js"></script>
    
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./bootstrap/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./bootstrap/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./bootstrap/ie10-viewport-bug-workaround.js"></script>
    <script src="./scripts/qrcode.js" type="text/javascript"></script>    
    <script>

 	var qrLocaleLabel = "${userContext.localeMap['@qr_code']}";
 	var scanQRTips = "${userContext.localeMap['@qr_scan_to_continue']}";
 	$("a[data-toggle='tab']").removeClass("disabled");
 	
	
</script>
     <script src="./scripts/common.js" type="text/javascript"></script>
     <script src="./bootstrap/bootstrap3-typeahead.js" type="text/javascript"></script>


</body></html>


