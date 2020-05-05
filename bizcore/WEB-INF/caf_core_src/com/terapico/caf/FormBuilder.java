package com.terapico.caf;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cglib.proxy.Enhancer;

import com.terapico.caf.baseelement.Action;
import com.terapico.caf.baseelement.Field;
import com.terapico.caf.baseelement.Form;

public class FormBuilder extends ReflectionTool{
	public Form buildForm(String beanName,Method method, Object []presetParameters) throws IOException, NoSuchMethodException {
		Form form=new Form();
		Type[] methodParameterTypes=method.getGenericParameterTypes();
		Class<?> declaringClass = getDeclaringClass(method);
		Method declaringClassMethod = declaringClass.getMethod(method.getName(), method.getParameterTypes());
		List<String> nameList=getParameterNames(declaringClassMethod);
		int presetParametersLength=presetParameters.length;
		int ignoreCounter = 0;
		for(int i=0;i<methodParameterTypes.length;i++){

			String name=nameList.get(i);

			if(!isToAddToFormField(i,methodParameterTypes[i],name)){
				ignoreCounter ++;
				continue;
			}

			Field field=new Field();

			field.setLabel(name);
			field.setName(name);
			int newIndex = (i-ignoreCounter);
			if(newIndex < presetParametersLength){
				field.setDefaultValue(presetParameters[newIndex].toString());

			}


			Type type = methodParameterTypes[i];
			field.setType(type);

			form.addField(field);


		}

		form.addAction(new Action(beanName+"/"+method.getName()));
		return form;
	}

	protected boolean isToAddToFormField(int index, Type type, String name){
		//让子类有机会忽略某些参数，比如系统自动增加的的参数要删除，该处不需要用户输入
		return true;

	}

	//Exclude the spring enhancers
	protected static Class<?> getDeclaringClass(Method method) {
		Class<?> declaringClass = method.getDeclaringClass();

		if (!Enhancer.isEnhanced(declaringClass)) {
			// the class is not proxied
			return declaringClass;
		}
		Class<?> superDeclaringClass = declaringClass;
		while (superDeclaringClass != Object.class) {

			if (Enhancer.isEnhanced(superDeclaringClass)) {
				// the class is not proxied
				superDeclaringClass = superDeclaringClass.getSuperclass();
				continue;
			}
			Method targetMethod = findMethod(superDeclaringClass,method);
			if(targetMethod==null){
				superDeclaringClass = superDeclaringClass.getSuperclass();
				continue;
			}

			return superDeclaringClass;

		}
		// Should not go here.
		throw new IllegalArgumentException("The method getDeclaringClass should not go here");

	}
	public static Method findMethod(Class<?> clazz, Method proxiedMethod){


		for(Method m:clazz.getDeclaredMethods()){

			if(m.getName().equals(proxiedMethod.getName())){
				return m;
			}

		}
		return null;

	}




	private static Map<Method,List<String>>parameterNamesCache=new ConcurrentHashMap<Method,List<String>>();

	protected static List<String> getParameterNames(Method method) throws IOException{
		List<String> cachedParameteNames=parameterNamesCache.get(method);
		if(cachedParameteNames!=null){
			return cachedParameteNames;
		}
		return getParametersWithJava8Reflection(method);

	}
	//使用Java8的实现，简单很多，但是编译的时候要确定 Store information about method parameters
	//javac -parameters                Generate metadata for reflection on method parameters
	public static List<String> getParametersWithJava8Reflection(Executable exec) {
		Parameter[] parameters = exec.getParameters();
		List<String> parmList = new ArrayList<String>();
		for (int i = 0; i < parameters.length; i++) {
			String parmName = parameters[i].getName();
			if (parmName.trim().length() == 0) {
				continue;
			}
			parmList.add(parmName);
		}
		return parmList;
	}

}


/*
 * 
 * 
 * 保留在这里，如果在一些保守的企业里面只能用Java 7，那么这个函数还能用
 * 	protected static List<String> getParameterNames2(Method method) throws IOException  {	

		List<String> cachedParameteNames=parameterNamesCache.get(method);
		if(cachedParameteNames!=null){
			return cachedParameteNames;
		}

		
		Class<?> declaringClass = getDeclaringClass(method);
		

		ClassLoader declaringClassLoader = declaringClass.getClassLoader();

		org.objectweb.asm.Type declaringType = org.objectweb.asm.Type.getType(declaringClass);
		String url = declaringType.getInternalName() + ".class";

		InputStream classFileInputStream = declaringClassLoader.getResourceAsStream(url);
		if (classFileInputStream == null) {
			throw new IllegalArgumentException(
					"The constructor's class loader cannot find the bytecode that defined the constructor's class (URL: "
							+ url + ")");
		}

		ClassNode classNode;
		try {
			classNode = new ClassNode();
			ClassReader classReader = new ClassReader(classFileInputStream);
			classReader.accept(classNode, 0);
		} finally {
			classFileInputStream.close();
		}

		@SuppressWarnings("unchecked")
		List<MethodNode> methods = classNode.methods;
		for (MethodNode methodNode : methods) {

			if (!isMatch(methodNode, method)) {
				continue;
			}

			org.objectweb.asm.Type[] argumentTypes = org.objectweb.asm.Type.getArgumentTypes(methodNode.desc);
			List<String> parameterNames = new ArrayList<String>(argumentTypes.length);

			@SuppressWarnings("unchecked")
			List<LocalVariableNode> localVariables = methodNode.localVariables;

			if (localVariables.isEmpty()) {
				continue;
			}

			for (int i = 0; i < argumentTypes.length; i++) {
				// The first local variable actually represents the "this"
				// object
				LocalVariableNode lv = localVariables.get(i + 1);
				// parameterNames.add(
				// org.objectweb.asm.Type.getType(lv.desc).getClassName()+" " +
				// lv.name);
				parameterNames.add(lv.name);

			}
			
			parameterNamesCache.put(method, parameterNames);
			
			return parameterNames;

		}

		return null;
	}
	
	
		@SuppressWarnings("rawtypes")
	protected static boolean isMatch(MethodNode methodNode, Method method) {

		if (!methodNode.name.equals(method.getName())) {
			return false;
		}

		org.objectweb.asm.Type[] types = org.objectweb.asm.Type.getArgumentTypes(methodNode.desc);
		Class[] parameterTypes = method.getParameterTypes();
		if (types.length != parameterTypes.length) {
			return false;
		}
		for (int i = 0; i < types.length; i++) {
			// Type type=types[i];

			if (types[i] != org.objectweb.asm.Type.getType(parameterTypes[i])) {
				// return false;
			}

		}

		return true;

	}
 * 
 * 
 * 
 * */

