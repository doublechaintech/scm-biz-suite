package com.doublechaintech.retailscm;

import java.util.Collection;

public class EmptySmartList<E extends BaseEntity> extends SmartList<E> {
	
	private final String OPERATION_NOW_ALLOWED_MESSAGE="EmptySmartList is just a place holder, should not add and/or contain any element in it";
	
	protected boolean throwOperationNowAllowedException() {
		
		throw new IllegalStateException(OPERATION_NOW_ALLOWED_MESSAGE);
		
	}
	
	@Override
	public boolean add(E e) {
		return throwOperationNowAllowedException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		
		return throwOperationNowAllowedException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		
		return throwOperationNowAllowedException();
	}

	@Override
	public void add(int index, E element) {
		
		 throwOperationNowAllowedException();
	}

	@Override
	public void addToRemoveList(E e) {
		
		 throwOperationNowAllowedException();
	}

	@Override
	public void addAllToRemoveList(SmartList<E> externalToRemoveList) {
		
		 throwOperationNowAllowedException();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	

}
