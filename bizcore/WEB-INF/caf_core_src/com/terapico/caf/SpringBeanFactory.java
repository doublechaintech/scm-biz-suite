package com.terapico.caf;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringBeanFactory extends InternalBeanFactory implements BeanFactory{

	ApplicationContext mApplicationContext;

	ApplicationContext context;

	ConfigurableListableBeanFactory mBeanFactory;

	public SpringBeanFactory(){
		
		
		
		
	}

	public SpringBeanFactory(ApplicationContext pApplicationContext){

		mApplicationContext = pApplicationContext;


	}

	//
	protected void ensureContext()
	{
		if(context!=null){return;}

		if (mApplicationContext != null){
			context = mApplicationContext;

			mBeanFactory = ((GenericApplicationContext)mApplicationContext).getBeanFactory();
			return;
		}
		ClassPathXmlApplicationContext classpathContext = new ClassPathXmlApplicationContext(new String[]{
				"classpath*:/META-INF/spring.xml",
				"classpath*:/META-INF/online-system.xml"});

		mBeanFactory = classpathContext.getBeanFactory();
		context = classpathContext;
		
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
		return this.mBeanFactory;
		
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
