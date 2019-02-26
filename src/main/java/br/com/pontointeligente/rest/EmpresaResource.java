package br.com.pontointeligente.rest;

import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.response.Response;
import br.com.pontointeligente.service.EmpresaService;
import br.com.pontointeligente.service.FuncionarioService;
import br.com.pontointeligente.service.impl.EmpresaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/api/empresa")
@CrossOrigin(origins = "*")
public class EmpresaResource {
    private Logger logger = LoggerFactory.getLogger(EmpresaResource.class);

    private final EmpresaService empresaService;
    private final FuncionarioService funcionarioService;

    @Autowired
    public EmpresaResource(EmpresaService empresaService,FuncionarioService funcionarioService){
        this.empresaService = empresaService;
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public Response<Response> cadastrarEmpresa(@Valid EmpresaDTO empresaDTO, BindingResult bindingResult) throws
            NoSuchAlgorithmException {

        this.logger.info("Iniciando o cadastro da empresa "+empresaDTO.getCnpj());
        Response<EmpresaDTO> responseEmpresaDTO = new Response<>();

        this.logger.info("Validando os dados para o cadastro.");
        isValid(empresaDTO);
        return new Response<>();
    }

    private void isValid(EmpresaDTO empresaDTO) {
        this.empresaService.isEmpresaCadastrada(empresaDTO.getCnpj());
        // TODO - LEMBRAR DE VER COMO SERA A REGRA DE CADASTRAMENTO DE FUNCIONARIO NO CADASTRO DA EMPRESA
        this.funcionarioService.isEmailCadastrado(empresaDTO.getFuncionarios().get(0).getEmail());
        this.funcionarioService.isFuncionarioCadastrado(empresaDTO.getFuncionarios().get(0).getCpf());
    }

}
