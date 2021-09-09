package com.doublechaintech.retailscm;



import java.util.ArrayList;
import java.util.List;


public class Pagination {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected int 		currentPage = 1;
	protected int 		totalRows = 0;
	protected int 		rowsPerPage = 20;
	protected String 	firstPageTitle = "<<";
	protected String 	lastPageTitle = ">>";
	protected String 	previousPageTitle = "<";
	protected String 	nextPageTitle = ">";
	protected int 		maxPages = 10;
	protected String	igoredPageTitle="..";
	private Pagination(int totalRows) {
		this.totalRows = totalRows;
	}

	public Pagination() {
		this.totalRows = 201;
	}

	public Pagination(int totalCount, int rowsPerPage) {
		this.totalRows = totalCount;
		this.rowsPerPage = rowsPerPage;
	}

	public int getTotalPages() {

		int page = totalRows / rowsPerPage;

		if (totalRows % rowsPerPage > 0) {
			page += 1;
		}
		return page;
	}
	protected int getStartPage(int currentPage){

		if(currentPage < maxPages){
			return 1;//align with left when not reaching the max pages
		}
		//currentPage > maxPages

		//has enough pages?
		//move to the middle

		if((currentPage + ((maxPages+1)/2)) <= this.getTotalPages()){
			return currentPage - ((maxPages-1)/2);
		}
		//start from a fixed value, but moving the current page
		//if((currentPage + ((maxPages+1)/2)) > this.getTotalPages()){
		return this.getTotalPages() - maxPages + 1;
		//}
		//throw new IllegalStateException("code realy go here?");


		//return currentPage - maxPages+1;


		//int start = currentPage < maxPages?1:(maxPages/2);
	}
	public List<BaseEntity> render(int currentPage) {
		int totalPages = getTotalPages();
		int fixedCurrentPage = currentPage;
		if(currentPage>getTotalPages()){
			fixedCurrentPage = getTotalPages();
		}
		if(currentPage<1){
			fixedCurrentPage = 1;
		}
		List<BaseEntity> pages = new ArrayList<BaseEntity>();
		if(totalPages>maxPages){
			//need the first and last page;
			Page firstPage = new Page();
			firstPage.setTitle(firstPageTitle);
			firstPage.setLink("1");
			firstPage.setPageNumber(1);
			pages.add(firstPage);
		}

		if(fixedCurrentPage>=maxPages){
			//there are left ignored pages, because the first page can not show here
			Page ignoredPage = new Page();
			ignoredPage.setTitle(igoredPageTitle);
			ignoredPage.setLink("");
			ignoredPage.setDisabled(true);
			pages.add(ignoredPage);
		}

		int start = getStartPage(currentPage);

		for(int i=start;i<Math.min(maxPages, totalPages)+start;i++){
			//if(totalPages)
			Page page = new Page();
			String title=""+i;
			page.setTitle(title);
			page.setLink(title);
			page.setPageNumber(i);
			pages.add(page);
			if(fixedCurrentPage == i){
				page.setSelected(true);
			}

		}

		if(totalPages-getStartPage(fixedCurrentPage) >= maxPages){
			//there are right ignored pages, because the first page can not show here
			Page ignoredPage = new Page();
			ignoredPage.setTitle(igoredPageTitle);
			ignoredPage.setLink("");
			ignoredPage.setDisabled(true);
			pages.add(ignoredPage);
		}


		if(totalPages>maxPages){
			//need the first and last page;
			Page lastPage = new Page();
			lastPage.setTitle(lastPageTitle);
			lastPage.setLink(""+totalPages);
			lastPage.setPageNumber(totalPages);
			pages.add(lastPage);
		}

		return pages;

	}

	public static void report(List<BaseEntity> pages){
		//System.out.printf("%-8d%-8d");
		for(BaseEntity be:pages){
			Page page = (Page)be;
			//System.out.print(page+" ");
			System.out.printf("%-8s",page);

		}
		System.out.println();
	}

	public static void main(String args[]){

		//Pagination p1 = new Pagination(1);
		report( new Pagination(1).render(1));
		report( new Pagination(21).render(1));
		report( new Pagination(21).render(2));

		for(int i=1;i<=10;i++){
			report( new Pagination(200).render(i));
		}


		System.out.println("--------------------------------------");
		for(int i=1;i<12;i++){
			report( new Pagination(201).render(i));
		}
		System.out.println("--------------------------------------");


		for(int i=0;i<110;i++){
			report( new Pagination(2001).render(i));
		}



	}

}



