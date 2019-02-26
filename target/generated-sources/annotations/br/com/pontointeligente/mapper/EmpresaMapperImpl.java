package br.com.pontointeligente.mapper;

import br.com.pontointeligente.domain.Empresa;
import br.com.pontointeligente.domain.Funcionario;
import br.com.pontointeligente.dto.EmpresaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-02-26T13:32:45-0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class EmpresaMapperImpl implements EmpresaMapper {

    @Override
    public Empresa empresaDtoToEmpresa(EmpresaDTO empresaDTO) {
        if ( empresaDTO == null ) {
            return null;
        }

        Empresa empresa = new Empresa();

        empresa.setId( empresaDTO.getId() );
        empresa.setRazaoSocial( empresaDTO.getRazaoSocial() );
        empresa.setCnpj( empresaDTO.getCnpj() );
        empresa.setDataCriacao( empresaDTO.getDataCriacao() );
        empresa.setDataAtualizacao( empresaDTO.getDataAtualizacao() );
        List<Funcionario> list = empresaDTO.getFuncionarios();
        if ( list != null ) {
            empresa.setFuncionarios( new ArrayList<Funcionario>( list ) );
        }

        return empresa;
    }

    @Override
    public EmpresaDTO empresaToEmpresaDto(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaDTO empresaDTO = new EmpresaDTO();

        empresaDTO.setId( empresa.getId() );
        empresaDTO.setRazaoSocial( empresa.getRazaoSocial() );
        empresaDTO.setCnpj( empresa.getCnpj() );
        empresaDTO.setDataCriacao( empresa.getDataCriacao() );
        empresaDTO.setDataAtualizacao( empresa.getDataAtualizacao() );
        List<Funcionario> list = empresa.getFuncionarios();
        if ( list != null ) {
            empresaDTO.setFuncionarios( new ArrayList<Funcionario>( list ) );
        }

        return empresaDTO;
    }
}
