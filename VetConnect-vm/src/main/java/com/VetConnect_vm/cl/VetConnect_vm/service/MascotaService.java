package com.VetConnect_vm.cl.VetConnect_vm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VetConnect_vm.cl.VetConnect_vm.model.Mascota;
import com.VetConnect_vm.cl.VetConnect_vm.repository.MascotaRepository;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public Mascota saveOrUpdate(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> findById(long id) {
        return mascotaRepository.findById(id);
    }

    public void deleteById(long id) {
        mascotaRepository.deleteById(id);
    }
}