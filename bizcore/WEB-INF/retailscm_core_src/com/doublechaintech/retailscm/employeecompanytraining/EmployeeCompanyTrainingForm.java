package com.doublechaintech.retailscm.employeecompanytraining;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EmployeeCompanyTrainingForm extends BaseForm {
	
	
	public EmployeeCompanyTrainingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EmployeeCompanyTrainingForm employeeCompanyTrainingIdField(String parameterName, String initValue){
		FormField field = idFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeCompanyTrainingForm employeeCompanyTrainingIdField(String initValue){
		return employeeCompanyTrainingIdField("employeeCompanyTrainingId",initValue);
	}
	public EmployeeCompanyTrainingForm employeeCompanyTrainingIdField(){
		return employeeCompanyTrainingIdField("employeeCompanyTrainingId","");
	}


	public EmployeeCompanyTrainingForm employeeIdField(String parameterName, String initValue){
		FormField field = employeeIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeCompanyTrainingForm employeeIdField(String initValue){
		return employeeIdField("employeeId",initValue);
	}
	public EmployeeCompanyTrainingForm employeeIdField(){
		return employeeIdField("employeeId","");
	}


	public EmployeeCompanyTrainingForm trainingIdField(String parameterName, String initValue){
		FormField field = trainingIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeCompanyTrainingForm trainingIdField(String initValue){
		return trainingIdField("trainingId",initValue);
	}
	public EmployeeCompanyTrainingForm trainingIdField(){
		return trainingIdField("trainingId","");
	}


	public EmployeeCompanyTrainingForm scoringIdField(String parameterName, String initValue){
		FormField field = scoringIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeCompanyTrainingForm scoringIdField(String initValue){
		return scoringIdField("scoringId",initValue);
	}
	public EmployeeCompanyTrainingForm scoringIdField(){
		return scoringIdField("scoringId","");
	}


	public EmployeeCompanyTrainingForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeCompanyTrainingForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public EmployeeCompanyTrainingForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public EmployeeCompanyTrainingForm employeeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm employeeIdFieldOfEmployee(String initValue){
		return employeeIdFieldOfEmployee("employeeId",initValue);
	}
	public EmployeeCompanyTrainingForm employeeIdFieldOfEmployee(){
		return employeeIdFieldOfEmployee("employeeId","");
	}


	public EmployeeCompanyTrainingForm companyIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm companyIdFieldOfEmployee(String initValue){
		return companyIdFieldOfEmployee("companyId",initValue);
	}
	public EmployeeCompanyTrainingForm companyIdFieldOfEmployee(){
		return companyIdFieldOfEmployee("companyId","");
	}


	public EmployeeCompanyTrainingForm titleFieldOfEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm titleFieldOfEmployee(String initValue){
		return titleFieldOfEmployee("title",initValue);
	}
	public EmployeeCompanyTrainingForm titleFieldOfEmployee(){
		return titleFieldOfEmployee("title","");
	}


	public EmployeeCompanyTrainingForm departmentIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm departmentIdFieldOfEmployee(String initValue){
		return departmentIdFieldOfEmployee("departmentId",initValue);
	}
	public EmployeeCompanyTrainingForm departmentIdFieldOfEmployee(){
		return departmentIdFieldOfEmployee("departmentId","");
	}


	public EmployeeCompanyTrainingForm familyNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm familyNameFieldOfEmployee(String initValue){
		return familyNameFieldOfEmployee("familyName",initValue);
	}
	public EmployeeCompanyTrainingForm familyNameFieldOfEmployee(){
		return familyNameFieldOfEmployee("familyName","");
	}


	public EmployeeCompanyTrainingForm givenNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm givenNameFieldOfEmployee(String initValue){
		return givenNameFieldOfEmployee("givenName",initValue);
	}
	public EmployeeCompanyTrainingForm givenNameFieldOfEmployee(){
		return givenNameFieldOfEmployee("givenName","");
	}


	public EmployeeCompanyTrainingForm emailFieldOfEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm emailFieldOfEmployee(String initValue){
		return emailFieldOfEmployee("email",initValue);
	}
	public EmployeeCompanyTrainingForm emailFieldOfEmployee(){
		return emailFieldOfEmployee("email","");
	}


	public EmployeeCompanyTrainingForm cityFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm cityFieldOfEmployee(String initValue){
		return cityFieldOfEmployee("city",initValue);
	}
	public EmployeeCompanyTrainingForm cityFieldOfEmployee(){
		return cityFieldOfEmployee("city","");
	}


	public EmployeeCompanyTrainingForm addressFieldOfEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm addressFieldOfEmployee(String initValue){
		return addressFieldOfEmployee("address",initValue);
	}
	public EmployeeCompanyTrainingForm addressFieldOfEmployee(){
		return addressFieldOfEmployee("address","");
	}


	public EmployeeCompanyTrainingForm cellPhoneFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm cellPhoneFieldOfEmployee(String initValue){
		return cellPhoneFieldOfEmployee("cellPhone",initValue);
	}
	public EmployeeCompanyTrainingForm cellPhoneFieldOfEmployee(){
		return cellPhoneFieldOfEmployee("cellPhone","");
	}


	public EmployeeCompanyTrainingForm occupationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm occupationIdFieldOfEmployee(String initValue){
		return occupationIdFieldOfEmployee("occupationId",initValue);
	}
	public EmployeeCompanyTrainingForm occupationIdFieldOfEmployee(){
		return occupationIdFieldOfEmployee("occupationId","");
	}


	public EmployeeCompanyTrainingForm responsibleForIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm responsibleForIdFieldOfEmployee(String initValue){
		return responsibleForIdFieldOfEmployee("responsibleForId",initValue);
	}
	public EmployeeCompanyTrainingForm responsibleForIdFieldOfEmployee(){
		return responsibleForIdFieldOfEmployee("responsibleForId","");
	}


	public EmployeeCompanyTrainingForm currentSalaryGradeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm currentSalaryGradeIdFieldOfEmployee(String initValue){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId",initValue);
	}
	public EmployeeCompanyTrainingForm currentSalaryGradeIdFieldOfEmployee(){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId","");
	}


	public EmployeeCompanyTrainingForm salaryAccountFieldOfEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm salaryAccountFieldOfEmployee(String initValue){
		return salaryAccountFieldOfEmployee("salaryAccount",initValue);
	}
	public EmployeeCompanyTrainingForm salaryAccountFieldOfEmployee(){
		return salaryAccountFieldOfEmployee("salaryAccount","");
	}


	public EmployeeCompanyTrainingForm jobApplicationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm jobApplicationIdFieldOfEmployee(String initValue){
		return jobApplicationIdFieldOfEmployee("jobApplicationId",initValue);
	}
	public EmployeeCompanyTrainingForm jobApplicationIdFieldOfEmployee(){
		return jobApplicationIdFieldOfEmployee("jobApplicationId","");
	}


	public EmployeeCompanyTrainingForm professionInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm professionInterviewIdFieldOfEmployee(String initValue){
		return professionInterviewIdFieldOfEmployee("professionInterviewId",initValue);
	}
	public EmployeeCompanyTrainingForm professionInterviewIdFieldOfEmployee(){
		return professionInterviewIdFieldOfEmployee("professionInterviewId","");
	}


	public EmployeeCompanyTrainingForm hrInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm hrInterviewIdFieldOfEmployee(String initValue){
		return hrInterviewIdFieldOfEmployee("hrInterviewId",initValue);
	}
	public EmployeeCompanyTrainingForm hrInterviewIdFieldOfEmployee(){
		return hrInterviewIdFieldOfEmployee("hrInterviewId","");
	}


	public EmployeeCompanyTrainingForm offerApprovalIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm offerApprovalIdFieldOfEmployee(String initValue){
		return offerApprovalIdFieldOfEmployee("offerApprovalId",initValue);
	}
	public EmployeeCompanyTrainingForm offerApprovalIdFieldOfEmployee(){
		return offerApprovalIdFieldOfEmployee("offerApprovalId","");
	}


	public EmployeeCompanyTrainingForm offerAcceptanceIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm offerAcceptanceIdFieldOfEmployee(String initValue){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId",initValue);
	}
	public EmployeeCompanyTrainingForm offerAcceptanceIdFieldOfEmployee(){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId","");
	}


	public EmployeeCompanyTrainingForm employeeBoardingIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm employeeBoardingIdFieldOfEmployee(String initValue){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId",initValue);
	}
	public EmployeeCompanyTrainingForm employeeBoardingIdFieldOfEmployee(){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId","");
	}


	public EmployeeCompanyTrainingForm terminationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm terminationIdFieldOfEmployee(String initValue){
		return terminationIdFieldOfEmployee("terminationId",initValue);
	}
	public EmployeeCompanyTrainingForm terminationIdFieldOfEmployee(){
		return terminationIdFieldOfEmployee("terminationId","");
	}


	public EmployeeCompanyTrainingForm lastUpdateTimeFieldOfEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm lastUpdateTimeFieldOfEmployee(String initValue){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime",initValue);
	}
	public EmployeeCompanyTrainingForm lastUpdateTimeFieldOfEmployee(){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime","");
	}


	public EmployeeCompanyTrainingForm currentStatusFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm currentStatusFieldOfEmployee(String initValue){
		return currentStatusFieldOfEmployee("currentStatus",initValue);
	}
	public EmployeeCompanyTrainingForm currentStatusFieldOfEmployee(){
		return currentStatusFieldOfEmployee("currentStatus","");
	}


	public EmployeeCompanyTrainingForm companyTrainingIdFieldOfCompanyTraining(String parameterName, String initValue){
		FormField field =  idFromCompanyTraining(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm companyTrainingIdFieldOfCompanyTraining(String initValue){
		return companyTrainingIdFieldOfCompanyTraining("companyTrainingId",initValue);
	}
	public EmployeeCompanyTrainingForm companyTrainingIdFieldOfCompanyTraining(){
		return companyTrainingIdFieldOfCompanyTraining("companyTrainingId","");
	}


	public EmployeeCompanyTrainingForm titleFieldOfCompanyTraining(String parameterName, String initValue){
		FormField field =  titleFromCompanyTraining(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm titleFieldOfCompanyTraining(String initValue){
		return titleFieldOfCompanyTraining("title",initValue);
	}
	public EmployeeCompanyTrainingForm titleFieldOfCompanyTraining(){
		return titleFieldOfCompanyTraining("title","");
	}


	public EmployeeCompanyTrainingForm companyIdFieldOfCompanyTraining(String parameterName, String initValue){
		FormField field =  companyIdFromCompanyTraining(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm companyIdFieldOfCompanyTraining(String initValue){
		return companyIdFieldOfCompanyTraining("companyId",initValue);
	}
	public EmployeeCompanyTrainingForm companyIdFieldOfCompanyTraining(){
		return companyIdFieldOfCompanyTraining("companyId","");
	}


	public EmployeeCompanyTrainingForm instructorIdFieldOfCompanyTraining(String parameterName, String initValue){
		FormField field =  instructorIdFromCompanyTraining(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm instructorIdFieldOfCompanyTraining(String initValue){
		return instructorIdFieldOfCompanyTraining("instructorId",initValue);
	}
	public EmployeeCompanyTrainingForm instructorIdFieldOfCompanyTraining(){
		return instructorIdFieldOfCompanyTraining("instructorId","");
	}


	public EmployeeCompanyTrainingForm trainingCourseTypeIdFieldOfCompanyTraining(String parameterName, String initValue){
		FormField field =  trainingCourseTypeIdFromCompanyTraining(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm trainingCourseTypeIdFieldOfCompanyTraining(String initValue){
		return trainingCourseTypeIdFieldOfCompanyTraining("trainingCourseTypeId",initValue);
	}
	public EmployeeCompanyTrainingForm trainingCourseTypeIdFieldOfCompanyTraining(){
		return trainingCourseTypeIdFieldOfCompanyTraining("trainingCourseTypeId","");
	}


	public EmployeeCompanyTrainingForm timeStartFieldOfCompanyTraining(String parameterName, String initValue){
		FormField field =  timeStartFromCompanyTraining(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm timeStartFieldOfCompanyTraining(String initValue){
		return timeStartFieldOfCompanyTraining("timeStart",initValue);
	}
	public EmployeeCompanyTrainingForm timeStartFieldOfCompanyTraining(){
		return timeStartFieldOfCompanyTraining("timeStart","");
	}


	public EmployeeCompanyTrainingForm durationHoursFieldOfCompanyTraining(String parameterName, String initValue){
		FormField field =  durationHoursFromCompanyTraining(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm durationHoursFieldOfCompanyTraining(String initValue){
		return durationHoursFieldOfCompanyTraining("durationHours",initValue);
	}
	public EmployeeCompanyTrainingForm durationHoursFieldOfCompanyTraining(){
		return durationHoursFieldOfCompanyTraining("durationHours","");
	}


	public EmployeeCompanyTrainingForm lastUpdateTimeFieldOfCompanyTraining(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromCompanyTraining(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm lastUpdateTimeFieldOfCompanyTraining(String initValue){
		return lastUpdateTimeFieldOfCompanyTraining("lastUpdateTime",initValue);
	}
	public EmployeeCompanyTrainingForm lastUpdateTimeFieldOfCompanyTraining(){
		return lastUpdateTimeFieldOfCompanyTraining("lastUpdateTime","");
	}


	public EmployeeCompanyTrainingForm scoringIdFieldOfScoring(String parameterName, String initValue){
		FormField field =  idFromScoring(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm scoringIdFieldOfScoring(String initValue){
		return scoringIdFieldOfScoring("scoringId",initValue);
	}
	public EmployeeCompanyTrainingForm scoringIdFieldOfScoring(){
		return scoringIdFieldOfScoring("scoringId","");
	}


	public EmployeeCompanyTrainingForm scoredByFieldOfScoring(String parameterName, String initValue){
		FormField field =  scoredByFromScoring(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm scoredByFieldOfScoring(String initValue){
		return scoredByFieldOfScoring("scoredBy",initValue);
	}
	public EmployeeCompanyTrainingForm scoredByFieldOfScoring(){
		return scoredByFieldOfScoring("scoredBy","");
	}


	public EmployeeCompanyTrainingForm scoreFieldOfScoring(String parameterName, String initValue){
		FormField field =  scoreFromScoring(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm scoreFieldOfScoring(String initValue){
		return scoreFieldOfScoring("score",initValue);
	}
	public EmployeeCompanyTrainingForm scoreFieldOfScoring(){
		return scoreFieldOfScoring("score","");
	}


	public EmployeeCompanyTrainingForm commentFieldOfScoring(String parameterName, String initValue){
		FormField field =  commentFromScoring(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeCompanyTrainingForm commentFieldOfScoring(String initValue){
		return commentFieldOfScoring("comment",initValue);
	}
	public EmployeeCompanyTrainingForm commentFieldOfScoring(){
		return commentFieldOfScoring("comment","");
	}

	


	

	
 	public EmployeeCompanyTrainingForm transferToAnotherEmployeeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherEmployee/employeeCompanyTrainingId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeCompanyTrainingForm transferToAnotherTrainingAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherTraining/employeeCompanyTrainingId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeCompanyTrainingForm  scoreAction(){
		FormAction action = new FormAction();
		action.setLabel("分数");
		action.setLocaleKey("employee_company_training.score");
		action.setUrl("employeeCompanyTrainingManager/score/employeeCompanyTrainingId/scoredBy/score/comment/");
		this.addFormAction(action);
		return this;
	}

	public EmployeeCompanyTrainingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


