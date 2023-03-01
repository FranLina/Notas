package com.flb.notas.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flb.notas.models.Nota;
import com.flb.notas.repository.NotaRepository;
import com.flb.notas.services.NotaServices;

@Service
public class NotaServicesImpl implements NotaServices {

    @Autowired
    NotaRepository nRepository;

    @Override
    public List<Nota> findAll() {
        return nRepository.findAll();
    }

    @Override
    public Nota findById(int id) {
        Optional<Nota> findById = nRepository.findById(id);
        if (findById != null) {
            return findById.get();
        }
        return null;
    }

    @Override
    public Nota save(Nota nota) {
        return nRepository.save(nota);
    }

    @Override
    public void update(int id, Nota nota) {
        this.findById(id);
        nota.setId(id);
        nRepository.save(nota);
    }

    @Override
    public void deleteById(int id) {
        nRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        nRepository.deleteAll();
    }

    @Override
    public List<Nota> findByTituloOrFecha(String titulo, Date fecha) {

        return nRepository.findByTituloContainingAndFechaGreaterThan(titulo, fecha);

    }

}
