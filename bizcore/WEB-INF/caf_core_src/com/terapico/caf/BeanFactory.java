package com.terapico.caf;

public interface BeanFactory {
	public String[] getBeanNames() ;
	Object getBean(String beanName);
}
