package com.VetConnect_vm.cl.VetConnect_vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VetConnect_vm.cl.VetConnect_vm.model.Historial;
import com.VetConnect_vm.cl.VetConnect_vm.service.HistorialService;

@RestController
@RequestMapping("/api/v1/historiales")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping
    public ResponseEntity<List<Historial>> listar() {
        List<Historial> historiales = historialService.findAll();
        if (historiales.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(historiales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historial> buscar(@PathVariable Long id) {
        return historialService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Historial> guardar(@RequestBody Historial historial) {
        Historial nuevo = historialService.saveOrUpdate(historial);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historial> actualizar(@PathVariable Long id, @RequestBody Historial historial) {
        if (!historialService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        historial.setId(id);
        Historial actualizado = historialService.saveOrUpdate(historial);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (!historialService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        historialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}