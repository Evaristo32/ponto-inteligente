package br.com.pontointeligente.repository;

import br.com.pontointeligente.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {
}
