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
  
import com.VetConnect_vm.cl.VetConnect_vm.model.Usuario;
import com.VetConnect_vm.cl.VetConnect_vm.service.UsuarioService;
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {



    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
        Usuario usuarioNuevo = usuarioService.saveOrUpdate(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNuevo);
    }

    @GetMapping(path = "/nombre-email")
    public ResponseEntity<List<Object[]>> listarNombreEmail() {
    List<Object[]> resultado = usuarioService.findNombreAndEmail();
    if (resultado.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(resultado);
}

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (!usuarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        Usuario actualizado = usuarioService.saveOrUpdate(usuario);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (!usuarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(path = "/{id}")
public ResponseEntity<Usuario> actualizarParcial(
        @PathVariable Long id,
        @RequestBody Map<String, Object> updates) {

    return usuarioService.findById(id)
        .map(usuario -> {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "nombre":
                        usuario.setNombre((String) value);
                        break;
                    case "email":
                        usuario.setEmail((String) value);
                        break;
                    // Agrega aquí más campos si tu entidad Usuario tiene más atributos
                }
            });
            Usuario actualizado = usuarioService.saveOrUpdate(usuario);
            return ResponseEntity.ok(actualizado);
        })
        .orElse(ResponseEntity.notFound().build());
}
}