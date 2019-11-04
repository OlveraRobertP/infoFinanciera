package com.robolverap.mail;

/**
 * Define el metodo para obtener la clave que se empleara como 
 * Content ID cuando se agrege  un arvhivo adjunto de tipo INLINE
 * 
 * @author jolverap
 * @version 1.0
 */
public interface ContentIdGenerator {
	String getContentID();
}
