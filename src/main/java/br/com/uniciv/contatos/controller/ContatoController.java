package br.com.uniciv.contatos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.uniciv.contatos.model.dto.ContatoDTO;
import br.com.uniciv.contatos.service.ContatoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/contatos")
@RequiredArgsConstructor
public class ContatoController {
	private final ContatoService contatoService;

	@GetMapping
	public List<ContatoDTO> todosContatos() {
		return this.contatoService.todosContatos();
	}

	@GetMapping(path = "/{id}")
	public ContatoDTO buscar(@PathVariable Integer id) {
		return this.contatoService.buscarPorId(id);
	}

	@PostMapping
	public ResponseEntity<ContatoDTO> salvar(@RequestBody ContatoDTO contatoDTO) {
		var novoContato = this.contatoService.salvar(contatoDTO);
		var uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novoContato.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
