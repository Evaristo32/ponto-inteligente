package br.com.pontointeligente.domain;

import lombok.Getter;
import lombok.Setter;

public class Perfil {

    @Getter
    private Long id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String descricao;


}
