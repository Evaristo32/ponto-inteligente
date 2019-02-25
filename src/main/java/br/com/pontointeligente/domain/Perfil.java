package br.com.pontointeligente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_perfil",schema = "ponto")
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto.seq_perfil")
    @SequenceGenerator(name = "ponto.seq_perfil", sequenceName = "ponto.seq_perfil", allocationSize = 1)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "nome", length = 20, nullable = false,unique = true)
    private String nome;

    @Getter
    @Setter
    @Column(name = "descricao",length = 50, nullable = false)
    private String descricao;

}
