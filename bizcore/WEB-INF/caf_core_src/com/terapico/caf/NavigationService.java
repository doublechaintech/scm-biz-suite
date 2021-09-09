package com.terapico.caf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terapico.caf.baseelement.MenuItem;
import com.terapico.caf.baseelement.PlainText;

public class NavigationService extends ReflectionTool {
	BeanFactory beanFactory;
	
	public NavigationService()
	{
		
		
	}
	protected BeanFactory getBeanFactory() {
		if (beanFactory == null) {
			beanFactory = InternalBeanFactory.getDefaultBeanFactory();
		}
		return beanFactory;
	}

	private Map<String, List<MenuItem>> definitionCache ;

	protected void init() {
		
		if(definitionCache!=null){
			return;
		}
		
		definitionCache = new ConcurrentHashMap<String, List<MenuItem>>();
		
		SpringBeanFactory springBeanFactory = (SpringBeanFactory) getBeanFactory();
		ConfigurableListableBeanFactory internalFactory = springBeanFactory.springFactory();
		String[] beanNames = getBeanFactory().getBeanNames();
		for (String beanName : beanNames) {
			
			if(beanName.endsWith("DAO")){
				continue;
			}
			
			try {
				definitionCache.put(beanName, createItemsForClass(beanName, internalFactory));
			} catch (ClassNotFoundException e) {
				
				this.logInfo("Bean: "+beanName+" fail to load the class "+e.getMessage());
			}
		}

	}

	private void logInfo(String string) {
		
		System.out.println(this.getClass().getName()+" "+string);
	}

	protected MenuItem createItem(String beanName, String methodName) {
		MenuItem item = createEmtryItem();
		item.setBeanName(beanName);
		item.setLink(methodName);
		return item;

	}

	protected MenuItem createEmtryItem() {
		MenuItem item = new MenuItem();
		return item;

	}

	protected List<MenuItem> createItemsForClass(String beanName, ConfigurableListableBeanFactory internalFactory) throws ClassNotFoundException {
		

		BeanDefinition beanDefinition = internalFactory.getBeanDefinition(beanName);

		Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());

		List<Method> safeMethods = this.getSafeMethodsFromClass(clazz);
		List<MenuItem> itemList = new ArrayList<MenuItem>();

		for (Method method : safeMethods) {
			if(method.getName().startsWith("get")){
				continue;
			}
			if(method.getName().startsWith("set")){
				continue;
			}
			MenuItem item = createItem(beanName, method.getName());
			itemList.add(item);
		}

		return itemList;

	}

	
	public PlainText desc(){
		init();
		String[] beanNames = getBeanFactory().getBeanNames();
		SpringBeanFactory springBeanFactory = (SpringBeanFactory) getBeanFactory();
		ConfigurableListableBeanFactory internalFactory = springBeanFactory.springFactory();
		PlainText result=new PlainText();
		for (String beanName : beanNames) {
			
			result.append(beanName+"\r\n--------------------------------------------------\r\n");
			try {
				definitionCache.put(beanName, createItemsForClass(beanName, internalFactory));
				
				BeanDefinition beanDefinition = internalFactory.getBeanDefinition(beanName);
				
				MutablePropertyValues values = beanDefinition.getPropertyValues();
				
				PropertyValue[] valueArray= values.getPropertyValues();
				
				for(PropertyValue value: valueArray ){
					result.append(value.getName());
					result.append("=");
					result.append(toStringExpr(value));
					result.append("\r\n");
				}
				
				
				
			} catch (ClassNotFoundException e) {
				
				this.logInfo("Bean: "+beanName+" fail to load the class "+e.getMessage());
			}
			result.append("\r\n\r\n");
		}
		return result;
	}
	protected String toStringExpr(PropertyValue value) {
		Object valueObject=value.getValue();
		if(valueObject instanceof TypedStringValue){
			TypedStringValue tsv=(TypedStringValue)valueObject;
			return tsv.getValue();
		}
		return value.getValue().toString();
	}
	
	public Navigator index(String selectedBean) {
		init();
		
		Navigator navigator = createNavigator();
		String[] beanNames = getBeanFactory().getBeanNames();

		navigator.addToBeanList(beanNames);
		navigator.setSelectBean(selectedBean);

		List<MenuItem> items=getMenuItemForBean(selectedBean);
		
		navigator.setMenuItems(items);
		
		String objectExpr=getObjectExpr(getBeanFactory().getBean(selectedBean));
		navigator.setBeanExpr(objectExpr);
		// for(String beanName:beanNames){
		//createItems(navigator, selectedBean);
		// }
		
		return navigator;

	}

	public Navigator select(String selectedBean) {
		init();
		
		Navigator navigator = createNavigator();
		String[] beanNames = getBeanFactory().getBeanNames();

		navigator.addToBeanList(beanNames);
		navigator.setSelectBean(selectedBean);

		List<MenuItem> items=getMenuItemForBean(selectedBean);
		
		navigator.setMenuItems(items);
		
		
		//navigator.setBeanExpr(beanExpr);
		// for(String beanName:beanNames){
		//createItems(navigator, selectedBean);
		// }
		
		return navigator;

	}

	protected List<MenuItem> getMenuItemForBean(String selectedBean) {
		
		
		List<MenuItem> items=definitionCache.get(selectedBean);
		
		if(items==null){
			return new ArrayList<MenuItem>();
		}

		return items;
	}
	protected String getObjectExpr(Object target) {

		if(target==null){
			return "Can not build expression for a null bean";
		}
		try {
			//Gson serializer = new GsonBuilder().setPrettyPrinting().create();
			
			ObjectMapper mapper = new ObjectMapper();
			// Type t=new TypeToken<weather.WeatherResponse>().getType();
			//response.getWriter().println(gson.toJson(result.getActualResult()));
			//mapper
			/*
			Order order=(Order)OrdreJsonTool.prepareForJson((Order)result.getActualResult());
			
			*/
			String json = mapper.writeValueAsString(target);
			
			String stringExpr = json;
			return "class: '" + target.getClass().getName() + "'\r\n" + stringExpr ;
		} catch (Throwable e) {
			return e.getMessage();
		}
	}

	

	protected Navigator createNavigator() {
		return new Navigator();

	}



}
