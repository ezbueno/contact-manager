package br.com.uniciv.contatos.mapper;

import java.util.List;

import br.com.uniciv.contatos.model.Contato;
import br.com.uniciv.contatos.model.dto.ContatoDTO;

public interface ContatoMapper {
	ContatoDTO deEntidadeParaDTO(Contato contato);

	Contato deDTOParaEntidade(ContatoDTO contatoDTO);

	List<ContatoDTO> deEntidadeParaListaDTO(List<Contato> contatos);
}
