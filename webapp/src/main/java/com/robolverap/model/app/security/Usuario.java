/**
 * 
 */
package com.robolverap.model.app.security;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Roberto Olvera
 *
 */
@Entity
@Table(name = "seg_usuarios")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2130653635207664086L;
	
	@Id
	@Column (name = "ID_USUARIO", unique = true, nullable = false)
	private String id;
	
	@Column (name = "CVE_USUARIO", unique = true, nullable = false, length = 15)
	private String clave;
	
	@Column (name = "NOMBRE", nullable = false, length = 45)
	private String nombre;
	
	@Column (name = "PATERNO", nullable = false, length = 45)
	private String paterno;
	
	@Column (name = "MATERNO",  length = 45)
	private String materno;
	
	@Column (name = "CONTRASENIA", nullable = true, length = 64)
	private String contraseña;
	
	@Column (name = "EMAIL", nullable = false, length = 100)
	private String email;
	
	@Column (name = "F_ALTA", nullable = false)
	private Date fecReg;
	
	@Column (name = "F_MODIF", nullable = false)
	private Date fecMod;
	
	@Column (name = "RESET_TOKEN", length = 20)
	private String resetToken;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO_ALTA")
	private Usuario usuReg;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO_MODIF")
	private Usuario usuMod;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ROL")
	private Rol rol;
	
	@Column (name = "ULTIMO_ACCESO")
	private Date ultimoAcceso;
	
	@Column (name = "RESET_PASSWORD")
	private Boolean resetPassword;
	
	@Column (name = "ACTIVO")
	private Boolean activo;

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecReg() {
		return fecReg;
	}

	public void setFecReg(Date fecReg) {
		this.fecReg = fecReg;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public Usuario getUsuReg() {
		return usuReg;
	}

	public void setUsuReg(Usuario usuReg) {
		this.usuReg = usuReg;
	}

	public Usuario getUsuMod() {
		return usuMod;
	}

	public void setUsuMod(Usuario usuMod) {
		this.usuMod = usuMod;
	}
	
	public Rol getRol() {
		return rol;
	}
	
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	

	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	public Boolean getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(Boolean resetPassword) {
		this.resetPassword = resetPassword;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		return true;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	@Override
	public String toString() {
		return "Usuario [clave=" + clave + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno
				+ ", email=" + email + ", rol=" + rol + ", ultimoAcceso=" + ultimoAcceso + ", resetPassword="
				+ resetPassword + ", activo=" + activo + "]";
	}
	
	
		
}

