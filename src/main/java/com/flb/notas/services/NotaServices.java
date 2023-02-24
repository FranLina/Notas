package com.flb.notas.services;
import java.util.Date;
import java.util.List;

import com.flb.notas.models.Nota;

public interface NotaServices {
    public List<Nota> findAll();

    public Nota findById(int id);

    public List<Nota> findByTituloOrFecha(String titulo, String fecha);

    public Nota save(Nota nota);

    public void update(int id, Nota nota);

    public void deleteById(int id);

    public void deleteAll();
}
