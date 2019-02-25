package br.com.pontointeligente.service.impl;

import br.com.pontointeligente.domain.Perfil;
import br.com.pontointeligente.dto.PerfilDTO;
import br.com.pontointeligente.repository.PerfilRepository;
import br.com.pontointeligente.service.PerfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

  private Logger logger = LoggerFactory.getLogger(PerfilServiceImpl.class);

  private PerfilRepository perfilRepository;

  @Autowired
  public PerfilServiceImpl(PerfilRepository perfilRepository){
    this.perfilRepository = perfilRepository;
  }

  @Override
  public PerfilDTO cadastrarPerfil(Perfil perfil) {
    return null;
  }

  @Override
  public Optional<PerfilDTO> buscarPerfilPorCodigo(Long id) {
    return null;
  }

  @Override
  public void deletePerfilPorID(Long id) {

  }

  @Override
  public PerfilDTO alterarPerfil(Perfil perfil) {
    return null;
  }
}
