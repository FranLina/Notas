package com.flb.notas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flb.notas.models.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {

    @Query("select n from Nota n where n.titulo like %?1% and n.fecha like %?2%")
    List<Nota> findByTitulo(String nombre , Date fecha);
}
