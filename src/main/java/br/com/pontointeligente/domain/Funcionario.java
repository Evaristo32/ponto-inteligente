package br.com.pontointeligente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Funcionario {

    @Getter
    private Long id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String senha;
    @Getter
    @Setter
    private String cpf;
    @Getter
    @Setter
    private BigDecimal valorHora;
    @Getter
    @Setter
    private Float qtdHorasTrabalhadasDia;
    @Getter
    @Setter
    private Float qtdHorasAlmoco;
    @Getter
    @Setter
    private Perfil perfil;
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
    private Empresa empresa;
    @Getter
    @Setter
    private List<Lancamento> lancamentos;

}
