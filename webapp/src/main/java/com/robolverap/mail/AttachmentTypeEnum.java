package com.robolverap.mail;

/**
 * Esta clase define los posibles tipos de attachments que puede tener una archivo
 * adjunto en un correo.
 * 
 * Cuando se agrega un contenido adjunto al correo, dicho archivo puede adjuntarse 
 * de dos maneras, una es que el archivo adjunto no se muestra en la seccion de archivos
 * adjuntos, sino que se emplea como contenido INLINE a usar en el contenido del correo;
 * esto es util cuando se requiere usar, por ejemplo, una imagen en un tag img dentro
 * del contenido del correo; la  otra forma es adjuntarlo normalemente - el tipo ATTACHMENT - 
 * y dicho contenido aparecera en la seccion de attachments del correo.
 * 
 * @author jrolvera
 * @version 1.0
 */
public enum AttachmentTypeEnum {

	ATTACHMENT("attachment"), INLINE("inline");
	
	private final String value;
	
	private AttachmentTypeEnum(final String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}