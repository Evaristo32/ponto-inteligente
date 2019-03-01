package br.com.pontointeligente.service.impl;

import br.com.pontointeligente.domain.Funcionario;
import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.dto.FuncionarioDTO;
import br.com.pontointeligente.repository.FuncionarioRepository;
import br.com.pontointeligente.service.FuncionarioService;
import br.com.pontointeligente.util.ModelMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private Logger logger = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

    private FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public FuncionarioDTO cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        return ModelMapperUtil.map(this.funcionarioRepository.save(ModelMapperUtil.map(funcionarioDTO,Funcionario.class)),FuncionarioDTO.class);
    }

    @Override
    public FuncionarioDTO buscarFuncionarioPorCodigo(Long id) {
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);
        if(funcionario.isPresent()){
            return ModelMapperUtil.map(funcionario.get(),FuncionarioDTO.class);
        }
        return new FuncionarioDTO();
    }

    @Override
    public List<FuncionarioDTO> buscarFuncionarios() {
        return this.funcionarioRepository.findAll().stream().map(f -> ModelMapperUtil.map(f,FuncionarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteFuncionarioPorID(Long id) {
        this.funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioDTO alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        return ModelMapperUtil.map(this.funcionarioRepository.save(ModelMapperUtil.map(funcionarioDTO,Funcionario.class)),FuncionarioDTO.class);
    }

    @Override
    public Boolean isFuncionarioCadastrado(String cpf) {
        return this.funcionarioRepository.isFuncionarioCadastrado(cpf).isPresent();
    }

    @Override
    public Boolean isEmailCadastrado(String email) {
        return this.funcionarioRepository.isEmailCadastrado(email).isPresent();
    }
}
