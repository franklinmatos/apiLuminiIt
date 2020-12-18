package api.chalenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.chalenge.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	public EmpresaRepository repository;
}
