package com.edutech.ubicacion.services;

import com.edutech.ubicacion.models.Provincia; // Asegúrate de tener este modelo
import com.edutech.ubicacion.repository.ProvinciaRepository; // Y este repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService {

    @Autowired // Inyecta automáticamente la dependencia del repositorio
    private ProvinciaRepository provinciaRepository;

    // Obtener todas las provincias desde la base de datos
    public List<Provincia> getAll() {
        return provinciaRepository.findAll(); // Devuelve lista de provincias
    }

    // Buscar una provincia por su ID
    public Provincia getById(Integer id) {
        Optional<Provincia> provincia = provinciaRepository.findById(id); // Busca por ID
        return provincia.orElse(null); // Si no la encuentra, retorna null
    }

    // Crear una nueva provincia
    public Provincia add(Provincia provincia) {
        return provinciaRepository.save(provincia); // Guarda y retorna la nueva provincia
    }

    // Actualizar una provincia existente
    public Provincia update(Integer id, Provincia provincia) {
        if (provinciaRepository.existsById(id)) {
            provincia.setIdProvincia(id); // Aseguramos que se use el mismo ID
            return provinciaRepository.save(provincia); // Guarda los cambios
        }
        return null; // No se encontró la provincia
    }

    // Eliminar una provincia por ID
    public Provincia delete(Integer id) {
        Optional<Provincia> provincia = provinciaRepository.findById(id);
        if (provincia.isPresent()) {
            provinciaRepository.deleteById(id); // Elimina la provincia
            return provincia.get(); // Retorna la provincia eliminada
        }
        return null; // No existe la provincia
    }
}