package br.com.estudo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.spring.entities.Empresa;
import br.com.estudo.spring.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl {

	@Autowired
	private EmpresaRepository repository;

	@Transactional(readOnly = true)
	public Page<Empresa> listarTodos(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Transactional
	public Empresa salvar(Empresa empresa) {
		return repository.save(empresa);
	}
	
	

}
