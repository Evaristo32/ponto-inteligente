package br.com.pontointeligente.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_empresa",schema = "ponto")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto.seq_empresa")
    @SequenceGenerator(name = "ponto.seq_empresa", sequenceName = "ponto.seq_empresa", allocationSize = 1)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "razao_social", nullable = false)
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
    @OneToMany(mappedBy ="empresa", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @PreUpdate
    public void preUpdate()
    {
        this.dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist(){
        Date dateAtual = new Date();
        this.dataCriacao = dateAtual;
        this.dataAtualizacao =  dateAtual;
    }
}
