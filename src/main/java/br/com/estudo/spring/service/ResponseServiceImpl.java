package br.com.estudo.spring.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.estudo.spring.dto.ResponseDTO;

@Service
public class ResponseServiceImpl {

	public <T> ResponseEntity<ResponseDTO<T>> ok(T data) {
		return ResponseEntity.ok(new ResponseDTO<T>(data));
	}

}
