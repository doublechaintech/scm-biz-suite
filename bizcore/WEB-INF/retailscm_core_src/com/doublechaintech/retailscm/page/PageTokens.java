
package com.doublechaintech.retailscm.page;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.pagetype.PageTypeTokens;
import com.doublechaintech.retailscm.mobileapp.MobileAppTokens;
import com.doublechaintech.retailscm.slide.SlideTokens;
import com.doublechaintech.retailscm.uiaction.UiActionTokens;
import com.doublechaintech.retailscm.section.SectionTokens;





public class PageTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="page";

	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){

		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner?
			return false;
		}

 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.
 			return true;
 		}

 		return false;

	}
	protected PageTokens(){
		//ensure not initialized outside the class
	}
	public  static  PageTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PageTokens tokens = new PageTokens(options);
		return tokens;

	}
	protected PageTokens(Map<String,Object> options){
		this.options = options;
	}

	public PageTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static PageTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected PageTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static PageTokens start(){
		return new PageTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public PageTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static PageTokens loadGroupTokens(String... groupNames){
    PageTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, PAGETYPE, groupNames, new String[]{"default"});addToken(tokens, MOBILEAPP, groupNames, new String[]{"default"});

  
     addToken(tokens, SLIDE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, UI_ACTION_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, SECTION_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(PageTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null){
      return;
    }

    for (String groupName: pGroupNames){
      for(String g: fieldGroups){
        if( Objects.equals(groupName, g)){
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

	public static PageTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withPageType()
			.withMobileApp()
			.withSlideListIfViewGroupInclude(viewGroups)
			.withUiActionListIfViewGroupInclude(viewGroups)
			.withSectionListIfViewGroupInclude(viewGroups);

	}

	public static PageTokens allTokens(){

		return start()
			.withPageType()
			.withMobileApp()
			.withSlideList()
			.withUiActionList()
			.withSectionList();

	}
	public static PageTokens withoutListsTokens(){

		return start()
			.withPageType()
			.withMobileApp();

	}

	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	public PageTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PAGETYPE = "pageType";
	public String getPageType(){
		return PAGETYPE;
	}
	//
	public PageTokens withPageType(){
		addSimpleOptions(PAGETYPE);
		return this;
	}

	public PageTypeTokens withPageTypeTokens(){
		//addSimpleOptions(PAGETYPE);
		return PageTypeTokens.start();
	}

	
	protected static final String MOBILEAPP = "mobileApp";
	public String getMobileApp(){
		return MOBILEAPP;
	}
	//
	public PageTokens withMobileApp(){
		addSimpleOptions(MOBILEAPP);
		return this;
	}

	public MobileAppTokens withMobileAppTokens(){
		//addSimpleOptions(MOBILEAPP);
		return MobileAppTokens.start();
	}

	
	protected static final String SLIDE_LIST = "slideList";
	public String getSlideList(){
		return SLIDE_LIST;
	}



	public PageTokens withSlideListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(SLIDE_LIST);
		}
		return this;
	}


	public PageTokens withSlideList(){
		addSimpleOptions(SLIDE_LIST);
		return this;
	}

	public SlideTokens withSlideListTokens(){
		//addSimpleOptions(SLIDE_LIST);
		return SlideTokens.start();
	}

	public PageTokens analyzeSlideList(){
		addSimpleOptions(SLIDE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSlideListEnabled(){

		if(checkOptions(this.options(), SLIDE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PageTokens extractMoreFromSlideList(String idsSeperatedWithComma){
		addSimpleOptions(SLIDE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int slideListSortCounter = 0;
	public PageTokens sortSlideListWith(String field, String descOrAsc){
		addSortMoreOptions(SLIDE_LIST,slideListSortCounter++, field, descOrAsc);
		return this;
	}
	private int slideListSearchCounter = 0;
	public PageTokens searchSlideListWith(String field, String verb, String value){

		withSlideList();
		addSearchMoreOptions(SLIDE_LIST,slideListSearchCounter++, field, verb, value);
		return this;
	}



	public PageTokens searchAllTextOfSlideList(String verb, String value){
		String field = "id|name|linkToUrl";
		addSearchMoreOptions(SLIDE_LIST,slideListSearchCounter++, field, verb, value);
		return this;
	}



	public PageTokens rowsPerPageOfSlideList(int rowsPerPage){
		addSimpleOptions(SLIDE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PageTokens currentPageNumberOfSlideList(int currentPageNumber){
		addSimpleOptions(SLIDE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PageTokens retainColumnsOfSlideList(String[] columns){
		addSimpleOptions(SLIDE_LIST+"RetainColumns",columns);
		return this;
	}
	public PageTokens excludeColumnsOfSlideList(String[] columns){
		addSimpleOptions(SLIDE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String UI_ACTION_LIST = "uiActionList";
	public String getUiActionList(){
		return UI_ACTION_LIST;
	}



	public PageTokens withUiActionListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(UI_ACTION_LIST);
		}
		return this;
	}


	public PageTokens withUiActionList(){
		addSimpleOptions(UI_ACTION_LIST);
		return this;
	}

	public UiActionTokens withUiActionListTokens(){
		//addSimpleOptions(UI_ACTION_LIST);
		return UiActionTokens.start();
	}

	public PageTokens analyzeUiActionList(){
		addSimpleOptions(UI_ACTION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUiActionListEnabled(){

		if(checkOptions(this.options(), UI_ACTION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PageTokens extractMoreFromUiActionList(String idsSeperatedWithComma){
		addSimpleOptions(UI_ACTION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int uiActionListSortCounter = 0;
	public PageTokens sortUiActionListWith(String field, String descOrAsc){
		addSortMoreOptions(UI_ACTION_LIST,uiActionListSortCounter++, field, descOrAsc);
		return this;
	}
	private int uiActionListSearchCounter = 0;
	public PageTokens searchUiActionListWith(String field, String verb, String value){

		withUiActionList();
		addSearchMoreOptions(UI_ACTION_LIST,uiActionListSearchCounter++, field, verb, value);
		return this;
	}



	public PageTokens searchAllTextOfUiActionList(String verb, String value){
		String field = "id|code|icon|title|brief|linkToUrl|extraData";
		addSearchMoreOptions(UI_ACTION_LIST,uiActionListSearchCounter++, field, verb, value);
		return this;
	}



	public PageTokens rowsPerPageOfUiActionList(int rowsPerPage){
		addSimpleOptions(UI_ACTION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PageTokens currentPageNumberOfUiActionList(int currentPageNumber){
		addSimpleOptions(UI_ACTION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PageTokens retainColumnsOfUiActionList(String[] columns){
		addSimpleOptions(UI_ACTION_LIST+"RetainColumns",columns);
		return this;
	}
	public PageTokens excludeColumnsOfUiActionList(String[] columns){
		addSimpleOptions(UI_ACTION_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String SECTION_LIST = "sectionList";
	public String getSectionList(){
		return SECTION_LIST;
	}



	public PageTokens withSectionListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(SECTION_LIST);
		}
		return this;
	}


	public PageTokens withSectionList(){
		addSimpleOptions(SECTION_LIST);
		return this;
	}

	public SectionTokens withSectionListTokens(){
		//addSimpleOptions(SECTION_LIST);
		return SectionTokens.start();
	}

	public PageTokens analyzeSectionList(){
		addSimpleOptions(SECTION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSectionListEnabled(){

		if(checkOptions(this.options(), SECTION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PageTokens extractMoreFromSectionList(String idsSeperatedWithComma){
		addSimpleOptions(SECTION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int sectionListSortCounter = 0;
	public PageTokens sortSectionListWith(String field, String descOrAsc){
		addSortMoreOptions(SECTION_LIST,sectionListSortCounter++, field, descOrAsc);
		return this;
	}
	private int sectionListSearchCounter = 0;
	public PageTokens searchSectionListWith(String field, String verb, String value){

		withSectionList();
		addSearchMoreOptions(SECTION_LIST,sectionListSearchCounter++, field, verb, value);
		return this;
	}



	public PageTokens searchAllTextOfSectionList(String verb, String value){
		String field = "id|title|brief|viewGroup|linkToUrl";
		addSearchMoreOptions(SECTION_LIST,sectionListSearchCounter++, field, verb, value);
		return this;
	}



	public PageTokens rowsPerPageOfSectionList(int rowsPerPage){
		addSimpleOptions(SECTION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PageTokens currentPageNumberOfSectionList(int currentPageNumber){
		addSimpleOptions(SECTION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PageTokens retainColumnsOfSectionList(String[] columns){
		addSimpleOptions(SECTION_LIST+"RetainColumns",columns);
		return this;
	}
	public PageTokens excludeColumnsOfSectionList(String[] columns){
		addSimpleOptions(SECTION_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  PageTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfSlideList(verb, value);
		searchAllTextOfUiActionList(verb, value);
		searchAllTextOfSectionList(verb, value);
		return this;
	}
}

