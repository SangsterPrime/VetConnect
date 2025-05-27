package com.VetConnect_vm.cl.VetConnect_vm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VetConnect_vm.cl.VetConnect_vm.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}