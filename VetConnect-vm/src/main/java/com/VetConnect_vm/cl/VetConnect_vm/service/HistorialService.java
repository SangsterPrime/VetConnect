package com.VetConnect_vm.cl.VetConnect_vm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VetConnect_vm.cl.VetConnect_vm.model.Historial;
import com.VetConnect_vm.cl.VetConnect_vm.repository.HistorialRepository;

@Service
public class HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    public Historial saveOrUpdate(Historial historial) {
        return historialRepository.save(historial);
    }

    public List<Historial> findAll() {
        return historialRepository.findAll();
    }

    public Optional<Historial> findById(long id) {
        return historialRepository.findById(id);
    }

    public void deleteById(long id) {
        historialRepository.deleteById(id);
    }
}