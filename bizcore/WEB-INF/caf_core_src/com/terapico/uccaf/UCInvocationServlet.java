package com.terapico.uccaf;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.terapico.caf.InternalBeanFactory;
import com.terapico.caf.InvocationContext;
import com.terapico.caf.InvocationException;
import com.terapico.caf.InvocationResult;
import com.terapico.caf.InvocationTool;
import com.terapico.caf.SimpleInvocationResult;
import com.terapico.caf.SimpleInvocationServlet;
import com.terapico.utils.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@WebServlet(urlPatterns = "/*")
public class UCInvocationServlet extends SimpleInvocationServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationContext getApplicationContext() {
		return mApplicationContext;
	}

	public void setApplicationContext(ApplicationContext pApplicationContext) {
		mApplicationContext = pApplicationContext;
	}

	@Autowired
	private ApplicationContext mApplicationContext;

	@Override
	public void init() throws ServletException {
		
		super.init();
		replaceBeans();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		replaceBeans();
	}
	
	protected boolean isAccessControledService(InvocationContext context){
		
		int parameterLength = context.getParameters().length;
		if(parameterLength == 0){
			//no context and no parameter
			return false;
		}
		Object firstParamter = context.getParameters()[0];
		if(!(firstParamter instanceof BaseUserContext)){
			//first parameter is not based on base user context, will not regard as access controlled service.
			
			return false;
		}
		if(!(context instanceof UCInvocationContext)){
			return false;
		}
		Object targetObject = context.getTargetObject();
		if(!(targetObject instanceof AccessControledService)){
			return false;
		}
		
		
		//UCInvocationContext uInvocationContext = (UCInvocationContext)context;
		
		
		return true;
		
	}
	
	protected InvocationResult invoke(InvocationContext context) throws ServletException
	{
		
		//check the user context before invoke
		//before any call, check the URL
		
		
		if(!isAccessControledService(context)){
			
			return super.invoke(context);
		}
		
		Object targetObject = context.getTargetObject();
		Object []parameters = context.getParameters();
		
		AccessControledService targetService = (AccessControledService)targetObject;
		UCInvocationContext ucInvocationContext = (UCInvocationContext)context;

		try {
			System.out.println("InvocationResult result = super.invoke(context); called");
			String methodName = ucInvocationContext.getMethodToCall().getName();
			BaseUserContext baseUserContext = ucInvocationContext.getUserContext();
			
			targetService.onAccess(baseUserContext, methodName ,parameters);

			Object checkResult = targetService.checkAccess(baseUserContext, methodName ,parameters);
			if(checkResult != null){
				//this means check fail;
				System.out.println("InvocationResult result = super.invoke(context); called"+checkResult);
				InvocationResult result=new SimpleInvocationResult();
				result.setActualResult(checkResult);
				result.setInvocationContext(context);
				return result;
			}
			
			//null means the request passed the access check
			InvocationResult result = super.invoke(context);
			logExceptionResult(baseUserContext,result);
			
			targetService.enforceAccess(baseUserContext, result.getActualResult());
			
			
			
			return result;
			
		} catch (Exception e) {
			
			InvocationResult result=new SimpleInvocationResult();
			result.setActualResult(e);			
			//InvocationResult result = super.invoke(context);
			System.out.println("the call throws the exception not handled by the app layer, framework catches");
			e.printStackTrace();
			
			return result;
		}

	}
	
	
	protected Method searchMethod(Class <?> clazz,String name){
		for(Method m:clazz.getMethods()){
			System.out.println("mmm: "+m.getName());
			if(name.equals(m.getName())){
				
				return m;
			}
		}
		return null;
	}
	protected InvocationResult logExceptionResult(BaseUserContext baseUserContext, InvocationResult result){
		//System.out.println("logExceptionResult called");
		if(!(result.getActualResult() instanceof Exception)){
			return result;
		}

		try {
			Class<?> clzz []=new Class[]{String.class, String.class, String.class};
			//baseUserContext.getClass().getDeclaredMethod(name, parameterTypes)
			//public void sendEmail(String to, String subject, String content)
			
			//Method sendMailMethod = searchMethod(baseUserContext.getClass(),"sendMail");//.getMethod("sendMail", String.class, String.class, String.class);
			
			Method sendMailMethod = baseUserContext.getClass().getMethod("sendEmail", String.class, String.class, String.class);
			
			
			sendMailMethod.invoke(baseUserContext, getExceptionMonitorEmail(),
					result.getActualResult().getClass().getSimpleName()+" from " + baseUserContext.getEnvironmentName(),
					wrapExceptionToString((Throwable)result.getActualResult()));
			//即时发现错误的地方
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Method not found"+e);
		}
		
		return result;
		
		//Class<?> parameterTypes;
		//Method sendMailMethod = baseUserContext.getClass().getMethod("sendMail", parameterTypes);
		
		
	}
	
	protected Object getExceptionMonitorEmail() {
		String envValue = System.getenv("EXCEPTION_MONITOR");
		if (TextUtil.isBlank(envValue)) {
			return "opensw0001@gmail.com";
		}
		return envValue;
	}

	protected String wrapExceptionToString(Throwable result) {
		// TODO Auto-generated method stub
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		result.printStackTrace(pw);
		return sw.toString(); // stack trace as a string
	}

	/*
	 * 
	 * public void sendEmail(String to, String subject, String content){
		this.ensureSMTPService();
		smtpService.send(to, subject, content);
		
	}
	 * 
	 * */
	public void replaceBeans()
	{
		InternalBeanFactory.replaceFormBuilder(new UCFormBuilder());
		InternalBeanFactory.replaceServletInvocationContextFactory(new UCInvocationContextFactory(mApplicationContext));
		
	}
	
	
	

}
