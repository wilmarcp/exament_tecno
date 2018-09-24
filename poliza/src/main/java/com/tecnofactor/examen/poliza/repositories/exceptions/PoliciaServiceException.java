package com.tecnofactor.examen.poliza.repositories.exceptions;

public class PoliciaServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String mensaje;
	
	public PoliciaServiceException(String mensaje){
		super(mensaje);
		this.mensaje = mensaje;
	}
	
	public PoliciaServiceException(String mensaje, Exception e){
		super(mensaje, e);
		this.mensaje = mensaje;
	}
	
	public String getMensaje(){
		return this.mensaje;
	}
}
