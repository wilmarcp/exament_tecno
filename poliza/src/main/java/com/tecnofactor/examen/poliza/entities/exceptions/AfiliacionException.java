package com.tecnofactor.examen.poliza.entities.exceptions;

public class AfiliacionException extends Exception{

	private static final long serialVersionUID = 1L;

	private final String mensaje;
	
	public AfiliacionException(String mensaje){
		super(mensaje);
		this.mensaje = mensaje;
	}
	
	public AfiliacionException(String mensaje, Exception e){
		super(mensaje, e);
		this.mensaje = mensaje;
	}
	
	public String getMensaje(){
		return this.mensaje;
	}
	
}
