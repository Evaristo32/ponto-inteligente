package br.com.pontointeligente.dto;

import br.com.pontointeligente.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EmpresaDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "O campo Razão Social é Obrigatório.")
    @Length(min = 1, max = 20, message = "O campo Razão Social deve conter entre 1 e 20 caractéres.")
    private String razaoSocial;

    @NotEmpty(message = "O campo Razão Social é Obrigatório.")
    private String cnpj;

    private Date dataCriacao;

    private Date dataAtualizacao;

    private List<FuncionarioDTO> funcionarios;

}
