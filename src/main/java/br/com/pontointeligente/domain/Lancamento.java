package br.com.pontointeligente.domain;

import br.com.pontointeligente.enums.TipoLancamentoEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_lancamento",schema = "ponto")
public class Lancamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto.seq_lancamento")
    @SequenceGenerator(name = "ponto.seq_lancamento", sequenceName = "ponto.seq_lancamento", allocationSize = 1)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_Lancamento", nullable = false)
    private Date dataLancamento;

    @Getter
    @Setter
    @Column(name = "descricao_Lancamento", length = 50, nullable = false)
    private String descricaoLancamento;

    @Getter
    @Setter
    @Column(name = "localizacao")
    private String localizacao;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_Criacao", nullable = false)
    private Date dataCriacao;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_Atualizacao")
    private Date dataAtualizacao;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_Lancamento",nullable = false)
    private TipoLancamentoEnum tipoLancamentoEnum;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "codigo_funcionario")
    private Funcionario funcionario;


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
