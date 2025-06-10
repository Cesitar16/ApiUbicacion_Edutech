package com.edutech.ubicacion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.ubicacion.repository.ComunaRepository;
import com.edutech.ubicacion.models.Comuna;

import java.util.List;
import java.util.Optional;

@Service
public class ComunaService {

    @Autowired // Inyecta automáticamente la dependencia del repositorio
    private ComunaRepository comunaRepository;

    // Obtener todas las comunas desde la base de datos
    public List<Comuna> getAll() {
        return comunaRepository.findAll(); // Devuelve lista de comunas
    }

    // Buscar una comuna por su ID
    public Comuna getById(Integer id) {
        Optional<Comuna> comuna = comunaRepository.findById(id); // Busca por ID
        return comuna.orElse(null); // Si no la encuentra, retorna null
    }

    // Crear una nueva comuna
    public Comuna add(Comuna comuna) {
        return comunaRepository.save(comuna); // Guarda y retorna la nueva comuna
    }

    // Actualizar una comuna existente
    public Comuna update(Integer id, Comuna comuna) {
        if (comunaRepository.existsById(id)) {
            comuna.setIdComuna(id); // Aseguramos que se use el mismo ID
            return comunaRepository.save(comuna); // Guarda los cambios
        }
        return null; // No se encontró la comuna
    }

    // Eliminar una comuna por ID
    public Comuna delete(Integer id) {
        Optional<Comuna> comuna = comunaRepository.findById(id);
        if (comuna.isPresent()) {
            comunaRepository.deleteById(id); // Elimina la comuna
            return comuna.get(); // Retorna la comuna eliminada
        }
        return null; // No existe la comuna
    }
}