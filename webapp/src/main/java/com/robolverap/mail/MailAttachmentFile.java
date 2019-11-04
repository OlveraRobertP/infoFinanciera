package com.robolverap.mail;

import java.io.File;

/**
 * Define el contenido de un archivo que estara disponible como
 * contenido adjunto en un correo
 * @author jrolvera
 * @version 1.0
 */
public class MailAttachmentFile {

	private File file;
	
	private AttachmentTypeEnum attachmentType;
	
	private String contentId;

	/**
	 * Constuctor predeterminado que construye un tipo de archivo adjunto especificando
	 * el archivo.
	 * 
	 * El tipo de archivo adjunto que establece este constructor es de tipo 
	 * <code>ATTACHMENT</code>
	 * 
	 * @param file El archivo a adjuntar
	 * 
	 */
	private MailAttachmentFile(File file) {
		this.file = file;
		this.attachmentType = AttachmentTypeEnum.ATTACHMENT;
		this.contentId = "";
	}

	/**
	 * Construye una instancia de <code>MailAttachmentFile</code> especificando
	 * la ruta del archivo
	 *  
	 * @param pathFile
	 */
	private MailAttachmentFile(String pathFile) {
		this(new File(pathFile));
	}

	/**
	 * Crea una instancia de <code>MailAttachmentFile</code> especificando el archivo, el tipo de 
	 * attachment, asi como el generador de content Id
	 * 
	 * @param file 
	 * 		El archivo a adjuntar
	 * @param attachmentType 
	 * 		El tipo de attachment
	 * @param contentIdGenerator 
	 * 		La clase empleada para generar el ContentID; 
	 * 		esta clase tiene importancia cuando el tipo de attachmnet es <code>AttachmentTypeEnum.INLINE</code>
	 * 		si el tipo es <code>AttachmentTypeEnum.ATTACHMENT</code> el ContentIdGenerator se ignora;
	 * 		si no se especifica el ContentIdGenerator (null) o lo que es lo mismo null, 
	 * 		automaticamente se establece el tipo de attachment a <code>AttachmentTypeEnum.ATTACHMENT</code> 
	 */
	private MailAttachmentFile(File file, AttachmentTypeEnum attachmentType, ContentIdGenerator contentIdGenerator) {
		this.file = file;
		this.attachmentType = attachmentType;
		this.contentId = "";
		
		if (attachmentType == AttachmentTypeEnum.INLINE) {
			if (contentIdGenerator != null) {
				this.contentId = contentIdGenerator.getContentID();	
			} else {
				this.attachmentType = AttachmentTypeEnum.ATTACHMENT;
			}
		}
	}

	/**
	 * Crea una instancia de <code>MailAttachmentFile</code> especificando el archivo, el tipo de 
	 * attachment, asi como el generador de content Id
	 * 
	 * @param pathFile
	 * 		La ruta del archivo
	 * @param attachmentType 
	 * 		El tipo de attachment
	 * @param contentIdGenerator 
	 * 		La clase empleada para generar el ContentID; 
	 * 		esta clase tiene importancia cuando el tipo de attachmnet es <code>AttachmentTypeEnum.INLINE</code>
	 * 		si el tipo es <code>AttachmentTypeEnum.ATTACHMENT</code> el ContentIdGenerator se ignora;
	 * 		si no se especifica el ContentIdGenerator (null) o lo que es lo mismo null, 
	 * 		automaticamente se establece el tipo de attachment a <code>AttachmentTypeEnum.ATTACHMENT</code> 
	 */
	private MailAttachmentFile(String pathFile, AttachmentTypeEnum attachmentType, ContentIdGenerator contentIdGenerator) {
		this(new File(pathFile), attachmentType, contentIdGenerator);
	}

	/**
	 * Obtiene una instancia del tipo de archivo, como ATTACHMENT
	 * @param file El archivo a adjuntar
	 * @return Una instancia de esta clase
	 */
	public static MailAttachmentFile getInstance(File file) {
		return new MailAttachmentFile(file);
	}

	/**
	 * Obtiene una instancia del tipo de archivo, como ATTACHMENT
	 * @param pathFile La ruta del archivo a adjuntar
	 * @return Una instancia de esta clase
	 */
	public static MailAttachmentFile getInstance(String pathFile) {
		return new MailAttachmentFile(pathFile);
	}

	/**
	 * Obtiene una instancia de esta clase especificando el archivo, el tipo de attachment
	 * y el contentid generator
	 * 
	 * @param file 
	 * 		El archivo a adjuntar
	 * @param attachmentType 
	 * 		El tipo de attachment
	 * @param contentIdGenerator 
	 * 		La clase empleada para generar el ContentID; 
	 * 		esta clase tiene importancia cuando el tipo de attachmnet es <code>AttachmentTypeEnum.INLINE</code>
	 * 		si el tipo es <code>AttachmentTypeEnum.ATTACHMENT</code> el ContentIdGenerator se ignora;
	 * 		si no se especifica el ContentIdGenerator (null) o lo que es lo mismo null, 
	 * 		automaticamente se establece el tipo de attachment a <code>AttachmentTypeEnum.ATTACHMENT</code> 
	 * @return
	 * 		Una instancia de esta clase
	 */
	public static MailAttachmentFile getInstance(File file, AttachmentTypeEnum attachmentType, ContentIdGenerator contentIdGenerator) {
		return new MailAttachmentFile(file, attachmentType, contentIdGenerator);
	}

	/**
	 * Obtiene una instancia de esta clase especificando la ruta del archivo, el tipo de attachment
	 * y el contentid generator
	 * 
	 * @param pathFile
	 * 		La ruta del archivo
	 * @param attachmentType 
	 * 		El tipo de attachment
	 * @param contentIdGenerator 
	 * 		La clase empleada para generar el ContentID; 
	 * 		esta clase tiene importancia cuando el tipo de attachmnet es <code>AttachmentTypeEnum.INLINE</code>
	 * 		si el tipo es <code>AttachmentTypeEnum.ATTACHMENT</code> el ContentIdGenerator se ignora;
	 * 		si no se especifica el ContentIdGenerator (null) o lo que es lo mismo null, 
	 * 		automaticamente se establece el tipo de attachment a <code>AttachmentTypeEnum.ATTACHMENT</code> 
	 * @return
	 * 		Una instancia de esta clase
	 */
	public static MailAttachmentFile getInstance(String pathFile, AttachmentTypeEnum attachmentType, ContentIdGenerator contentIdGenerator) {
		return new MailAttachmentFile(pathFile, attachmentType, contentIdGenerator);
	}

	public String getFileName() {
		String fileName = "";
		
		if (this.file != null) {
			fileName = this.file.getName();
		}
		
		return fileName;
	}

	/**
	 * Indica si el content id del archivo ha sido especificado
	 * @return
	 */
	public boolean isContentIdProvided() {
		boolean contentIdProvided = (this.contentId != null && this.contentId.length() > 0);
		return contentIdProvided;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @return the attachmentType
	 */
	public AttachmentTypeEnum getAttachmentType() {
		return attachmentType;
	}

	/**
	 * @return the contentId
	 */
	public String getContentId() {
		return contentId;
	}
}