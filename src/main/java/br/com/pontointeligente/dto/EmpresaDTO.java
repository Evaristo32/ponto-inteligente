package br.com.pontointeligente.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EmpresaDTO {

    private Long id;

    @NotEmpty(message = "O campo Razão Social é Obrigatório.")
    @Length(min = 1, max = 20, message = "O campo Razão Social deve conter entre 1 e 20 caractéres.")
    private String razaoSocial;


    @NotEmpty(message = "O campo Razão Social é Obrigatório.")
    private String cnpj;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @JsonIgnore
    List<FuncionarioDTO> funcionarios;
}
