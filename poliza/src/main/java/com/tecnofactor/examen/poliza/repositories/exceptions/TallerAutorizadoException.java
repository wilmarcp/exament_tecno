package com.tecnofactor.examen.poliza.repositories.exceptions;

public class TallerAutorizadoException extends Exception{

	private static final long serialVersionUID = 1L;

	private final String mensaje;
	
	public TallerAutorizadoException(String mensaje){
		super(mensaje);
		this.mensaje = mensaje;
	}
	
	public TallerAutorizadoException(String mensaje, Exception e){
		super(mensaje, e);
		this.mensaje = mensaje;
	}
	
	public String getMensaje(){
		return this.mensaje;
	}
	
}
