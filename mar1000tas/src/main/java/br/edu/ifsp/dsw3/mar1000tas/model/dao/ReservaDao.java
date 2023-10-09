package br.edu.ifsp.dsw3.mar1000tas.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.dsw3.mar1000tas.model.domain.Reserva;

public interface ReservaDao extends JpaRepository<Reserva, Long> {

}
