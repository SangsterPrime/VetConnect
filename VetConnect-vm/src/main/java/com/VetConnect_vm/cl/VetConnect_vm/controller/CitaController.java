package com.VetConnect_vm.cl.VetConnect_vm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VetConnect_vm.cl.VetConnect_vm.model.Cita;
import com.VetConnect_vm.cl.VetConnect_vm.service.CitaService;

@RestController
@RequestMapping("/api/v1/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<Cita>> listar() {
        List<Cita> citas = citaService.findAll();
        if (citas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscar(@PathVariable Long id) {
        return citaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("/{id}")
public ResponseEntity<Cita> actualizarParcial(
        @PathVariable Long id,
        @RequestBody Map<String, Object> updates) {

    return citaService.findById(id)
        .map(cita -> {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "fecha":
                        cita.setFecha(java.time.LocalDateTime.parse((String) value));
                        break;
                    // Agrega más campos si tu entidad Cita tiene más atributos
                }
            });
            Cita actualizada = citaService.saveOrUpdate(cita);
            return ResponseEntity.ok(actualizada);
        })
        .orElse(ResponseEntity.notFound().build());
}
    @PostMapping
    public ResponseEntity<Cita> guardar(@RequestBody Cita cita) {
        Cita nueva = citaService.saveOrUpdate(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizar(@PathVariable Long id, @RequestBody Cita cita) {
        if (!citaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cita.setId(id);
        Cita actualizada = citaService.saveOrUpdate(cita);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (!citaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        citaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}