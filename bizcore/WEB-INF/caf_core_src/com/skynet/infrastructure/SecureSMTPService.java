package com.skynet.infrastructure;
///////////////////////////////////////////////////////////////////////////////////////////////////
//// 
//CHECK hostname -i on your system, if not getting a result //
//try to add entry to /etc/host like 127.0.0.1 <yourhost>   // 
////	
///////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;

import com.terapico.caf.BlobObject;

public class SecureSMTPService extends DefaultSMTPService {

	
	protected static void attachFiles(MimeMessage message, String body, List<BlobObject> attachments) throws MessagingException, UnsupportedEncodingException{
		BodyPart messageBodyPart = new MimeBodyPart();

		messageBodyPart.setText(body);
        // Create a multipar message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

        for(BlobObject attachement: attachments){
            messageBodyPart = new MimeBodyPart();
            DataSource source = new ByteArrayDataSource(attachement.getData(), attachement.getMimeType());
            messageBodyPart.setDataHandler(new DataHandler(source));
            
            messageBodyPart.setFileName(MimeUtility.encodeText(attachement.getFileName(), "UTF-8","B"));
            multipart.addBodyPart(messageBodyPart);
        }
        // Part two is attachment
        message.setContent(multipart);
        
        // Send the complete message parts
        
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(MimeUtility.encodeText("附件", "UTF-8","B"));
	}
	protected static void attachByteArray(MimeMessage message, String body, byte data[], String mimeType) throws MessagingException{
		BodyPart messageBodyPart = new MimeBodyPart();
		DataSource source = new ByteArrayDataSource(data, mimeType);
		messageBodyPart.setText(body);
        // Create a multipar message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

       
            messageBodyPart = new MimeBodyPart();
           
            
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("附件.xls");
            multipart.addBodyPart(messageBodyPart);
        
        // Part two is attachment
        message.setContent(multipart);
        
        // Send the complete message parts
        
	}
	
	
    protected String getPassword(){
    	return System.getenv("SMTP_PASSWORD");
    }
    protected String getUsername(){
    	return System.getenv("SMTP_USERNAME");
    }
    public void sendWithAttachment(String toExpr, String subject, String content, List<BlobObject> attachments)
			throws Exception {
    	sendEmailInternal(toExpr, subject, content, attachments);
    }

    public void send(String toExpr, String subject, String content)
			throws Exception {
    	sendEmailInternal(toExpr, subject, content, null);
    }
	protected boolean sendEmailInternal(String toExpr, String subject, String content, List<BlobObject> attachments)
			throws URISyntaxException, Exception {
		
		Properties props = new Properties();
		/*
		 * if your working in a company , you can ask your network team for
		 * the name of SMTP host server of your comapnny OR instead you can
		 * ask IPaddress of the SMTP host serevr
		 */
		// Replase the value assigned to smtpHostName String with your
		// smtphost name
		// eg : String smtpHostName="121.34.56.78";
		String fromAddress = "report@bettbio.com";
		String smtpHost="smtp.bettbio.com";
		props.put("mail.smtp.from", "report@bettbio.com");
		props.put("mail.smtp.host", "42.120.219.29");
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
		//SMTPAuthenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props,  null);
		Transport transport = session.getTransport("smtps");
		transport.connect(smtpHost, 465, getUsername(), getPassword());
		
		
		
		// Create a MImeMessage MimeMessage message = new
		// MimeMessage(session);
		MimeMessage message = new MimeMessage(session);
		InternetAddress from = new InternetAddress(fromAddress);
		// Set from address to message
		message.setFrom(from);
		InternetAddress recipients[] = InternetAddress.parse(toExpr);
		// Set to address to message , if you want to send mail to multiple
		// reciepents you have to use
		// setRecipient method
		message.setRecipients(Message.RecipientType.TO, recipients);
		// set the subject
		message.setSubject(subject);
		// set the body

		
		message.setText(content);
		
		
		if(attachments != null && !attachments.isEmpty()) {
			attachFiles(message, content, attachments);
		}
		// calling send method of javax.mail.Transport class
		//transport.send(message);
		//transport.connect();
		//transport.connect("smtp.bettbio.com", "465");
		
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		return true;
	}

	protected boolean sendHtmlEmail(String to, String subject, String content) throws AddressException, MessagingException {
		Properties props = new Properties();
		/*
		 * if your working in a company , you can ask your network team for
		 * the name of SMTP host server of your comapnny OR instead you can
		 * ask IPaddress of the SMTP host serevr
		 */
		// Replase the value assigned to smtpHostName String with your
		// smtphost name
		// eg : String smtpHostName="121.34.56.78";
		String fromAddress = "report@bettbio.com";
		String smtpHost="smtp.bettbio.com";
		props.put("mail.smtp.from", "report@bettbio.com");
		props.put("mail.smtp.host", "42.120.219.29");
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
		//SMTPAuthenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props,  null);
		Transport transport = session.getTransport("smtps");
		transport.connect(smtpHost, 465, getUsername(), getPassword());
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("report@bettbio.com"));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		//String content = value + "! product price has been changed ";
		msg.setSubject(subject);
		msg.setContent(content,"text/html;charset=utf-8");

		// Send the message
		Transport.send(msg);
		return true;
	}
}
