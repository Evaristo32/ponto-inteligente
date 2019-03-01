package br.com.pontointeligente.service;

import br.com.pontointeligente.domain.Funcionario;
import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.dto.FuncionarioDTO;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    /**
     * O método é responsável por cadastrar um funcionario.
     *
     * @param funcionarioDTO
     * @return
     */
    FuncionarioDTO cadastrarFuncionario(FuncionarioDTO funcionarioDTO);

    /**
     * O método é responsável por consultar um funcionario por id.
     *
     * @param id
     * @return
     */
    FuncionarioDTO buscarFuncionarioPorCodigo(Long id);

    List<FuncionarioDTO> buscarFuncionarios();

    /**
     * O método e responsável por deletar um funcionario pelo o id informado.
     *
     * @param id
     */
    void deleteFuncionarioPorID(Long id);

    /**
     * O método e responsável por alterar o funcionario informado.
     *
     * @param funcionarioDTO
     * @return
     */
    FuncionarioDTO alterarFuncionario(FuncionarioDTO funcionarioDTO);

    /**
     * O método e responsável por validar se o Funcionário já se encontra
     * cadastrado na base de  dados.
     *
     * @param cpf
     * @return
     */
    Boolean isFuncionarioCadastrado(String cpf);

    /**
     * O método e responsável por validar se o email já se encontra cadastrado
     * na base de  dados.
     *
     * @param email
     * @return
     */
    Boolean isEmailCadastrado(String email);

}
