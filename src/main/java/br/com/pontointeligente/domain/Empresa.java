package br.com.pontointeligente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;


public class Empresa {

    @Getter
    private Long id;
    @Getter
    @Setter
    private String razaoSocial;
    @Getter
    @Setter
    private String cnpj;
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
    private List<Funcionario> funcionarios;
}
