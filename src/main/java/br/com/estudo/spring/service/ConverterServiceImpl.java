package br.com.estudo.spring.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl {

	@Autowired
	private ModelMapper modelMapper;

	public <T> T converter(Object request, Class<T> tipoDestino) {
		return modelMapper.map(request, tipoDestino);

	}

	public <T> Page<T> converter(Page<?> lista, Class<T> tipoDestino) {
		return lista.map(d -> converter(d, tipoDestino));
	}

}
