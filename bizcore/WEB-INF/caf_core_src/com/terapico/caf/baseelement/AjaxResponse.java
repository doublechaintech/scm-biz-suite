package com.terapico.caf.baseelement;

public class AjaxResponse {
	@FunctionalInterface 
	public static interface AjaxWorker {
		Object invoke() throws Exception;
	}
	
	protected String message;
	protected boolean success;
	protected Object data;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public AjaxResponse(AjaxWorker worker) {
		try {
			Object data = worker.invoke();
			this.setData(data);
			if (data instanceof String && ((String) data).length() < 200) {
				this.setMessage((String) data);
			}
			this.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			this.setData(e);
			this.setSuccess(false);
			this.setMessage(e.getMessage());
		}
	}


}

