package com.tecnofactor.examen.poliza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tecnofactor.examen.poliza.entities.Afiliacion;
import com.tecnofactor.examen.poliza.services.AfiliacionService;
import com.tecnofactor.examen.poliza.services.exceptions.AfiliacionServiceException;

@RestController
@RequestMapping("/api/afiliacion")
public class AfiliacionController {

	@Autowired
	private AfiliacionService afiliacionService;
	
	@PostMapping("/afiliar")
	@CrossOrigin(origins= "*", methods=RequestMethod.POST, allowedHeaders="*")
	public ResponseEntity<Afiliacion> registrar(@RequestBody Afiliacion afiliacion) throws AfiliacionServiceException{
		afiliacionService.afiliar(afiliacion);
		return new ResponseEntity<Afiliacion>(afiliacion, HttpStatus.OK);
	}
	
}
