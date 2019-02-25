package br.com.pontointeligente.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PerfilDTO implements Serializable {

    private Long id;

    private String nome;

    private String descricao;


}
