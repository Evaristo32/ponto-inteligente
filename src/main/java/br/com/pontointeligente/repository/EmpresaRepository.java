package br.com.pontointeligente.repository;

import br.com.pontointeligente.domain.Empresa;
import br.com.pontointeligente.dto.EmpresaDTO;
import lombok.val;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQuery;
import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    @Query(value = " select e from Empresa e where e.cnpj like :cnpj")
    Optional<Empresa> isEmpresaCadastrada(@Param("cnpj") String cnpj);

}
