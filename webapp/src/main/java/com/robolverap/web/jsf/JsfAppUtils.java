/**
 * 
 */
package com.robolverap.web.jsf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;

import com.robolverap.web.security.ecrypt.Base64Encryption;

/**
 * @author jrobolvp
 *
 */
public class JsfAppUtils {

	/**
	 * Verifica si la peticion actual es una peticion hecha con ajax
	 * 
	 * @return Un valor de <code>true</code> si la petición fue hecha con ajax,
	 * 		<code>false</code> si fue una peticion normal, y null
	 */
	public static Boolean isAjaxRequest() {
		if (FacesContext.getCurrentInstance() != null) {
			PartialViewContext partialViewContext = FacesContext.getCurrentInstance().getPartialViewContext();
			
			return null != partialViewContext && partialViewContext.isAjaxRequest();
		}
		
		return null;
	}		
	
	public static void redirectToPage(String page) {
		redirectToPage(page, true);
	}

	public static void redirectToPage(String page, boolean isRelative) {
		ExternalContext context = FacesContext
			.getCurrentInstance()
			.getExternalContext();
		try {
			String ct = context.getRequestContextPath();
			String navigateTo = (isRelative ? "" : ct) +  page; 
			context.redirect(navigateTo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Agrega un mensaje al contexto 
	 * @param msg Datos del mensaje a mostrar
	 */
	public static void addResultMessage(MessageResultRequest msg) {
		addResultMessage(msg.getSeverity(), msg.getSummary(), msg.getDetail());
	}

	/**
	 * Agrega un mensaje al contexto con los valores proporcionados
	 * @param severity La severidad del mensaje
	 * @param messageTitle El titulo del mensaje
	 * @param messageBody El cuerpo del mensaje
	 */
	public static void addResultMessage(Severity severity, String messageTitle, String messageBody) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage fmsg = null;
		fmsg = new FacesMessage(severity, messageTitle, messageBody);
		context.addMessage(null, fmsg);
	}
	
	/**
	 * Divide una cadena (tipo parametros url, definidos en el query String)
	 * La cadena proporcionada es del tipo q=1&info=XXXX& ...
	 * Para la cadena de ejemplo:
	 * 		el tokenSplit es '&' y
	 * 		el tokenNameValue es '='
	 * 		
	 * @param content La cadena a dividir 
	 * @param tokenSplit Cadena empleada para dividir los pares nombre valor 
	 * @param tokenNameValue Cadena empleada para divir el nombre del valor
	 * @return Mapa con los pareas nombre valor
	 */
	public static Map<String, String> splitQueryString(String content, String tokenSplit, String tokenNameValue) {
		
		if (tokenSplit == null || tokenSplit.trim().length()==0 )
			return new HashMap<String, String>();
		
		Map<String, String> mapa = new HashMap<String, String>();
		String[] arrParams = content.split(tokenSplit);
		
		for (String stringItem : arrParams) {
			String[] paramItem = stringItem.split(tokenNameValue);
			
			// solo si el resultado de dividir la cadena es un arreglo de dos elementos
			if ((paramItem != null) && (paramItem.length == 2)) {
				mapa.put(paramItem[0], paramItem[1]);
			}
		}
		
		return mapa;
	}	
	
	/**
	 * Divide una cadena (tipo parametros url, definidos en el query String); la cadena viene
	 * encriptada en Base 64.
	 * 
	 * La cadena proporcionada es del tipo q=1&info=XXXX& ...
	 * Para la cadena de ejemplo:
	 * 		el tokenSplit es '&' y
	 * 		el tokenNameValue es '='
	 * 		
	 * @param content La cadena a dividir 
	 * @param tokenSplit Cadena empleada para dividir los pares nombre valor 
	 * @param tokenNameValue Cadena empleada para divir el nombre del valor
	 * @return Mapa con los pareas nombre valor
	 */

	public static Map<String, String> splitQueryStringBase64(String content, String tokenSplit, String tokenNameValue) {
		String decodedContent = Base64Encryption.decode(content);
		return splitQueryString(decodedContent, tokenSplit, tokenNameValue);
	}	
}
