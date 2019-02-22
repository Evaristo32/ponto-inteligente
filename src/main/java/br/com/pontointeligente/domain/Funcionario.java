package br.com.pontointeligente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_funcionario",schema = "ponto")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_funcionario")
    @SequenceGenerator(name = "seq_funcionario", sequenceName = "seq_funcionario", allocationSize = 1)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "nome", length = 20, nullable = false)
    private String nome;

    @Getter
    @Setter
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    @Getter
    @Setter
    @Column(name = "cpf", length = 11, nullable = false,unique = true)
    private String cpf;

    @Getter
    @Setter
    @Column(name = "valorHora", length = 20)
    private BigDecimal valorHora;

    @Getter
    @Setter
    @Column(name = "qtdHorasTrabalhadasDia", length = 20)
    private Float qtdHorasTrabalhadasDia;

    @Getter
    @Setter
    @Column(name = "qtdHorasAlmoco", length = 20)
    private Float qtdHorasAlmoco;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "codigo_perfil")
    private Perfil perfil;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataCriacao")
    private Date dataCriacao;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "codigo_empresa")
    private Empresa empresa;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    private List<Lancamento> lancamentos;


}
