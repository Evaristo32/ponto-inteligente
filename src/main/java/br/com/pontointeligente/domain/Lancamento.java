package br.com.pontointeligente.domain;

import br.com.pontointeligente.enums.TipoLancamentoEnum;
import lombok.Getter;
import lombok.Setter;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "tb_lancamento",schema = "ponto")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lancamento")
    @SequenceGenerator(name = "seq_lancamento", sequenceName = "seq_lancamento", allocationSize = 1)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataLancamento", nullable = false)
    private Date dataLancamento;

    @Getter
    @Setter
    @Column(name = "descricaoLancamento", length = 50, nullable = false)
    private String descricaoLancamento;

    @Getter
    @Setter
    @Column(name = "localizacao")
    private String localizacao;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataCriacao", nullable = false)
    private Date dataCriacao;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataAtualizacao")
    private Date dataAtualizacao;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoLancamentoEnum",nullable = false)
    private TipoLancamentoEnum tipoLancamentoEnum;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "codigo_funcionario")
    private Funcionario funcionario;

}
