package br.com.pontointeligente.service.impl;

import br.com.pontointeligente.domain.Empresa;
import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.dto.FormCadastroEmpresaDTO;
import br.com.pontointeligente.repository.EmpresaRepository;
import br.com.pontointeligente.service.EmpresaService;
import br.com.pontointeligente.service.FuncionarioService;
import br.com.pontointeligente.util.SingletonModelMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import br.com.pontointeligente.mapper.EmpresaMapper;

@Service
public class EmpresaServiceImpl implements EmpresaService {

   private Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);

   private EmpresaRepository empresaRepository;
   private FuncionarioService funcionarioService;
   private ModelMapper modelMapper = SingletonModelMapper.getInstacia();

   @Autowired
   public EmpresaServiceImpl(EmpresaRepository empresaRepository,FuncionarioService funcionarioService){
      this.empresaRepository = empresaRepository;
      this.funcionarioService = funcionarioService;
   }


   @Override
   public EmpresaDTO cadastrarEmpresa(FormCadastroEmpresaDTO formCadastroEmpresaDTO) {
      logger.info("Iniciando o cadastro da empresa do CNPJ  "+ formCadastroEmpresaDTO.getCnpj() );
      Empresa empresa = new Empresa();
      empresa.setRazaoSocial(formCadastroEmpresaDTO.getRazaoSocial());
      empresa.setCnpj(formCadastroEmpresaDTO.getCnpj());
      return modelMapper.map(empresaRepository.save(empresa),EmpresaDTO.class);
   }

   @Override
   public EmpresaDTO buscarEmpresaPorCodigo(Long id) {
      logger.info("Iniciando a consulta da empresa com id  "+ id );
      Optional<Empresa> empresaConsultada = empresaRepository.findById(id);
      if(empresaConsultada.isPresent()){
         return modelMapper.map(empresaConsultada.get(),EmpresaDTO.class);
      }

      return null;
   }

   @Override
   public List<EmpresaDTO> buscarEmpresa() {
      List<Empresa> allEmpresa = empresaRepository.findAll();
      if (allEmpresa.isEmpty()){
         return  new ArrayList<>();
      }
//      return empresaMapper.empresaToListaEmpresaDto(allEmpresa);
   return null;
   }

   @Override
   public void deleteEmpresaPorID(Long id) {
      logger.info("Iniciando proceso de exclusão  "+ id );
      empresaRepository.deleteById(id);
   }

   @Override
   public EmpresaDTO alterarEmpresa(Empresa empresa) {
//      return empresaMapper.empresaToEmpresaDto(empresaRepository.save(empresa));
      return null;
   }

   @Override
   public Boolean isEmpresaCadastrada(String cnpj) {
      return empresaRepository.isEmpresaCadastrada(cnpj).isPresent();
   }

   @Override
   public BindingResult isValidEmpresa(FormCadastroEmpresaDTO formCadastroEmpresaDTO, BindingResult bindingResult) {

      this.empresaRepository.isEmpresaCadastrada(formCadastroEmpresaDTO.getCnpj())
              .ifPresent(emp -> bindingResult.addError(
                      new ObjectError("Empresa","Empresa já cadastrada na base de dados.")
              ));

         if (this.funcionarioService.isEmailCadastrado(formCadastroEmpresaDTO.getEmail())){
            bindingResult.addError(new ObjectError("E-mail","E-mail já cadastrado na base de dados."));
         }
         if (this.funcionarioService.isFuncionarioCadastrado(formCadastroEmpresaDTO.getCpf())){
            bindingResult.addError(new ObjectError("Funcionario","Funcionario com o numero de CPF:" +formCadastroEmpresaDTO.getCpf()+", já cadastrado na base de dados."));
         }


      return bindingResult;
   }

}
