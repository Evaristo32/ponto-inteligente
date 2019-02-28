package br.com.pontointeligente.util;

import org.modelmapper.ModelMapper;

import java.util.Objects;

public class SingletonModelMapper {

    private static ModelMapper modelMapper;

    public SingletonModelMapper() {
    }

    public static synchronized ModelMapper getInstacia(){
        if(Objects.isNull(modelMapper)){
            return  new ModelMapper();
        }
        return modelMapper;
    }

}
