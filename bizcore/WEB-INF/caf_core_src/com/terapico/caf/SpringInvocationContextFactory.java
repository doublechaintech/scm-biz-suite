package com.terapico.caf;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInvocationContextFactory extends ServletInvocationContextFactory {
	AbstractApplicationContext context; 
	public SpringInvocationContextFactory(){
		context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring.xml");		
	}

	
	public String[] getBeanNames() {		
		return context.getBeanDefinitionNames();
	}
	protected Object getBean(String beanName)
	{
		Object target=super.getBean(beanName);
		if(target!=null){
			return target;
		}
		
		return getObject(beanName);
		
	}
	protected Object getObject(String objectPath) {
		return context.getBean(objectPath);
	}
}
