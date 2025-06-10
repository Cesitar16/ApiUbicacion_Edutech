package com.edutech.ubicacion.controllers;

import com.edutech.ubicacion.models.Provincia;
import com.edutech.ubicacion.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicacion/provincias") // Ruta base para este controlador
public class ProvinciaController {

    @Autowired // Inyección del servicio de provincia
    private ProvinciaService provinciaService;

    // Obtener todas las provincias (GET)
    @GetMapping
    public ResponseEntity<List<Provincia>> getAll() {
        return ResponseEntity.ok(provinciaService.getAll());
    }

    // Obtener provincia por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Provincia provincia = provinciaService.getById(id);
        if (provincia != null) {
            return ResponseEntity.ok(provincia);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Provincia no encontrada");
        }
    }

    // Crear nueva provincia (POST)
    @PostMapping
    public ResponseEntity<Provincia> add(@RequestBody Provincia provincia) {
        Provincia nueva = provinciaService.add(provincia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar provincia existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Provincia provincia) {
        Provincia actualizada = provinciaService.update(id, provincia);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Provincia no encontrada");
        }
    }

    // Eliminar provincia (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Provincia eliminada = provinciaService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Provincia no encontrada");
        }
    }
}