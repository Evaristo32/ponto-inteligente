package br.com.pontointeligente.rest;

import br.com.pontointeligente.dto.EmpresaDTO;
import br.com.pontointeligente.dto.FormCadastroEmpresaDTO;
import br.com.pontointeligente.response.Response;
import br.com.pontointeligente.service.EmpresaService;
import br.com.pontointeligente.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmpresaResource {
    private Logger logger = LoggerFactory.getLogger(EmpresaResource.class);

    private final EmpresaService empresaService;
    private final FuncionarioService funcionarioService;

    @Autowired
    public EmpresaResource(EmpresaService empresaService, FuncionarioService funcionarioService) {
        this.empresaService = empresaService;
        this.funcionarioService = funcionarioService;
    }

    @RequestMapping(value = "/empresa", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<Response<EmpresaDTO>> createEmpresa(@Valid @RequestBody FormCadastroEmpresaDTO formCadastroEmpresaDTO, BindingResult bindingResult) throws
            NoSuchAlgorithmException {

        this.logger.info("Iniciando o cadastro da empresa " + formCadastroEmpresaDTO.getCnpj());
        Response<EmpresaDTO> responseEmpresaDTO = new Response<>();

        this.logger.info("Validando os dados para o cadastro.");
        bindingResult = this.empresaService.isValidEmpresa(formCadastroEmpresaDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            this.logger.info("Erro validado " + formCadastroEmpresaDTO.getCnpj());
            bindingResult.getAllErrors().forEach(error -> responseEmpresaDTO.getErros().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(responseEmpresaDTO);
        }

        EmpresaDTO empresaDTO = this.empresaService.cadastrarEmpresa(formCadastroEmpresaDTO);
        List<EmpresaDTO> empresaDTOS = Arrays.asList(empresaDTO);
        responseEmpresaDTO.setDatas(empresaDTOS);
        return ResponseEntity.ok(responseEmpresaDTO);
    }

    @RequestMapping(value = "/empresa", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Response<EmpresaDTO>> findAllEmpresas() throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a listagem de empresa ");

        Response<EmpresaDTO> empresaDTOResponse = new Response<>();
        List<EmpresaDTO> empresaDTOS = this.empresaService.buscarEmpresa();
        empresaDTOResponse.setDatas(empresaDTOS);
        return ResponseEntity.ok(empresaDTOResponse);
    }

    @RequestMapping(value = "/empresa/{id}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Response<EmpresaDTO>> findByIdEmpresa(@PathVariable("id") Long id) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a listagem de empresa ");
        Response<EmpresaDTO> empresaDTOResponse = new Response<>();
        empresaDTOResponse.setDatas(Arrays.asList(this.empresaService.buscarEmpresaPorCodigo(id)));
        return ResponseEntity.ok(empresaDTOResponse);
    }

    @RequestMapping(value = "/empresa/{id}", method = RequestMethod.DELETE,produces="application/json")
    public ResponseEntity<Response<EmpresaDTO>> deleteByIdEmpresa(@PathVariable("id") Long id) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a exclusão da empresa ");
        Response<EmpresaDTO> empresaDTOResponse = new Response<>();
        this.empresaService.deleteEmpresaPorID(id);
        return ResponseEntity.ok(empresaDTOResponse);
    }
}
