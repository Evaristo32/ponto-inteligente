package br.com.pontointeligente.domain;

import br.com.pontointeligente.enums.TipoLancamentoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Lancamento {

    @Getter
    private Long id;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLancamento;

    @Getter
    @Setter
    private String descricaoLancamento;

    @Getter
    @Setter
    private String localizacao;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private TipoLancamentoEnum tipoLancamentoEnum;

    @Getter
    @Setter
    private Funcionario funcionario;

}
