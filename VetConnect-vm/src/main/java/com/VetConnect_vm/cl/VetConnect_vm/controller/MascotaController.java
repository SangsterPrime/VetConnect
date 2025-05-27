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

import com.VetConnect_vm.cl.VetConnect_vm.model.Mascota;
import com.VetConnect_vm.cl.VetConnect_vm.service.MascotaService;

@RestController
@RequestMapping("/api/v1/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<Mascota>> listar() {
        List<Mascota> mascotas = mascotaService.findAll();
        if (mascotas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mascotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscar(@PathVariable Long id) {
        return mascotaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody Mascota mascota) {
        Mascota mascotaNueva = mascotaService.saveOrUpdate(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id, @RequestBody Mascota mascota) {
        if (!mascotaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        mascota.setId(id);
        Mascota actualizada = mascotaService.saveOrUpdate(mascota);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (!mascotaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        mascotaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}