package br.com.pontointeligente.service.impl;

import br.com.pontointeligente.domain.Funcionario;
import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.dto.FuncionarioDTO;
import br.com.pontointeligente.repository.FuncionarioRepository;
import br.com.pontointeligente.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

   private Logger logger = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

   private FuncionarioRepository funcionarioRepository;

   @Autowired
   public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository){
      this.funcionarioRepository = funcionarioRepository;
   }

   @Override
   public FuncionarioDTO cadastrarFuncionario(Funcionario funcionario) {
      return null;
   }

   @Override
   public Optional<FuncionarioDTO> buscarFuncionarioPorCodigo(Long id) {
      return null;
   }

   @Override
   public void deleteFuncionarioPorID(Long id) {

   }

   @Override
   public FuncionarioDTO alterarFuncionario(Funcionario funcionario) {
      return null;
   }
}
