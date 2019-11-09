/**
 * 
 */
package com.robolverap.impl.bo.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robolverap.bo.security.MailBo;
import com.robolverap.bo.security.SecurityBo;
import com.robolverap.bo.security.UsuarioBo;
import com.robolverap.dao.security.BitacoraDao;
import com.robolverap.dao.security.ParametroDao;
import com.robolverap.dao.security.UsuarioDao;
import com.robolverap.mail.plantillas.IMailTemplate;
import com.robolverap.mail.plantillas.ResetPasswordTemplate;
import com.robolverap.model.app.security.Bitacora;
import com.robolverap.model.app.security.Parametro;
import com.robolverap.model.app.security.Usuario;
import com.robolverap.web.constants.BitacoraEventClaves;
import com.robolverap.web.constants.ParametrosClaves;

/**
 * @author Roberto Olvera
 *
 */
@Service("usuarioBo")
@Transactional(readOnly = true)
public class UsuarioBoImpl implements UsuarioBo,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7324980290013956080L;
	
	@Autowired
    @Qualifier("usuarioDao")
    UsuarioDao<Usuario> usuarioDao;
	
	@Autowired
    @Qualifier("bitacoraDao")
	BitacoraDao<Bitacora> bitacoraDao;
	
	@Autowired
    @Qualifier("securityBo")
	SecurityBo securityBo;
	
	@Autowired
    @Qualifier("parametroDao")
	ParametroDao<Parametro> parametroDao;
	
	@Autowired
    @Qualifier("mailBo")
	MailBo mailBo;
    
    public void setEscalaNivelRiesgoDao(UsuarioDao<Usuario> usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

	@Override
	public Usuario findByClave(String clave) {
		return usuarioDao.findBy("clave", clave);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Usuario usu,Usuario reg) {
		Bitacora bit = new Bitacora();
		bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.DEL_USR));
		bit.setDescripcion(usu.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(reg);
		this.bitacoraDao.saveOrUpdate(bit);
		usuarioDao.delete(usu);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(Usuario usuario, Usuario userInSession) {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(usuario.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(userInSession);
		if(usuario.getUsuReg() == null) {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.ADD_USR));
			usuario.setFecReg(new Date());
			usuario.setUsuReg(userInSession);
			usuario.setResetPassword(true);
		}else {
			bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.MOD_USR));
		}
		usuario.setFecMod(new Date());
		usuario.setUsuMod(userInSession);
		this.bitacoraDao.saveOrUpdate(bit);
		usuarioDao.saveOrUpdate(usuario);
	}

	@Override
	@Transactional(readOnly = false)
	public void resetPassword(Usuario usuario, Usuario userInSession) throws MessagingException {
		Bitacora bit = new Bitacora();
		bit.setDescripcion(usuario.toString());
		bit.setFecReg(new Date());
		bit.setUsuReg(userInSession);
		bit.setEvento(bitacoraDao.findEventoByClave(BitacoraEventClaves.RESET_PASS_USR_ENVIO));
	
		this.bitacoraDao.saveOrUpdate(bit);
		
		// GENERAR TOKEN
		String token = securityBo.generaToken();
		
		
		String subject = "Reseteo de contraseña "+ this.parametroDao.findBy("clave",ParametrosClaves.SYSTEM_NAME.toString()).getValor();
		List<String> mailsTo = new ArrayList<String> ();
		mailsTo.add(usuario.getEmail());
		
		String enlace = this.parametroDao.findBy("clave",ParametrosClaves.MAIN_URL.toString()).getValor();
		enlace = enlace+ "/login/reset.xhtml?user="+usuario.getClave()+"&token="+token;
		
		String from = this.parametroDao.findBy("clave",ParametrosClaves.MAIL_MAIN_FROM.toString()).getValor();;
		// ENVIAR NOTIFICACION
		IMailTemplate mailTemplate = new ResetPasswordTemplate(subject, mailsTo, null, null, from, null, enlace);
		
		mailBo.sendMail(mailTemplate.getTemplate());
		
		usuario.setResetPassword(true);
		usuario.setResetToken(token);
		usuarioDao.saveOrUpdate(usuario);
	}
	
	

}
