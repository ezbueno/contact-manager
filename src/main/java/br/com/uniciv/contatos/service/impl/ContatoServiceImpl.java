package br.com.uniciv.contatos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uniciv.contatos.mapper.ContatoMapper;
import br.com.uniciv.contatos.model.dto.ContatoDTO;
import br.com.uniciv.contatos.model.repository.ContatoRepository;
import br.com.uniciv.contatos.service.ContatoService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ContatoServiceImpl implements ContatoService {
	private final ContatoRepository contatoRepository;
	private final ContatoMapper contatoMapper;

	@Override
	@Transactional(readOnly = true)
	public List<ContatoDTO> todosContatos() {
		return this.contatoMapper.deEntidadeParaListaDTO(this.contatoRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public ContatoDTO buscarPorId(Integer id) {
		return this.contatoMapper.deEntidadeParaDTO(this.contatoRepository.findById(id).orElse(null));
	}

	@Override
	public ContatoDTO salvar(ContatoDTO contatoDTO) {
		var novoContato = this.contatoRepository.save(this.contatoMapper.deDTOParaEntidade(contatoDTO));
		return this.contatoMapper.deEntidadeParaDTO(novoContato);
	}
}
