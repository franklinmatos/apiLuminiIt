package api.chalenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chalenge.dto.EmpresaDTO;
import api.chalenge.dto.SomaDTO;
import api.chalenge.model.Empresa;
import api.chalenge.model.Numeros;
import api.chalenge.service.EmpresaService;

@RestController
@RequestMapping("api/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	

	@GetMapping("/find/{cnpj}")
	public ResponseEntity<EmpresaDTO> find(@PathVariable("cnpj") String cnpj) {
		
		Empresa empresa = service.repository.findByCnpj(cnpj);
		
		return ResponseEntity.ok().body( new EmpresaDTO(empresa.getEndereco()) );
	}
	
	@PostMapping("/media")
	public ResponseEntity<SomaDTO> media(@RequestBody Numeros numero) {
		
		SomaDTO soma = new SomaDTO();
		
		soma.setSoma( Math.addExact(numero.getNumero1(), numero.getNumero2())/ 2 );
		
		return ResponseEntity.ok().body( soma );
	}

}
