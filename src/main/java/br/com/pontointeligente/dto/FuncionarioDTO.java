package br.com.pontointeligente.dto;

import br.com.pontointeligente.domain.Lancamento;
import br.com.pontointeligente.domain.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FuncionarioDTO implements Serializable {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private String cpf;

    private BigDecimal valorHora;

    private Float qtdHorasTrabalhadasDia;

    private Float qtdHorasAlmoco;

    private Perfil perfil;

    private Date dataCriacao;

    private Date dataAtualizacao;

    private EmpresaDTO empresa;

    private List<Lancamento> lancamentos;

}
