package br.com.pontointeligente.service;

import br.com.pontointeligente.domain.Empresa;
import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.dto.FormCadastroEmpresaDTO;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    /**
     * O método é responsável por cadastrar uma empresa.
     *
     * @param empresa
     * @return
     */
    EmpresaDTO cadastrarEmpresa(FormCadastroEmpresaDTO empresa);

    /**
     * O método é responsável por consultar uma empresa por id.
     *
     * @param id
     * @return
     */
    EmpresaDTO buscarEmpresaPorCodigo(Long id);

    List<EmpresaDTO> buscarEmpresa();

    /**
     * O método e responsável por deletar uma empresa pelo o id informado.
     *
     * @param id
     */
    void deleteEmpresaPorID(Long id);

    /**
     * O método e responsável por alterar a empresa informada.
     *
     * @param empresa
     * @return
     */
    EmpresaDTO alterarEmpresa(Empresa empresa);

    /**
     * O método e responsável por validar se a empresa já esta cadastrada
     * na base de dados.
     *
     * @param cnpj
     * @return
     */
    Boolean isEmpresaCadastrada(String cnpj);

    /**
     * O método e responsável por validar se os dados informado para cadastrar a empresa estão validos.
     *
     * @param formCadastroEmpresaDTO
     * @param bindingResult
     * @return
     */
    BindingResult isValidEmpresa(FormCadastroEmpresaDTO formCadastroEmpresaDTO, BindingResult bindingResult);

}
