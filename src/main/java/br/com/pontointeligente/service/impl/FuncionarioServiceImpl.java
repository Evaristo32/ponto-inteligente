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
    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public FuncionarioDTO cadastrarFuncionario(Funcionario funcionario) {
        Funcionario funcionarioCadastrado = this.funcionarioRepository.save(funcionario);
        return null;
    }

    @Override
    public Optional<FuncionarioDTO> buscarFuncionarioPorCodigo(Long id) {
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);
        return null;
    }

    @Override
    public void deleteFuncionarioPorID(Long id) {
        this.funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioDTO alterarFuncionario(Funcionario funcionario) {
        return null;
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
