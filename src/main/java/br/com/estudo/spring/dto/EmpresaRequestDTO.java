package br.com.estudo.spring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@CNPJ
	@NotNull(message = "{cnpj.notNull}")
	private String cnpj;
	private String razaoSocial;
}
