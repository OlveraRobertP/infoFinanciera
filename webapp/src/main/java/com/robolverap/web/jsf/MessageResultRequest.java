/**
 * 
 */
package com.robolverap.web.jsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

/**
 * @author jrobolvp
 *
 */
/**
 * Almacena el resultado obtenido al realizar alguna operacion
 * @author jmgarciap
 * @version 1.0
 */
public class MessageResultRequest implements Serializable {
	
	private static final long serialVersionUID = -7689898482394153405L;

	private Severity severity; 
	
	private String summary; 
	
	private String detail;
	
	/**
	 * Constructor predeteminado
	 * 
	 * @param severity Severidad del mensaje
	 * @param summary Resumen del mensaje
	 * @param detail Detalle del mensaje
	 */
	private MessageResultRequest(Severity severity, String summary, String detail) {
		this.severity = severity;
		this.summary = summary;
		this.detail = detail;
	}
	
	/**
	 * Obtiene una instancia de la clase 
	 * {@link com.mx.schneiderelectric.commons.jsf.MessageResultRequest}
	 * 
	 * @param severity Severidad del mensaje
	 * @param summary Resumen del mensaje
	 * @param detail Detalle del mensaje
	 * @see com.mx.schneiderelectric.commons.jsf.MessageResultRequest
	 * @return La instancia de esta clase
	 */
	public static MessageResultRequest getInstance(Severity severity, String summary, String detail) {
		return new MessageResultRequest(severity, summary, detail);
	}
	
	/**
	 * Crea una nueva instancia del mensaje de tipo info o error
	 * 
	 * @param success Valor booleano de <code>true</code> que indica si es 
	 * 		un mensaje informativo o <code>false</code> en caso de que 
	 * 		el mensaje representa un error 
	 * @param summary Resumen del mensaje
	 * @param detail Detalle del mensaje
	 * @return Una instancia de la clase <code>MessageResultRequest</code> que 
	 * 		representa el mensaje a mostrar
	 */
	public static MessageResultRequest getInstance(boolean success, String summary, String detail) {
		Severity _severity = success ? FacesMessage.SEVERITY_INFO : FacesMessage.SEVERITY_ERROR;
		return new MessageResultRequest(_severity, summary, detail);
	}

	/**
	 * @return the severity
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
}