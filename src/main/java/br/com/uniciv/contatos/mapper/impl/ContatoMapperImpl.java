package br.com.uniciv.contatos.mapper.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.uniciv.contatos.mapper.ContatoMapper;
import br.com.uniciv.contatos.model.Contato;
import br.com.uniciv.contatos.model.dto.ContatoDTO;

@Component
public class ContatoMapperImpl implements ContatoMapper {
	@Override
	public ContatoDTO deEntidadeParaDTO(Contato contato) {
		ContatoDTO contatoDTO = new ContatoDTO();
		contatoDTO.setId(contato.getId());
		contatoDTO.setNome(contato.getNome());
		contatoDTO.setEmail(contato.getEmail());
		contatoDTO.setTelefone(contato.getTelefone());
		return contatoDTO;
	}

	@Override
	public Contato deDTOParaEntidade(ContatoDTO contatoDTO) {
		Contato contato = new Contato();
		contato.setId(contatoDTO.getId());
		contato.setNome(contatoDTO.getNome());
		contato.setEmail(contatoDTO.getEmail());
		contato.setTelefone(contatoDTO.getTelefone());
		return contato;
	}

	@Override
	public List<ContatoDTO> deEntidadeParaListaDTO(List<Contato> contatos) {
		return contatos.stream().map(this::deEntidadeParaDTO).toList();
	}
}
