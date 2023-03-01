package com.flb.notas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flb.notas.models.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {

    List<Nota> findByTituloContainingAndFechaGreaterThan(String titulo, Date fecha);
}
