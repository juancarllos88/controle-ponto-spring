package br.com.estudo.spring.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.estudo.spring.dto.ResponseDTO;

@Service
public class ResponseServiceImpl {

	public <T> ResponseEntity<ResponseDTO<T>> ok(T data) {
		return ResponseEntity.ok(new ResponseDTO<T>(data));
	}

	public <T> ResponseEntity<ResponseDTO<T>> create(T data) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO<T>(data));
	}

	public <T> ResponseEntity<ResponseDTO<T>> notFound() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
