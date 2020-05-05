<%@ page import='java.util.*,com.doublechaintech.retailscm.*,com.doublechaintech.retailscm.employee.Employee'%>

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

<c:set var="ownerBeanName" value="employee" scope="request"/>
<c:set var="ownerClassName" value="Employee" scope="request"/>




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
	 
	<% Employee result = (Employee)request.getAttribute("result");  %>
			<li><a data-toggle="tab" href="#employeeCompanyTrainingList" class="disabled"> ${userContext.localeMap['employee_company_training']}</a></li>
			<li><a data-toggle="tab" href="#employeeSkillList" class="disabled"> ${userContext.localeMap['employee_skill']}</a></li>
			<li><a data-toggle="tab" href="#employeePerformanceList" class="disabled"> ${userContext.localeMap['employee_performance']}</a></li>
			<li><a data-toggle="tab" href="#employeeWorkExperienceList" class="disabled"> ${userContext.localeMap['employee_work_experience']}</a></li>
			<li><a data-toggle="tab" href="#employeeLeaveList" class="disabled"> ${userContext.localeMap['employee_leave']}</a></li>
			<li><a data-toggle="tab" href="#employeeInterviewList" class="disabled"> ${userContext.localeMap['employee_interview']}</a></li>
			<li><a data-toggle="tab" href="#employeeAttendanceList" class="disabled"> ${userContext.localeMap['employee_attendance']}</a></li>
			<li><a data-toggle="tab" href="#employeeQualifierList" class="disabled"> ${userContext.localeMap['employee_qualifier']}</a></li>
			<li><a data-toggle="tab" href="#employeeEducationList" class="disabled"> ${userContext.localeMap['employee_education']}</a></li>
			<li><a data-toggle="tab" href="#employeeAwardList" class="disabled"> ${userContext.localeMap['employee_award']}</a></li>
			<li><a data-toggle="tab" href="#employeeSalarySheetList" class="disabled"> ${userContext.localeMap['employee_salary_sheet']}</a></li>
			<li><a data-toggle="tab" href="#payingOffList" class="disabled"> ${userContext.localeMap['paying_off']}</a></li>
 
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
	
	   
	<c:set var="employee" value="${ result}" scope="request" />
<sky:include page="com/doublechaintech/retailscm/employee/Employee$Summary.jsp" />

	
</div>

	
	

	<div class="row">
<c:set var="retailStoreCountryCenter" value="${ result.company}" scope="request" />
<c:set var="referName" value="(company)" scope="request" />
<sky:include page="com/doublechaintech/retailscm/retailstorecountrycenter/RetailStoreCountryCenter$Info.jsp" />

<c:set var="levelThreeDepartment" value="${ result.department}" scope="request" />
<c:set var="referName" value="(department)" scope="request" />
<sky:include page="com/doublechaintech/retailscm/levelthreedepartment/LevelThreeDepartment$Info.jsp" />

<c:set var="occupationType" value="${ result.occupation}" scope="request" />
<c:set var="referName" value="(occupation)" scope="request" />
<sky:include page="com/doublechaintech/retailscm/occupationtype/OccupationType$Info.jsp" />

<c:set var="responsibilityType" value="${ result.responsibleFor}" scope="request" />
<c:set var="referName" value="(responsibleFor)" scope="request" />
<sky:include page="com/doublechaintech/retailscm/responsibilitytype/ResponsibilityType$Info.jsp" />

<c:set var="salaryGrade" value="${ result.currentSalaryGrade}" scope="request" />
<c:set var="referName" value="(currentSalaryGrade)" scope="request" />
<sky:include page="com/doublechaintech/retailscm/salarygrade/SalaryGrade$Info.jsp" />

</div>








	





	</div><!-- end of <div id="summary" class="tab-pane fade in active">-->

	

		<c:if test='${not empty userContext.accessTokens["employeeCompanyTrainingList"] or ignoreListAccessControl}'>
		<c:set var="employeeCompanyTrainingList" value="${result.employeeCompanyTrainingList}" scope="request"/>
		<c:set var="employeeCompanyTrainingListName" value="employeeCompanyTrainingList" scope="request"/>
		<div id="employeeCompanyTrainingList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeecompanytraining/EmployeeCompanyTraining$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeSkillList"] or ignoreListAccessControl}'>
		<c:set var="employeeSkillList" value="${result.employeeSkillList}" scope="request"/>
		<c:set var="employeeSkillListName" value="employeeSkillList" scope="request"/>
		<div id="employeeSkillList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeeskill/EmployeeSkill$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeePerformanceList"] or ignoreListAccessControl}'>
		<c:set var="employeePerformanceList" value="${result.employeePerformanceList}" scope="request"/>
		<c:set var="employeePerformanceListName" value="employeePerformanceList" scope="request"/>
		<div id="employeePerformanceList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeeperformance/EmployeePerformance$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeWorkExperienceList"] or ignoreListAccessControl}'>
		<c:set var="employeeWorkExperienceList" value="${result.employeeWorkExperienceList}" scope="request"/>
		<c:set var="employeeWorkExperienceListName" value="employeeWorkExperienceList" scope="request"/>
		<div id="employeeWorkExperienceList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeeworkexperience/EmployeeWorkExperience$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeLeaveList"] or ignoreListAccessControl}'>
		<c:set var="employeeLeaveList" value="${result.employeeLeaveList}" scope="request"/>
		<c:set var="employeeLeaveListName" value="employeeLeaveList" scope="request"/>
		<div id="employeeLeaveList" class="tab-pane fade sublist" refer-name="who">
			<sky:include page="com/doublechaintech/retailscm/employeeleave/EmployeeLeave$List.jsp"
					referName="who"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeInterviewList"] or ignoreListAccessControl}'>
		<c:set var="employeeInterviewList" value="${result.employeeInterviewList}" scope="request"/>
		<c:set var="employeeInterviewListName" value="employeeInterviewList" scope="request"/>
		<div id="employeeInterviewList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeeinterview/EmployeeInterview$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeAttendanceList"] or ignoreListAccessControl}'>
		<c:set var="employeeAttendanceList" value="${result.employeeAttendanceList}" scope="request"/>
		<c:set var="employeeAttendanceListName" value="employeeAttendanceList" scope="request"/>
		<div id="employeeAttendanceList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeeattendance/EmployeeAttendance$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeQualifierList"] or ignoreListAccessControl}'>
		<c:set var="employeeQualifierList" value="${result.employeeQualifierList}" scope="request"/>
		<c:set var="employeeQualifierListName" value="employeeQualifierList" scope="request"/>
		<div id="employeeQualifierList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeequalifier/EmployeeQualifier$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeEducationList"] or ignoreListAccessControl}'>
		<c:set var="employeeEducationList" value="${result.employeeEducationList}" scope="request"/>
		<c:set var="employeeEducationListName" value="employeeEducationList" scope="request"/>
		<div id="employeeEducationList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeeeducation/EmployeeEducation$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeAwardList"] or ignoreListAccessControl}'>
		<c:set var="employeeAwardList" value="${result.employeeAwardList}" scope="request"/>
		<c:set var="employeeAwardListName" value="employeeAwardList" scope="request"/>
		<div id="employeeAwardList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeeaward/EmployeeAward$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeSalarySheetList"] or ignoreListAccessControl}'>
		<c:set var="employeeSalarySheetList" value="${result.employeeSalarySheetList}" scope="request"/>
		<c:set var="employeeSalarySheetListName" value="employeeSalarySheetList" scope="request"/>
		<div id="employeeSalarySheetList" class="tab-pane fade sublist" refer-name="employee">
			<sky:include page="com/doublechaintech/retailscm/employeesalarysheet/EmployeeSalarySheet$List.jsp"
					referName="employee"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["payingOffList"] or ignoreListAccessControl}'>
		<c:set var="payingOffList" value="${result.payingOffList}" scope="request"/>
		<c:set var="payingOffListName" value="payingOffList" scope="request"/>
		<div id="payingOffList" class="tab-pane fade sublist" refer-name="paid_for">
			<sky:include page="com/doublechaintech/retailscm/payingoff/PayingOff$List.jsp"
					referName="paidFor"/>
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


