package com.robolverap.bo.security;

import javax.mail.MessagingException;

import com.robolverap.mail.MailInfo;

/**
 * @author jrolvera
 * 
 */
public interface MailBo {

    /**
     * Envia el correo electronico con la informacion proporcionada
     * 
     * @param mail
     *            El contenido del correo a enviar
     * @throws MessagingException
     *             En caso de fallo al enviar el correo
     */
    void sendMail(MailInfo mail) throws MessagingException;

}
