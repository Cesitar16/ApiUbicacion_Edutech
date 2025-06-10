package com.edutech.ubicacion.controllers;

import com.edutech.ubicacion.models.Comuna;
import com.edutech.ubicacion.services.ComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicacion/comunas") // Ruta base para este controlador
public class ComunaController {

    @Autowired // Inyección del servicio de comuna
    private ComunaService comunaService;

    // Obtener todas las comunas (GET)
    @GetMapping
    public ResponseEntity<List<Comuna>> getAll() {
        return ResponseEntity.ok(comunaService.getAll());
    }

    // Obtener comuna por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Comuna comuna = comunaService.getById(id);
        if (comuna != null) {
            return ResponseEntity.ok(comuna);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comuna no encontrada");
        }
    }

    // Crear nueva comuna (POST)
    @PostMapping
    public ResponseEntity<Comuna> add(@RequestBody Comuna comuna) {
        Comuna nueva = comunaService.add(comuna);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Actualizar comuna existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Comuna comuna) {
        Comuna actualizada = comunaService.update(id, comuna);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comuna no encontrada");
        }
    }

    // Eliminar comuna (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Comuna eliminada = comunaService.delete(id);
        if (eliminada != null) {
            return ResponseEntity.ok(eliminada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comuna no encontrada");
        }
    }
}