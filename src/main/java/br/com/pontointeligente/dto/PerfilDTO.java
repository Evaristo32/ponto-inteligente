package br.com.pontointeligente.dto;

import br.com.pontointeligente.util.ConstantsMensagens;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class PerfilDTO {

    private Long id;

    @NotEmpty(message = ConstantsMensagens.CAMPO_OBRIGATORIO)
    @Length(min = 3,max = 20)
    private String nome;

    @NotEmpty(message = ConstantsMensagens.CAMPO_OBRIGATORIO)
    @Length(min = 3,max = 50)
    private String descricao;


}
