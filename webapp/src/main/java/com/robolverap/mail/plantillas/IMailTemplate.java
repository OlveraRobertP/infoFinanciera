/**
 * 
 */
package com.robolverap.mail.plantillas;

import com.robolverap.mail.MailInfo;

/**
 * @author jrolvera
 * 
 */
public interface IMailTemplate {
    /**
     * Obtiene la informacion necesaria para el envio de correo de colaboracion
     * 
     * @return La informacion del correo a enviar
     */
    MailInfo getTemplate();
    
  
    
}