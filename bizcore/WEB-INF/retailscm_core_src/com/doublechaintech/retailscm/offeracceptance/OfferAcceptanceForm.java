package com.doublechaintech.retailscm.offeracceptance;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class OfferAcceptanceForm extends BaseForm {
	
	
	public OfferAcceptanceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public OfferAcceptanceForm offerAcceptanceIdField(String parameterName, String initValue){
		FormField field = idFromOfferAcceptance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm offerAcceptanceIdField(String initValue){
		return offerAcceptanceIdField("offerAcceptanceId",initValue);
	}
	public OfferAcceptanceForm offerAcceptanceIdField(){
		return offerAcceptanceIdField("offerAcceptanceId","");
	}


	public OfferAcceptanceForm whoField(String parameterName, String initValue){
		FormField field = whoFromOfferAcceptance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public OfferAcceptanceForm whoField(){
		return whoField("who","");
	}


	public OfferAcceptanceForm acceptTimeField(String parameterName, String initValue){
		FormField field = acceptTimeFromOfferAcceptance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm acceptTimeField(String initValue){
		return acceptTimeField("acceptTime",initValue);
	}
	public OfferAcceptanceForm acceptTimeField(){
		return acceptTimeField("acceptTime","");
	}


	public OfferAcceptanceForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromOfferAcceptance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public OfferAcceptanceForm commentsField(){
		return commentsField("comments","");
	}

	
	

	



	public OfferAcceptanceForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public OfferAcceptanceForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public OfferAcceptanceForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public OfferAcceptanceForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public OfferAcceptanceForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public OfferAcceptanceForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public OfferAcceptanceForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public OfferAcceptanceForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public OfferAcceptanceForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public OfferAcceptanceForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public OfferAcceptanceForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public OfferAcceptanceForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public OfferAcceptanceForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public OfferAcceptanceForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public OfferAcceptanceForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public OfferAcceptanceForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public OfferAcceptanceForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public OfferAcceptanceForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public OfferAcceptanceForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public OfferAcceptanceForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public OfferAcceptanceForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public OfferAcceptanceForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public OfferAcceptanceForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public OfferAcceptanceForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public OfferAcceptanceForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public OfferAcceptanceForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public OfferAcceptanceForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public OfferAcceptanceForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public OfferAcceptanceForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public OfferAcceptanceForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public OfferAcceptanceForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public OfferAcceptanceForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public OfferAcceptanceForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public OfferAcceptanceForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public OfferAcceptanceForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public OfferAcceptanceForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public OfferAcceptanceForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public OfferAcceptanceForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public OfferAcceptanceForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public OfferAcceptanceForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public OfferAcceptanceForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public OfferAcceptanceForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public OfferAcceptanceForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public OfferAcceptanceForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public OfferAcceptanceForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OfferAcceptanceForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public OfferAcceptanceForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}

	



	public OfferAcceptanceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


