package com.terapico.caf;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactory extends InternalBeanFactory implements BeanFactory{
	

	
	ClassPathXmlApplicationContext context; 
	public SpringBeanFactory(){
		
		
		
		
	}
	protected void ensureContext()
	{
		if(context!=null){return;}
		context = new ClassPathXmlApplicationContext(new String[]{
				"classpath*:/META-INF/spring.xml",
				"classpath*:/META-INF/online-system.xml"});
		
		
	}
	private String []beanNamesCache;
	public String[] getBeanNames() {
		
		ensureContext();
		
		if(beanNamesCache==null){
			beanNamesCache=context.getBeanDefinitionNames();
		}
		
		
		
		return beanNamesCache;
	}
	
	public ConfigurableListableBeanFactory springFactory()
	{
		ensureContext();
		return this.context.getBeanFactory();
		
	}
	
	public Object getBean(String beanName)
	{
		Object internalObject=getInternalBean(beanName);
		if(internalObject!=null){
			return internalObject;
		}
		
		return getObject(beanName);
	}
	
	
	protected Object getObject(String objectPath) {
		ensureContext();
		return context.getBean(objectPath);
	}

	
}
