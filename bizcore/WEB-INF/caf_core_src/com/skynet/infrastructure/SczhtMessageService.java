package com.skynet.infrastructure;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SczhtMessageService implements MessageService {
	
	protected static Thread taskQueueThread = null;
	protected static LinkedBlockingQueue<Map<String, Object>> taskQueue = null;
	protected static AtomicBoolean running = new AtomicBoolean(false);
	private static CloseableHttpClient httpclient = null;
	
	public static final String TASK_PLAIN_TEXT_MESSAGE = "plain_sms";
	
	protected static final String PARAM_TASK_TYPE="task_type";
	protected static final String PARAM_RECIEVER_NUMBER="to_number";
	protected static final String PARAM_FROM_WHO="from_who";
	
	protected static final String PARAM_MESSAGE_TEMPLATE="template";
	protected static final String PARAM_MESSAGE_DATA="params";
	protected static final int QUEUE_SIZE = 100;
	
	protected SMTPService smtpService;
	
	
	
	public SMTPService getSmtpService() {
		return smtpService;
	}

	public void setSmtpService(SMTPService smtpService) {
		this.smtpService = smtpService;
	}

	@Override
	public void sendMessage(String dest, String fromWho, String template, Map<String, String> parameters)
			throws Exception {
		if (!StringUtils.isBlank(template) && (parameters==null || parameters.isEmpty())){
			// 如果你调错了接口，把消息放到template参数上了，也就这个短信服务接口，　可以兼容处理一下
			parameters = new HashMap<String, String>();
			parameters.put("message", template);
		}
		
		Map<String, Object> task = new HashMap<String, Object>();
		task.put(PARAM_TASK_TYPE, TASK_PLAIN_TEXT_MESSAGE);
		task.put(PARAM_RECIEVER_NUMBER, dest);
		task.put(PARAM_FROM_WHO, fromWho);
		task.put(PARAM_MESSAGE_TEMPLATE, template);
		task.put(PARAM_MESSAGE_DATA, parameters);
		
		addTask(task);
	}

	private void addTask(Map<String, Object> task) {
		ensureTaskThread();
		try {
			taskQueue.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void ensureTaskThread() {
		if (taskQueue != null){
			return;
		}
		synchronized (SczhtMessageService.class){
			if (taskQueue != null){
				return;
			}
			taskQueueThread = new Thread(){
				public void run(){
					while(running.get()){
						try {
							pollingWork();
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			taskQueue = new LinkedBlockingQueue<Map<String, Object>>(QUEUE_SIZE);
			running.set(true);
			taskQueueThread.start();
		}
	}

	protected void pollingWork() throws InterruptedException{
		Map<String, Object> task = taskQueue.poll(30, TimeUnit.SECONDS);
		if (task == null){
			return;
		}
		String taskType = (String) task.get(PARAM_TASK_TYPE);
		if (taskType.equals(TASK_PLAIN_TEXT_MESSAGE)){
			try {
				String toNumber = (String) task.get(PARAM_RECIEVER_NUMBER);
				Object param = task.get(PARAM_MESSAGE_DATA);
				if (!(param instanceof Map)){
					System.out.println("Send message to " + toNumber + " failed. Input data is " + param);
					return;
				}
				String message = (String) ((Map<String, Object>) param).get("message");
				System.out.println("Send message to " + toNumber+": " + message);
				sendPlainTextMessage(toNumber,message);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
	}

	private void sendPlainTextMessage(String toNumber, String message) throws Exception {
		// http://api.sczht.cc:8888/sms.aspx
		String sentMsg = "【"+getSmsSignName()+"】 "+message+getTimeStamp();
		URI uri = new URIBuilder().setScheme("http").setHost("api.sczht.cc").setPort(8888)
				.setPath("sms.aspx").addParameter("action", "send")
				.addParameter("userid", getUserId())
				.addParameter("account", getAccount())
				.addParameter("password", getPasswork())
				.addParameter("mobile", toNumber)
				.addParameter("content",sentMsg )
				.build();
		String content = httpGetRequestXml(uri);
		//Map<String, Object> responseObj = XMLDecodeUtils.decodeXmlString(content);
		if (content!=null && isSuccessResponse(content)){
			System.out.println("SMS to " + toNumber+" success:" + sentMsg);
		}else{
			System.out.println("SMS to " + toNumber+" failed.\t response is " + content);
			if (this.getSmtpService() != null) {
				String messageContent = String.format("向%s发送消息%s失败.\r\n%s", toNumber, sentMsg, content);
				this.getSmtpService().send("archerliyaqing@163.com", "短信服务失败", messageContent);
				this.getSmtpService().send("philip_chang@163.com", "短信服务失败", messageContent);
				this.getSmtpService().send("clariones@163.com", "短信服务失败", messageContent);
			}
		}
	}

	private static final Pattern ptnResponseOK = Pattern.compile("<returnstatus>\\s*success\\s*</returnstatus>", Pattern.CASE_INSENSITIVE);
	private boolean isSuccessResponse(String content) {
		Matcher m = ptnResponseOK.matcher(content);
		return m.find();
	}

	private String getSmsSignName() {
		return System.getenv("SMS_SIGN_NAME");
	}

	protected static final SimpleDateFormat fmtSmsTimpStamp = new SimpleDateFormat("HH:mm:ss");
	protected String getTimeStamp() {
		// TODO Auto-generated method stub
		return " ("+fmtSmsTimpStamp.format(new Date())+")";
	}

	protected static CloseableHttpClient getHttpClient() {
		if (httpclient != null) {
			return httpclient;
		}
		httpclient = HttpClients.createDefault();
		return httpclient;
	}
	private static String httpGetRequestXml(URI uri) throws Exception {
		CloseableHttpClient client = getHttpClient();
		HttpGet httpget = new HttpGet(uri);

		CloseableHttpResponse response = client.execute(httpget);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity, StandardCharsets.UTF_8);
		System.out.println(new Date() + "message: http-get got: " + content);
		return content;
		
	}
	
	private String getPasswork() {
		return System.getenv("SMS_PASSWORD");
	}

	private String getAccount() {
		return System.getenv("SMS_ACCOUNT");
	}

	private String getUserId() {
		return System.getenv("SMS_USERID");
	}

}
