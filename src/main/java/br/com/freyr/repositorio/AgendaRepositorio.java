package br.com.freyr.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.freyr.entidade.Agenda;

public interface AgendaRepositorio extends JpaRepository<Agenda, Long>{

}
