package com.VetConnect_vm.cl.VetConnect_vm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.VetConnect_vm.cl.VetConnect_vm.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u.nombre, u.email FROM Usuario u")
    List<Object[]> findNombreAndEmail();
}