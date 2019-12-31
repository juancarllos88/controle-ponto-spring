package br.com.estudo.spring.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaRequestDTO implements Serializable {

	private String cpnj;
	private String razaoSocial;
}
