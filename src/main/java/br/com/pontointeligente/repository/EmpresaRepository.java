package br.com.pontointeligente.repository;

import br.com.pontointeligente.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
