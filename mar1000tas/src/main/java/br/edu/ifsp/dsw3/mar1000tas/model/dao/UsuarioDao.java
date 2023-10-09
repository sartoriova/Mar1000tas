package br.edu.ifsp.dsw3.mar1000tas.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.dsw3.mar1000tas.model.domain.Usuario;

public interface UsuarioDao extends JpaRepository <Usuario, Long> {
    
}