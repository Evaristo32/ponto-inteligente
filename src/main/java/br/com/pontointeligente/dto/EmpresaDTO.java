package br.com.pontointeligente.dto;

import br.com.pontointeligente.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EmpresaDTO implements Serializable {

    private Long id;

    private String razaoSocial;

    private String cnpj;

    private Date dataCriacao;

    private Date dataAtualizacao;

    private List<Funcionario> funcionarios;

}
