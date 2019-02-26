package br.com.pontointeligente.repository;

import br.com.pontointeligente.domain.Empresa;
import lombok.val;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    @Query(value = " select e from Empresa e where e.cnpj like :cnpj")
    Optional<Empresa> isEmpresaCadastrada(@Param("cnpj") String cnpj);

}
