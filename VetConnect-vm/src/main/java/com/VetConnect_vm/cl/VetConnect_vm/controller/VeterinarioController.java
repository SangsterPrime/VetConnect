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

import com.VetConnect_vm.cl.VetConnect_vm.model.Veterinario;
import com.VetConnect_vm.cl.VetConnect_vm.service.VeterinarioService;

@RestController
@RequestMapping("/api/v1/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public ResponseEntity<List<Veterinario>> listar() {
        List<Veterinario> veterinarios = veterinarioService.findAll();
        if (veterinarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(veterinarios);
    }

@PatchMapping("/{id}")
public ResponseEntity<Veterinario> actualizarParcial(
    @PathVariable Long id,
    @RequestBody Map<String, Object> updates) {

    return veterinarioService.findById(id)
        .map(veterinario -> {
            updates.forEach((key, value) -> {
                
                switch (key) {
                    case "nombre":
                        veterinario.setNombre((String) value);
                        break;
                    case "email":
                        veterinario.setEmail((String) value);
                        break;
                    
                }
            });
            Veterinario actualizado = veterinarioService.saveOrUpdate(veterinario);
            return ResponseEntity.ok(actualizado);
        })
        .orElse(ResponseEntity.notFound().build());
}
    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscar(@PathVariable Long id) {
        return veterinarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veterinario> guardar(@RequestBody Veterinario veterinario) {
        Veterinario nuevo = veterinarioService.saveOrUpdate(veterinario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> actualizar(@PathVariable Long id, @RequestBody Veterinario veterinario) {
        if (!veterinarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        veterinario.setId(id);
        Veterinario actualizado = veterinarioService.saveOrUpdate(veterinario);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (!veterinarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        veterinarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}