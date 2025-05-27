package com.VetConnect_vm.cl.VetConnect_vm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VetConnect_vm.cl.VetConnect_vm.model.Cita;
import com.VetConnect_vm.cl.VetConnect_vm.repository.CitaRepository;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public Cita saveOrUpdate(Cita cita) {
        return citaRepository.save(cita);
    }

    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    public Optional<Cita> findById(long id) {
        return citaRepository.findById(id);
    }

    public void deleteById(long id) {
        citaRepository.deleteById(id);
    }
}