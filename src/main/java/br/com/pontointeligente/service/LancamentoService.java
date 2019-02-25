package br.com.pontointeligente.service;

import br.com.pontointeligente.domain.Funcionario;
import br.com.pontointeligente.domain.Lancamento;
import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.dto.FuncionarioDTO;
import br.com.pontointeligente.dto.LancamentoDTO;

import java.util.Optional;

public interface LancamentoService {

    /**
     * O método é responsável por cadastrar um lancamento.
     *
     * @param lancamento
     * @return
     */
    LancamentoDTO cadastrarLancamento(Lancamento lancamento);

    /**
     * O método é responsável por consultar um lancamento por id.
     *
     * @param id
     * @return
     */
    Optional<LancamentoDTO> buscarLancamentoPorCodigo(Long id);

    /**
     * O método e responsável por deletar um lancamento pelo o id informado.
     *
     * @param id
     */
    void deleteLancamentoPorID(Long id);

    /**
     * O método e responsável por alterar o lancamento informado.
     *
     * @param lancamento
     * @return
     */
    LancamentoDTO alterarLancamento(Lancamento lancamento);

}
