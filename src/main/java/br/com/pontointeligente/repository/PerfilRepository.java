package br.com.pontointeligente.repository;

import br.com.pontointeligente.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}

