package br.com.pontointeligente.dto;

import br.com.pontointeligente.domain.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FormCadastroEmpresaDTO  {

    private Long id;

    @NotEmpty(message = "O campo Nome é obrigatório.")
    private String nome;

    @NotEmpty(message = "O campo email é obrigatório.")
    @Email(message = "Email invalido.")
    private String email;

    @NotEmpty(message = "O campo senha é obrigatório.")
    private String senha;

    @NotEmpty(message = "O campo cpf é obrigatório.")
    @Length(min = 11,max = 11, message = "O campo cpf deve conter 11 caracteres.")
    @CPF(message = "Cpf invalido")
    private String cpf;

    @NotEmpty(message = "O campo Razão Social é Obrigatório.")
    @Length(min = 1, max = 20, message = "O campo Razão Social deve conter entre 1 e 20 caractéres.")
    private String razaoSocial;

    @NotEmpty(message = "O campo Cnpj é Obrigatório.")
    @Length(min = 14,max = 14, message = "O campo Cnpj deve conter 14 caracteres.")
    @CNPJ(message = "Cnpj invalido.")
    private String cnpj;



}
