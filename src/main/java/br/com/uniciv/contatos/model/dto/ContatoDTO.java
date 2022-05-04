package br.com.uniciv.contatos.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoDTO {
	private Integer id;
	private String nome;
	private String email;
	private String telefone;
}
