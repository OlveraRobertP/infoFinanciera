package com.robolverap.impl.bo;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.MailBo;
import com.robolverap.dao.ParametroDao;
import com.robolverap.mail.MailAttachmentFile;
import com.robolverap.mail.MailInfo;
import com.robolverap.model.app.security.Parametro;
import com.robolverap.web.constants.ParametrosClaves;

/**
 * @author jrolvera
 * 
 */
@Service("mailBo")
@Transactional(readOnly = true)
public class MailBoImpl implements MailBo, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5012324152941732112L;

	@Autowired
	@Qualifier("parametroDao")
	ParametroDao<Parametro> parametroDao;

	private static Session mailSession;

	@Override
	public void sendMail(MailInfo mail) throws MessagingException {
		
		Parametro paramHost = parametroDao.findBy("clave",ParametrosClaves.MAIL_HOST.toString());
		String host = paramHost.getValor();
		
		Parametro paramPort = parametroDao.findBy("clave",ParametrosClaves.MAIL_PORT.toString());
		String port = paramPort.getValor();
		
		Parametro paramUserName = parametroDao.findBy("clave",ParametrosClaves.MAIL_USER_NAME.toString());
		String username = paramUserName.getValor();
		
		Parametro paramPassword = parametroDao.findBy("clave",ParametrosClaves.MAIL_PASSWORD.toString());
	    String password = paramPassword.getValor();
		
		
        Properties props = System.getProperties();
    	props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		
		//CONFIGURACION PARA GMAIL
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); //TLS
        
    	mailSession = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

		Message message = new MimeMessage(mailSession);
		message.setHeader("Content-Type", "text/html; charset=\"UTF-8\"");
		message.setHeader("Content-Transfer-Encoding", "quoted-printable");

		message.setSubject(mail.getSubject());

		message.setFrom(new InternetAddress(mail.getFrom()));

		this.addRecipientToMessage(message, mail.getTo(),
				Message.RecipientType.TO);
		
	
		if (mail.getCc() != null) {
			this.addRecipientToMessage(message, mail.getCc(),
					Message.RecipientType.CC);
		}

		if (mail.getBcc() != null) {
			this.addRecipientToMessage(message, mail.getBcc(),
					Message.RecipientType.BCC);
		}
	
		

		MimeBodyPart htmlPart = new MimeBodyPart();
		htmlPart.setContent(mail.getBody(), "text/html; charset=\"UTF-8\"");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(htmlPart);
		
		if (mail.getContainFiles()) {
			List<MailAttachmentFile> filesToAttach = mail.getFiles();
			if (filesToAttach != null && filesToAttach.size() > 0) {
				
				for (MailAttachmentFile attachedFile : filesToAttach) {
					if (attachedFile != null) {
						
						try {
							String fileName = attachedFile.getFileName();
							// DataSource source = new FileDataSource(attachedFile.getFile());
							// attachment.setDataHandler(new DataHandler(source));
							MimeBodyPart attachment = new MimeBodyPart();		
							
							attachment.attachFile(attachedFile.getFile());
							attachment.setFileName(fileName);
							attachment.setDisposition(attachedFile.getAttachmentType().getValue());
							attachment.setContentID(attachedFile.getFile().getName());
							
							if (attachedFile.isContentIdProvided()) {
								attachment.setContentID("<" + attachedFile.getContentId() + ">");
							}
							
							multipart.addBodyPart(attachment);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		message.setContent(multipart);

		// send mail
		Transport.send(message);

	}

	/**
	 * Agrega el o los destinatarios al mensaje
	 * 
	 * @param message       El mesanje de correo
	 * @param recipients    Cadena que contiene el o los destinatarios, cuando sean
	 *                      varios destinatarios, cada destinatario va separados por
	 *                      comas
	 * @param recipientType El tipo de destinatario
	 * 
	 * @throws MessagingException
	 * @throws AddressException
	 */
	private void addRecipientToMessage(Message message, List<String> recipients, Message.RecipientType recipientType)
			throws AddressException, MessagingException {

		if (recipients != null && recipients.size() > 0) {
			for (String recipientItem : recipients) {
				message.addRecipient(recipientType, new InternetAddress(recipientItem));
			}
		}
	}

}