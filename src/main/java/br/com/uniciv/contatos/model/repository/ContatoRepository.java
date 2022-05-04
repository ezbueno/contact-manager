package br.com.uniciv.contatos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uniciv.contatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
