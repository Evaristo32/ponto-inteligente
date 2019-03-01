package br.com.pontointeligente.dto;

import br.com.pontointeligente.domain.Lancamento;
import br.com.pontointeligente.domain.Perfil;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FuncionarioDTO{

    private Long id;

    @NotEmpty(message = "O campo Nome é obrigatório.")
    private String nome;

    @NotEmpty(message = "O campo email é obrigatório.")
    private String email;

    @NotEmpty(message = "O campo senha é obrigatório.")
    private String senha;

    @NotEmpty(message = "O campo cpf é obrigatório.")
    @Length(min = 11,max = 11, message = "O campo cpf deve conter 11 caracteres.")
    private String cpf;

    private BigDecimal valorHora;

    private Float qtdHorasTrabalhadasDia;

    private Float qtdHorasAlmoco;

    @NotNull(message = "O campo perfil é obrigatório.")
    private PerfilDTO perfil;

    private Date dataCriacao;

    private Date dataAtualizacao;

    @NotNull(message = "O campo empresa é obrigatório.")
    private EmpresaDTO empresa;

    private List<LancamentoDTO> lancamentos;

}
