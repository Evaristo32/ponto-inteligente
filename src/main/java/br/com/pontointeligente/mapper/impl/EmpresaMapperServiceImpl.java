package br.com.pontointeligente.mapper.impl;

import br.com.pontointeligente.domain.Empresa;
import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.mapper.EmpresaMapperService;

import java.util.List;
import java.util.Objects;

public class EmpresaMapperServiceImpl implements EmpresaMapperService {
    @Override
    public Empresa empresaDtoToEmpresa(EmpresaDTO empresaDTO) {
        if (Objects.isNull(empresaDTO)){
            return null;
        }

        return null;
    }

    @Override
    public EmpresaDTO empresaToEmpresaDto(Empresa empresa) {
        return null;
    }

    @Override
    public List<EmpresaDTO> empresaToListaEmpresaDto(List<Empresa> empresa) {
        return null;
    }
}
