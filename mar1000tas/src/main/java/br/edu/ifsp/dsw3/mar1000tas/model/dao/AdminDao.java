package br.edu.ifsp.dsw3.mar1000tas.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.dsw3.mar1000tas.model.domain.Admin;

public interface AdminDao extends JpaRepository <Admin, Long> {
    
}