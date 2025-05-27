package com.VetConnect_vm.cl.VetConnect_vm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VetConnect_vm.cl.VetConnect_vm.model.Usuario;
import com.VetConnect_vm.cl.VetConnect_vm.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveOrUpdate(Usuario usuario) {
        return usuarioRepository.save(usuario); 
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public List<Object[]> findNombreAndEmail() {
    return usuarioRepository.findNombreAndEmail();
}
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    public void deleteById(long id) {
        usuarioRepository.deleteById(id);
    }
}