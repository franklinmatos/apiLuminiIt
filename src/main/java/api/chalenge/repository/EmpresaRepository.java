package api.chalenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.chalenge.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	Empresa findByCnpj(String cnpj);

}
