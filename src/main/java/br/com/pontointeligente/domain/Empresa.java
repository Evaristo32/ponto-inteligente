package br.com.pontointeligente.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_empresa",schema = "ponto")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresa")
    @SequenceGenerator(name = "seq_empresa", sequenceName = "seq_empresa", allocationSize = 1)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "codigo_empresa", length = 20, nullable = false)
    private String razaoSocial;

    @Getter
    @Setter
    @Column(name = "cnpj", length = 14, nullable = false,unique = true)
    private String cnpj;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    private List<Funcionario> funcionarios;
}
