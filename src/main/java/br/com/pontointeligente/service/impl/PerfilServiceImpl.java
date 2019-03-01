package br.com.pontointeligente.service.impl;

import br.com.pontointeligente.domain.Perfil;
import br.com.pontointeligente.dto.PerfilDTO;
import br.com.pontointeligente.repository.PerfilRepository;
import br.com.pontointeligente.service.PerfilService;
import br.com.pontointeligente.util.ModelMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

  private Logger logger = LoggerFactory.getLogger(PerfilServiceImpl.class);

  private final PerfilRepository perfilRepository;

  @Autowired
  public PerfilServiceImpl(PerfilRepository perfilRepository){
    this.perfilRepository = perfilRepository;
  }

  @Override
  public PerfilDTO cadastrarPerfil(PerfilDTO perfilDTO) {
    logger.info("Iniciando o cadastro do perfil com o nome "+perfilDTO.getNome());
    return ModelMapperUtil.map(this.perfilRepository.save(ModelMapperUtil.map(perfilDTO,Perfil.class)),PerfilDTO.class);
  }

  @Override
  public PerfilDTO buscarPerfilPorCodigo(Long id) {
    logger.info("Iniciando a busca do perfil com o id "+id);
    Optional<Perfil> perfil = this.perfilRepository.findById(id);
    if (perfil.isPresent()){
      return ModelMapperUtil.map(perfil.get(),PerfilDTO.class);
    }
    return new PerfilDTO();
  }

  @Override
  public List<PerfilDTO> buscarPerfis() {
    logger.info("Iniciando a busca dos perfis.");
    List<Perfil> perfils = this.perfilRepository.findAll();
    if (!perfils.isEmpty()){
     return ModelMapperUtil.mapAll(perfils,PerfilDTO.class);
    }
    return new ArrayList<>();
  }

  @Override
  public void deletePerfilPorID(Long id) {
    logger.info("Iniciando a exclusão do perfil com o id "+id);
    this.perfilRepository.deleteById(id);
  }

  @Override
  public PerfilDTO alterarPerfil(PerfilDTO perfilDTO) {
    logger.info("Iniciando a alteração do perfil com o id "+perfilDTO.getId());
    return  ModelMapperUtil.map(this.perfilRepository.save(ModelMapperUtil.map(perfilDTO,Perfil.class)),PerfilDTO.class);
  }
}
