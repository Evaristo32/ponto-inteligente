package br.com.pontointeligente.dto;

import br.com.pontointeligente.enums.TipoLancamentoEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class LancamentoDTO implements Serializable {

    private Long id;

    private Date dataLancamento;

    private String descricaoLancamento;

    private String localizacao;

    private Date dataCriacao;

    private Date dataAtualizacao;

    private TipoLancamentoEnum tipoLancamentoEnum;

    private FuncionarioDTO funcionario;


}
