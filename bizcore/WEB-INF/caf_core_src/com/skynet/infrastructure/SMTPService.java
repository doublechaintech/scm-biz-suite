package com.skynet.infrastructure;

import java.util.List;

import com.terapico.caf.BlobObject;

public interface SMTPService {

	public void send(String to, String subject, String content) throws Exception;
	public void sendWithAttachment(String to, String subject, String content, List<BlobObject> attachments) throws Exception;
	public void sendHtml(String to, String subject, String content);

}
