package com.flb.notas.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flb.notas.models.Nota;
import com.flb.notas.services.NotaServices;

@RestController
public class NotaController {
    @Autowired
    NotaServices nService;

    @GetMapping("/notas")
    List<Nota> all() {
        return nService.findAll();
    }

    @RequestMapping("/notas/buscar")
    List<Nota> findByTitulo(@RequestParam String titulo,
            @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha) {
        return nService.findByTituloOrFecha(titulo, fecha);
    }

    @GetMapping("notas/{id}")
    Nota find(@PathVariable int id) {
        return nService.findById(id);
    }

    @DeleteMapping("/notas/{id}")
    void delete(@PathVariable int id) {
        nService.deleteById(id);
    }

    @PostMapping("/notas")
    Nota save(@RequestBody Nota nota) {
        return nService.save(nota);
    }

    @PutMapping("/notas/{id}")
    void update(@PathVariable int id, @RequestBody Nota nota) {
        nService.update(id, nota);
    }
}
