package com.tecnofactor.examen.poliza.services.exceptions;

public class AfiliacionServiceException extends Exception{

	private static final long serialVersionUID = 1L;

	private final String mensaje;
	
	public AfiliacionServiceException(String mensaje){
		super(mensaje);
		this.mensaje = mensaje;
	}
	
	public AfiliacionServiceException(String mensaje, Exception e){
		super(mensaje, e);
		this.mensaje = mensaje;
	}
	
	public String getMensaje(){
		return this.mensaje;
	}
	
}
