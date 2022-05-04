package br.com.uniciv.contatos.service;

import java.util.List;

import br.com.uniciv.contatos.model.dto.ContatoDTO;

public interface ContatoService {
	List<ContatoDTO> todosContatos();

	ContatoDTO buscarPorId(Integer id);

	ContatoDTO salvar(ContatoDTO contatoDTO);
}
