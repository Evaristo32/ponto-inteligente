package br.com.pontointeligente.service.impl;

import br.com.pontointeligente.domain.Empresa;
import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.mapper.EmpresaMapper;
import br.com.pontointeligente.repository.EmpresaRepository;
import br.com.pontointeligente.service.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

   private Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);

   private EmpresaRepository empresaRepository;
   private EmpresaMapper empresaMapper;

   @Autowired
   public EmpresaServiceImpl(EmpresaRepository empresaRepository){
      this.empresaRepository = empresaRepository;
   }


   @Override
   public EmpresaDTO cadastrarEmpresa(Empresa empresa) {
      logger.info("Iniciando o cadastro da empresa do CNPJ  "+ empresa.getCnpj() );
      return empresaMapper.empresaToEmpresaDto(empresaRepository.save(empresa));
   }

   @Override
   public EmpresaDTO buscarEmpresaPorCodigo(Long id) {
      logger.info("Iniciando a consulta da empresa com id  "+ id );
      Optional<Empresa> empresaConsultada = empresaRepository.findById(id);
      if(empresaConsultada.isPresent()){
         return empresaMapper.empresaToEmpresaDto(empresaConsultada.get());
      }

      return null;
   }

   @Override
   public void deleteEmpresaPorID(Long id) {
      logger.info("Iniciando proceso de exclusão  "+ id );
      empresaRepository.deleteById(id);
   }

   @Override
   public EmpresaDTO alterarEmpresa(Empresa empresa) {
      return empresaMapper.empresaToEmpresaDto(empresaRepository.save(empresa));
   }
}
