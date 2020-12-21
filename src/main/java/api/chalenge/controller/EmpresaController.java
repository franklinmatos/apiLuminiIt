package api.chalenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chalenge.dto.EmpresaDTO;
import api.chalenge.dto.MediaDTO;
import api.chalenge.model.Empresa;
import api.chalenge.model.Numeros;
import api.chalenge.service.EmpresaService;

@RestController
@CrossOrigin
@RequestMapping("api/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	

	@GetMapping("/find/{cnpj}")
	public ResponseEntity<EmpresaDTO> find(@PathVariable("cnpj") String cnpj) {
		EmpresaDTO retorno = new EmpresaDTO();
		Empresa empresa = service.repository.findByCnpj(cnpj);
		if (empresa == null) {
			retorno.setEndereco("Endereço não encontrado");
		}else {
			 retorno.setEndereco(empresa.getEndereco() );
		}
		return ResponseEntity.ok().body(retorno );
	}
	
	@PostMapping("/media")
	public ResponseEntity<MediaDTO> media(@RequestBody Numeros numero) {
		
		MediaDTO media = new MediaDTO();
		
		media.setMedia( Math.addExact(numero.getNumero1(), numero.getNumero2())/ 2 );
		
		return ResponseEntity.ok().body( media );
	}

}
