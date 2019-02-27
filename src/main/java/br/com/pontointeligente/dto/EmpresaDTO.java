package br.com.pontointeligente.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

public class EmpresaDTO {
    private Long id;

    @NotEmpty(message = "O campo Razão Social é Obrigatório.")
    @Length(min = 1, max = 20, message = "O campo Razão Social deve conter entre 1 e 20 caractéres.")
    private String razaoSocial;

    @NotEmpty(message = "O campo Razão Social é Obrigatório.")
    private String cnpj;

    private Date dataCriacao;

    private Date dataAtualizacao;

    List<FuncionarioDTO> funcionarioDTOS;
}
