package com.doublechaintech.retailscm.stockcountissuetrack;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class StockCountIssueTrackForm extends BaseForm {
	
	
	public StockCountIssueTrackForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public StockCountIssueTrackForm stockCountIssueTrackIdField(String parameterName, String initValue){
		FormField field = idFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StockCountIssueTrackForm stockCountIssueTrackIdField(String initValue){
		return stockCountIssueTrackIdField("stockCountIssueTrackId",initValue);
	}
	public StockCountIssueTrackForm stockCountIssueTrackIdField(){
		return stockCountIssueTrackIdField("stockCountIssueTrackId","");
	}


	public StockCountIssueTrackForm titleField(String parameterName, String initValue){
		FormField field = titleFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StockCountIssueTrackForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public StockCountIssueTrackForm titleField(){
		return titleField("title","");
	}


	public StockCountIssueTrackForm countTimeField(String parameterName, String initValue){
		FormField field = countTimeFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StockCountIssueTrackForm countTimeField(String initValue){
		return countTimeField("countTime",initValue);
	}
	public StockCountIssueTrackForm countTimeField(){
		return countTimeField("countTime","");
	}


	public StockCountIssueTrackForm summaryField(String parameterName, String initValue){
		FormField field = summaryFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StockCountIssueTrackForm summaryField(String initValue){
		return summaryField("summary",initValue);
	}
	public StockCountIssueTrackForm summaryField(){
		return summaryField("summary","");
	}


	public StockCountIssueTrackForm stockCountIdField(String parameterName, String initValue){
		FormField field = stockCountIdFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StockCountIssueTrackForm stockCountIdField(String initValue){
		return stockCountIdField("stockCountId",initValue);
	}
	public StockCountIssueTrackForm stockCountIdField(){
		return stockCountIdField("stockCountId","");
	}

	
	


	public StockCountIssueTrackForm goodsShelfStockCountIdFieldOfGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  idFromGoodsShelfStockCount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StockCountIssueTrackForm goodsShelfStockCountIdFieldOfGoodsShelfStockCount(String initValue){
		return goodsShelfStockCountIdFieldOfGoodsShelfStockCount("goodsShelfStockCountId",initValue);
	}
	public StockCountIssueTrackForm goodsShelfStockCountIdFieldOfGoodsShelfStockCount(){
		return goodsShelfStockCountIdFieldOfGoodsShelfStockCount("goodsShelfStockCountId","");
	}


	public StockCountIssueTrackForm titleFieldOfGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  titleFromGoodsShelfStockCount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StockCountIssueTrackForm titleFieldOfGoodsShelfStockCount(String initValue){
		return titleFieldOfGoodsShelfStockCount("title",initValue);
	}
	public StockCountIssueTrackForm titleFieldOfGoodsShelfStockCount(){
		return titleFieldOfGoodsShelfStockCount("title","");
	}


	public StockCountIssueTrackForm countTimeFieldOfGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  countTimeFromGoodsShelfStockCount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StockCountIssueTrackForm countTimeFieldOfGoodsShelfStockCount(String initValue){
		return countTimeFieldOfGoodsShelfStockCount("countTime",initValue);
	}
	public StockCountIssueTrackForm countTimeFieldOfGoodsShelfStockCount(){
		return countTimeFieldOfGoodsShelfStockCount("countTime","");
	}


	public StockCountIssueTrackForm summaryFieldOfGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  summaryFromGoodsShelfStockCount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StockCountIssueTrackForm summaryFieldOfGoodsShelfStockCount(String initValue){
		return summaryFieldOfGoodsShelfStockCount("summary",initValue);
	}
	public StockCountIssueTrackForm summaryFieldOfGoodsShelfStockCount(){
		return summaryFieldOfGoodsShelfStockCount("summary","");
	}


	public StockCountIssueTrackForm shelfIdFieldOfGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  shelfIdFromGoodsShelfStockCount(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StockCountIssueTrackForm shelfIdFieldOfGoodsShelfStockCount(String initValue){
		return shelfIdFieldOfGoodsShelfStockCount("shelfId",initValue);
	}
	public StockCountIssueTrackForm shelfIdFieldOfGoodsShelfStockCount(){
		return shelfIdFieldOfGoodsShelfStockCount("shelfId","");
	}

	


	

	
 	public StockCountIssueTrackForm transferToAnotherStockCountAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherStockCount/stockCountIssueTrackId/");
		this.addFormAction(action);
		return this;
	}

 

	public StockCountIssueTrackForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


