package br.com.estudo.spring.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T data;

	private List<String> erros = new ArrayList<>();

	public ResponseDTO(T data) {
		this.data = data;
	}
}
