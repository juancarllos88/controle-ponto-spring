package br.com.estudo.spring.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String cnpj;
	private String razaoSocial;
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;
}
