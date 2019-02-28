package br.com.pontointeligente.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_funcionario",schema = "ponto")
//@ToString
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto.seq_funcionario")
    @SequenceGenerator(name = "ponto.seq_funcionario", sequenceName = "ponto.seq_funcionario", allocationSize = 1)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Getter
    @Setter
    @Column(name = "email", nullable = false)
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
    @Column(name = "valor_Hora")
    private BigDecimal valorHora;

    @Getter
    @Setter
    @Column(name = "qtd_Hora_Trabalhadas_Dia")
    private Float qtdHorasTrabalhadasDia;

    @Getter
    @Setter
    @Column(name = "qtd_Hora_Almoco")
    private Float qtdHorasAlmoco;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "codigo_perfil")
    private Perfil perfil;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_Criacao")
    private Date dataCriacao;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_Atualizacao")
    private Date dataAtualizacao;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "codigo_empresa")
    private Empresa empresa;

    @Getter
    @Setter
    @OneToMany(mappedBy = "funcionario",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Lancamento> lancamentos;

    @PreUpdate
    public void preUpdate(){
        this.dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist(){
        final Date dateAtual = new Date();
        this.dataCriacao = dateAtual;
        this.dataAtualizacao =  dateAtual;
    }


}
