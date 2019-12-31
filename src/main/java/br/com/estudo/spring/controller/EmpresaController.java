package br.com.estudo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.spring.dto.EmpresaRequestDTO;
import br.com.estudo.spring.dto.ResponseDTO;
import br.com.estudo.spring.entities.Empresa;
import br.com.estudo.spring.service.ConverterServiceImpl;
import br.com.estudo.spring.service.EmpresaServiceImpl;
import br.com.estudo.spring.service.ResponseServiceImpl;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private ResponseServiceImpl responseService;

	@Autowired
	private EmpresaServiceImpl empresaService;
	
	@Autowired
	private ConverterServiceImpl converterService;
	
	
	@GetMapping
	public ResponseEntity<ResponseDTO<Page<Empresa>>> listarTodos( Pageable pageable) { 
		Page<Empresa> empresas = empresaService.listarTodos(pageable);
		// return responseService.ok(new EmpresaDTO());
		return responseService.ok(empresas);
	}
	
	@PostMapping
	public ResponseEntity<ResponseDTO<Empresa>> cadastrar(EmpresaRequestDTO request){
		Empresa empresa = converterService.conveter(request, Empresa.class);
		return null;
	}
	
	
}
