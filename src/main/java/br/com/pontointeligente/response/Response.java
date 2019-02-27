package br.com.pontointeligente.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class Response<T> {

    @Getter
    @Setter
    private T data;

    @Getter
    @Setter
    private List<T> datas;

    private List<String> erros;

    public List<String> getErros() {
        if (this.erros == null){
            this.erros = new ArrayList<>();
        }
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}
