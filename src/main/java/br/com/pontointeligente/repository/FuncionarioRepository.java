package br.com.pontointeligente.repository;

import br.com.pontointeligente.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {

    @Query(value = " select f from Funcionario f where f.cpf like :cpf ")
    Optional<Funcionario> isFuncionarioCadastrado(@Param("cpf") String cpf);

    @Query(value = " select f from Funcionario f where f.email like :email ")
    Optional<Funcionario> isEmailCadastrado(@Param("email") String email);

}
