package br.com.estudo.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.spring.dto.EmpresaRequestDTO;
import br.com.estudo.spring.dto.EmpresaResponseDTO;
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
	public ResponseEntity<ResponseDTO<Page<EmpresaResponseDTO>>> listarTodos(Pageable pageable) {
		Page<Empresa> empresas = empresaService.listarTodos(pageable);
		Page<EmpresaResponseDTO> empresasResponseDTO = converterService.converter(empresas, EmpresaResponseDTO.class);
		return responseService.ok(empresasResponseDTO);
	}

	@PostMapping
	public ResponseEntity<ResponseDTO<EmpresaResponseDTO>> cadastrar(@Valid @RequestBody EmpresaRequestDTO request) {
		Empresa empresa = converterService.converter(request, Empresa.class);
		Empresa empresaSalva = empresaService.salvar(empresa);
		EmpresaResponseDTO empresaResponseDTO = converterService.converter(empresaSalva, EmpresaResponseDTO.class);
		return responseService.create(empresaResponseDTO);
	}

}
