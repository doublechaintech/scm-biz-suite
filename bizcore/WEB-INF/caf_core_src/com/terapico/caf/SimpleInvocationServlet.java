package com.terapico.caf;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleInvocationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	protected void doPut2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String str=null;
		StringBuilder resultString =new StringBuilder();
		
		while ((str = request.getReader().readLine()) != null) {
			resultString.append(str);
		}
		response.getWriter().print(resultString.toString());
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doTheJob(request, response);
	}
	protected void doTheJob(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		long start = System.currentTimeMillis();
		InvocationResult result = getResult(request, response);
		long javaCallInterval = System.currentTimeMillis();
		render(request, response, result);
		long renderCallInterval = System.currentTimeMillis();

		logInfo("#########################################The call took: "

				+ (renderCallInterval - start) + "ms/" + (javaCallInterval - start) + "ms/"
				+ (renderCallInterval - javaCallInterval) + "ms for TOTAL/BACKEND/RENDERING");
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doTheJob(request, response);
	}
	
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String origin=request.getHeader("Origin");
		if(origin==null){
			origin = "*";
		}
		response.addHeader("Access-Control-Allow-Origin",origin);
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		// Access-Control-Expose-Headers
		String reqedHeaders = request.getHeader("Access-Control-Request-Headers");
		response.addHeader("Access-Control-Allow-Headers", reqedHeaders+", X-Redirect, X-Env-Type, X-Env-Name");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doTheJob(request, response);
		
		/*
		long start = System.currentTimeMillis();
		InvocationResult result = getResult(request, response);
		long javaCallInterval = System.currentTimeMillis();
		render(request, response, result);
		long renderCallInterval = System.currentTimeMillis();
		logInfo("#########################################The call took: "

				+ (renderCallInterval - start) + "ms/" + (javaCallInterval - start) + "ms/"
				+ (renderCallInterval - javaCallInterval) + "ms for TOTAL/BACKEND/RENDERING");
		*/		
	}

	protected void render(HttpServletRequest request, HttpServletResponse response, InvocationResult result)
			throws ServletException, IOException {

		ServletResultRenderer renderer = getResultRenderer();
		renderer.render(this, request, response, result);
	}

	protected InvocationResult getResult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			InvocationContext context = createInvocationContext(request);
			if (context == null) {
				return wrapExceptionResult(new ServletException("The context should be prepared for call."), null);
			}

			InvocationResult result = invoke(context);

			if (result == null) {
				return wrapExceptionResult(new ServletException("The result should not to be null."), context);
			}
			return result;

		} catch (Throwable e) {

			return wrapExceptionResult(e, null);
		}
	}

	protected InvocationResult wrapResult(Object actualResult, InvocationContext context) {

		InvocationResult result = new SimpleInvocationResult();
		result.setInvocationContext(context);
		result.setActualResult(actualResult);
		return result;
	}

	protected InvocationResult wrapResult(Object actualResult) {

		return wrapResult(actualResult, null);
	}

	protected InvocationResult wrapExceptionResult(Throwable actualResult, InvocationContext context) {

		System.err.println(actualResult.getMessage());
		return wrapResult(actualResult, null);
	}

	protected String timeExpr() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd'T'HH:mm:ss.SSS");
		// It is not thread safe, how silly the JDK is!!!
		return simpleDateFormat.format(new java.util.Date());
	}

	protected InvocationResult invoke(InvocationContext context) throws ServletException {
		InvocationTool tool = getInvocationTool();
		logInfo("InvocationResult invoke " + context.toString());
		if (tool == null) {
			throw new ServletException("Invocation tool must be configured");
		}
		try {
			return tool.invoke(context);
		} catch (InvocationException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

	private void logInfo(String message) {
		// TODO Auto-generated method stub
		String logMessage = timeExpr() + "  " + message;
		System.out.println(logMessage);

	}

	ServletInvocationContextFactory factory;

	protected InvocationContext createInvocationContext(HttpServletRequest request) throws InvocationException {

		if (factory == null) {
			factory = InternalBeanFactory.getDefaultInvocationContextFactory();
			// cache the reference.
		}

		return factory.create(request);
	}

	InvocationTool tool;

	protected InvocationTool getInvocationTool() {
		if (tool == null) {
			tool = InternalBeanFactory.getDefaultInvocationTool();
			// cache the reference.
		}
		return tool;

	}

	ServletResultRenderer render;

	protected ServletResultRenderer getResultRenderer() {
		if (render == null) {
			render = InternalBeanFactory.getDefaultRenderer();
			// cache the reference.
		}
		return render;
	}

}
