package com.skynet.infrastructure;

import java.util.Map;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.terapico.utils.DebugUtil;
/**
 * @author Philip
 *       MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName("兔答答");
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode("SMS_33585577");
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        smsReceiverParams.setParam("passcode", "111222");
        // 3.4 增加接收短信的号码
        batchSmsAttributes.addSmsReceiver("18628131320", smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        try {
            
            TopicMessage ret = topic.publishMessage(msg, messageAttributes);
            System.out.println("MessageId: " + ret.getMessageId());
            System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
        } 
 */
public class AliyunMessageService implements MessageService {
	
	
	
	static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

   
    //static final String accessKeyId = "LTAIjgtFYFzCSVXV";
    //static final String accessKeySecret = "aHkZZuP9vqC54LFAUrlMRlUTdmyXNi";
    
    static final String accessKeyId = "LTAIWnBvwlEfgzUT";
    static final String accessKeySecret = "9iSNfVFdo4vT35Re5VgX5r88cSi2me";
//    static final String templateId="SMS_142146358";
    static final String signName ="Art0X";
    
    protected static String toJson(Map<String, String> parameters) throws JsonProcessingException {
    	
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonResult = mapper.writerWithDefaultPrettyPrinter()
    	  .writeValueAsString(parameters);
    	return jsonResult;
    }
    
    public static SendSmsResponse sendSms(String dest, String fromWho, String template,
			Map<String, String> parameters) throws Exception {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(dest);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(template);
        
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(toJson(parameters));

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        DebugUtil.dumpAsJson(sendSmsResponse, true);
        if (!sendSmsResponse.getCode().equals("OK")) {
        	throw new Exception("发送到"+dest+"失败：" + sendSmsResponse.getCode()+"-"+sendSmsResponse.getMessage());
        }
        return sendSmsResponse;
    }
	
	
	@Override
	public void sendMessage(String dest, String fromWho, String template,
			Map<String, String> parameters) throws Exception {
		// TODO Auto-generated method stub
        sendSms(dest, fromWho, template, parameters);
        
	}

}

