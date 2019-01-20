package com.doublechaintech.retailscm.goodsshelfstockcount;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class GoodsShelfStockCountForm extends BaseForm {
	
	
	public GoodsShelfStockCountForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public GoodsShelfStockCountForm goodsShelfStockCountIdField(String parameterName, String initValue){
		FormField field = idFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm goodsShelfStockCountIdField(String initValue){
		return goodsShelfStockCountIdField("goodsShelfStockCountId",initValue);
	}
	public GoodsShelfStockCountForm goodsShelfStockCountIdField(){
		return goodsShelfStockCountIdField("goodsShelfStockCountId","");
	}


	public GoodsShelfStockCountForm titleField(String parameterName, String initValue){
		FormField field = titleFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public GoodsShelfStockCountForm titleField(){
		return titleField("title","");
	}


	public GoodsShelfStockCountForm countTimeField(String parameterName, String initValue){
		FormField field = countTimeFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm countTimeField(String initValue){
		return countTimeField("countTime",initValue);
	}
	public GoodsShelfStockCountForm countTimeField(){
		return countTimeField("countTime","");
	}


	public GoodsShelfStockCountForm summaryField(String parameterName, String initValue){
		FormField field = summaryFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm summaryField(String initValue){
		return summaryField("summary",initValue);
	}
	public GoodsShelfStockCountForm summaryField(){
		return summaryField("summary","");
	}


	public GoodsShelfStockCountForm shelfIdField(String parameterName, String initValue){
		FormField field = shelfIdFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm shelfIdField(String initValue){
		return shelfIdField("shelfId",initValue);
	}
	public GoodsShelfStockCountForm shelfIdField(){
		return shelfIdField("shelfId","");
	}

	
	


	public GoodsShelfStockCountForm goodsShelfIdFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  idFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfStockCountForm goodsShelfIdFieldOfGoodsShelf(String initValue){
		return goodsShelfIdFieldOfGoodsShelf("goodsShelfId",initValue);
	}
	public GoodsShelfStockCountForm goodsShelfIdFieldOfGoodsShelf(){
		return goodsShelfIdFieldOfGoodsShelf("goodsShelfId","");
	}


	public GoodsShelfStockCountForm locationFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  locationFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfStockCountForm locationFieldOfGoodsShelf(String initValue){
		return locationFieldOfGoodsShelf("location",initValue);
	}
	public GoodsShelfStockCountForm locationFieldOfGoodsShelf(){
		return locationFieldOfGoodsShelf("location","");
	}


	public GoodsShelfStockCountForm storageSpaceIdFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  storageSpaceIdFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfStockCountForm storageSpaceIdFieldOfGoodsShelf(String initValue){
		return storageSpaceIdFieldOfGoodsShelf("storageSpaceId",initValue);
	}
	public GoodsShelfStockCountForm storageSpaceIdFieldOfGoodsShelf(){
		return storageSpaceIdFieldOfGoodsShelf("storageSpaceId","");
	}


	public GoodsShelfStockCountForm supplierSpaceIdFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  supplierSpaceIdFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfStockCountForm supplierSpaceIdFieldOfGoodsShelf(String initValue){
		return supplierSpaceIdFieldOfGoodsShelf("supplierSpaceId",initValue);
	}
	public GoodsShelfStockCountForm supplierSpaceIdFieldOfGoodsShelf(){
		return supplierSpaceIdFieldOfGoodsShelf("supplierSpaceId","");
	}


	public GoodsShelfStockCountForm damageSpaceIdFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  damageSpaceIdFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfStockCountForm damageSpaceIdFieldOfGoodsShelf(String initValue){
		return damageSpaceIdFieldOfGoodsShelf("damageSpaceId",initValue);
	}
	public GoodsShelfStockCountForm damageSpaceIdFieldOfGoodsShelf(){
		return damageSpaceIdFieldOfGoodsShelf("damageSpaceId","");
	}


	public GoodsShelfStockCountForm lastUpdateTimeFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfStockCountForm lastUpdateTimeFieldOfGoodsShelf(String initValue){
		return lastUpdateTimeFieldOfGoodsShelf("lastUpdateTime",initValue);
	}
	public GoodsShelfStockCountForm lastUpdateTimeFieldOfGoodsShelf(){
		return lastUpdateTimeFieldOfGoodsShelf("lastUpdateTime","");
	}

	



	public GoodsShelfStockCountForm stockCountIssueTrackIdFieldForStockCountIssueTrack(String parameterName, String initValue){
		FormField field =  idFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm stockCountIssueTrackIdFieldForStockCountIssueTrack(String initValue){
		return stockCountIssueTrackIdFieldForStockCountIssueTrack("stockCountIssueTrackId",initValue);
	}
	public GoodsShelfStockCountForm stockCountIssueTrackIdFieldForStockCountIssueTrack(){
		return stockCountIssueTrackIdFieldForStockCountIssueTrack("stockCountIssueTrackId","");
	}


	public GoodsShelfStockCountForm titleFieldForStockCountIssueTrack(String parameterName, String initValue){
		FormField field =  titleFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm titleFieldForStockCountIssueTrack(String initValue){
		return titleFieldForStockCountIssueTrack("title",initValue);
	}
	public GoodsShelfStockCountForm titleFieldForStockCountIssueTrack(){
		return titleFieldForStockCountIssueTrack("title","");
	}


	public GoodsShelfStockCountForm countTimeFieldForStockCountIssueTrack(String parameterName, String initValue){
		FormField field =  countTimeFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm countTimeFieldForStockCountIssueTrack(String initValue){
		return countTimeFieldForStockCountIssueTrack("countTime",initValue);
	}
	public GoodsShelfStockCountForm countTimeFieldForStockCountIssueTrack(){
		return countTimeFieldForStockCountIssueTrack("countTime","");
	}


	public GoodsShelfStockCountForm summaryFieldForStockCountIssueTrack(String parameterName, String initValue){
		FormField field =  summaryFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm summaryFieldForStockCountIssueTrack(String initValue){
		return summaryFieldForStockCountIssueTrack("summary",initValue);
	}
	public GoodsShelfStockCountForm summaryFieldForStockCountIssueTrack(){
		return summaryFieldForStockCountIssueTrack("summary","");
	}


	public GoodsShelfStockCountForm stockCountIdFieldForStockCountIssueTrack(String parameterName, String initValue){
		FormField field =  stockCountIdFromStockCountIssueTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfStockCountForm stockCountIdFieldForStockCountIssueTrack(String initValue){
		return stockCountIdFieldForStockCountIssueTrack("stockCountId",initValue);
	}
	public GoodsShelfStockCountForm stockCountIdFieldForStockCountIssueTrack(){
		return stockCountIdFieldForStockCountIssueTrack("stockCountId","");
	}

	

	
 	public GoodsShelfStockCountForm transferToAnotherShelfAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherShelf/goodsShelfStockCountId/");
		this.addFormAction(action);
		return this;
	}

 

	public GoodsShelfStockCountForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


