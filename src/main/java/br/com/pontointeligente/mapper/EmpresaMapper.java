package br.com.pontointeligente.mapper;

import br.com.pontointeligente.domain.Empresa;
import br.com.pontointeligente.dto.EmpresaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmpresaMapper {

    Empresa empresaDtoToEmpresa(EmpresaDTO empresaDTO);

    EmpresaDTO empresaToEmpresaDto(Empresa empresa);

    List<EmpresaDTO> empresaToListaEmpresaDto(List<Empresa> empresa);

}
