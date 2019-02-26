package br.com.pontointeligente.service;

import br.com.pontointeligente.domain.Funcionario;
import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.dto.FuncionarioDTO;

import java.util.Optional;

public interface FuncionarioService {

    /**
     * O método é responsável por cadastrar um funcionario.
     *
     * @param funcionario
     * @return
     */
    FuncionarioDTO cadastrarFuncionario(Funcionario funcionario);

    /**
     * O método é responsável por consultar um funcionario por id.
     *
     * @param id
     * @return
     */
    Optional<FuncionarioDTO> buscarFuncionarioPorCodigo(Long id);

    /**
     * O método e responsável por deletar um funcionario pelo o id informado.
     *
     * @param id
     */
    void deleteFuncionarioPorID(Long id);

    /**
     * O método e responsável por alterar o funcionario informado.
     *
     * @param funcionario
     * @return
     */
    FuncionarioDTO alterarFuncionario(Funcionario funcionario);

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
