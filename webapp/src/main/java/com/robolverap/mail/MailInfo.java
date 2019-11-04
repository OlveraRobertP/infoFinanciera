package com.robolverap.mail;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jrolvera
 *
 */
public class MailInfo implements Serializable {

	private static final long serialVersionUID = -3961620707648259079L;

	private List<String> to;
	
	private List<String> cc;
	
	private List<String> bcc;
	
	private String subject;
	
	private String from;
	
	private String body;
	
	private List<MailAttachmentFile> files;
	

	private MailInfo() {
		this.to = new ArrayList<String>();
		this.cc = new ArrayList<String>();
		this.bcc = new ArrayList<String>();;
		this.subject = "";
		this.body = "";
	}
	
	public MailInfo(String from, List<String> to, List<String> cc, List<String> bcc, String subject, String body) {
		this();
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.body = body;
	}
	
	public MailInfo(String from, List<String> to, List<String> cc, List<String> bcc, String subject, String body,List<MailAttachmentFile> files) {
		this();
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.body = body;
		this.files = files;
	}
	
	public MailInfo(List<String> mailsTo, String subject,String body) {
	    this.to = mailsTo;
	    this.body = body;
	}

	/**
	 * Obtiene una instancia vacia de la clase <code>MailInfo</code>
	 * @return Una instancia de la clase <code>MailInfo</code>
	 */
	public static MailInfo getEmptyInstance() {
		return new MailInfo();
	}
	
	/**
	 * Obtiene una instancia de la clase <code>MailInfo</code> especificando los datos de 
	 * quien envia el correo, a quienes, si se les envia copia a ciertas personas, si se 
	 * les envia copia oculta, el asunto del correo y el cuerpo.
	 * @param from 
	 * 		Direccion de correo de origen
	 * @param to 
	 * 		Coleccion de direcciones de correo a los que se les enviara el correo
	 * @param cc 
	 * 		Coleccion de direccione de correo a los que les enviara una copia
	 * @param bcc 
	 * 		Coleccion de direcciones para los que se les enviara una copia oculta del correo
	 * @param subject Asunto del correso
	 * @param body
	 * 		Contenido del correo
	 * @return
	 * 		Obtiene una instancia de la clase <code>MailInfo</code> con los valores especificados
	 */
	public static MailInfo getInstance(String from, List<String> to, List<String> cc, List<String> bcc, String subject, String body) {
		return new MailInfo(from, to, cc, bcc, subject, body);
	}	
		
	

	@Override
	public String toString(){
		String mensaje = "\n" +
			"From:          ->" + this.from + "<- \n" +
			"To:          ->" + this.to + "<- \n" +
			"Cc:          ->" + this.cc + "<- \n" +
			"Bcc:         ->" + this.bcc + "<- \n" +
			"Subject:     ->" + this.subject + "<- \n" +
			"Body:        ->" + this.body + "<- \n";
		return mensaje;
	}



	/**
	 * @return the to
	 */
	public List<String> getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(List<String> to) {
		this.to = to;
	}

	/**
	 * @return the cc
	 */
	public List<String> getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 */
	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	/**
	 * @return the bcc
	 */
	public List<String> getBcc() {
		return bcc;
	}

	/**
	 * @param bcc the bcc to set
	 */
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * Indica si el correo contiene archivos o no
	 * @return
	 */
	public boolean getContainFiles() {
		int size = 0;
		
		if (this.files!= null) {
			size = this.files.size();
		}
		
		return size>0;
	}

	/**
	 * @return the files
	 */
	public List<MailAttachmentFile> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<MailAttachmentFile> files) {
		this.files = files;
	}  
	
	

}