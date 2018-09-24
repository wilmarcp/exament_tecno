package com.tecnofactor.examen.poliza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnofactor.examen.poliza.entities.Asegurado;

public interface AseguradoDao extends JpaRepository<Asegurado, String> {

}
