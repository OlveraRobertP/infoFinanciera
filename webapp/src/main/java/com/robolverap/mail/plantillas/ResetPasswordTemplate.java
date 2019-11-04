package com.robolverap.mail.plantillas;

import java.util.List;

import com.robolverap.mail.MailAttachmentFile;
import com.robolverap.mail.MailInfo;

public class ResetPasswordTemplate implements IMailTemplate{
	private String subject;
	private List<String> mailsTo;
	private List<String> mailsCC;
	private List<String> mailsCCO;
	private String from;
	private List<MailAttachmentFile> files;
	private String enlace;
	
	
	/**
	 * 
	 * @param subject
	 * @param fechaVerificacion
	 * @param componentesVerificados
	 * @param mailsTo
	 * @param mailsCC
	 * @param mailsCCO
	 * @param from
	 */
	public ResetPasswordTemplate(String subject,  List<String> mailsTo,
			List<String> mailsCC, List<String> mailsCCO, String from, List<MailAttachmentFile> files, String enlace) {
		super();
		this.subject = subject;
		this.mailsTo = mailsTo;
		this.mailsCC = mailsCC;
		this.mailsCCO = mailsCCO;
		this.from = from;
		this.files = files;
		this.enlace = enlace;
	}

	@Override
	public MailInfo getTemplate() {
		StringBuilder body = new StringBuilder();

		body.append("<html><body>");
		body.append("<p><span style='font-family:arial,helvetica,sans-serif;'>");
		body.append("Se ha generado una solicitud de reseteo de contraseña. ");
		body.append("</span></p>");
		
		body.append("<p><span style='font-family:arial,helvetica,sans-serif;'>");
		body.append("Para cambiar la contraseña de click <a href='"+this.enlace+"'>aqui<a/>");
		body.append("</span></p>");
		
		body.append("<p><span style='font-family:arial,helvetica,sans-serif;'>");
		body.append("Puede copiar el siguiente enlace directamente en el navegador: <br/>");
		body.append(this.enlace);
		body.append("</span></p>");
		

		body.append("</html></body>");

		MailInfo mailInfo = new MailInfo(this.from, this.mailsTo, this.mailsCC,
				this.mailsCCO, this.subject, body.toString(),files);
		return mailInfo;
	}


}
