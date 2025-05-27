package com.VetConnect_vm.cl.VetConnect_vm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VetConnect_vm.cl.VetConnect_vm.model.Veterinario;
import com.VetConnect_vm.cl.VetConnect_vm.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public Veterinario saveOrUpdate(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public List<Veterinario> findAll() {
        return veterinarioRepository.findAll();
    }

    public Optional<Veterinario> findById(long id) {
        return veterinarioRepository.findById(id);
    }

    public void deleteById(long id) {
        veterinarioRepository.deleteById(id);
    }
}