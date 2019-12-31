package br.com.estudo.spring.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl {

	@Autowired
	private ModelMapper modelMapper;

	public <T> T conveter(Object request, Class<T> tipoDestino) {
		return modelMapper.map(request, tipoDestino);

	}

}
