package br.com.pontointeligente.rest;

import br.com.pontointeligente.dto.FuncionarioDTO;
import br.com.pontointeligente.response.Response;
import br.com.pontointeligente.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class FuncionarioResource {
    private Logger logger = LoggerFactory.getLogger(FuncionarioResource.class);

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioResource(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @RequestMapping(value = "/funcionario", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<Response<FuncionarioDTO>> createFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO, BindingResult bindingResult) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando o cadastro do funcionario "+funcionarioDTO.getNome());
        Response<FuncionarioDTO> response = new Response<>();
        response.setDatas(Arrays.asList(this.funcionarioService.cadastrarFuncionario(funcionarioDTO)));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/funcionario", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Response<FuncionarioDTO>> getAllFuncionario() throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a listagem dos funcionarios ");
        Response<FuncionarioDTO> response = new Response<>();
        response.setDatas(this.funcionarioService.buscarFuncionarios());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Response<FuncionarioDTO>> findById(@PathVariable("id") Long id) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a busca do funcionario com o id  "+id);
        Response<FuncionarioDTO> response = new Response<>();
        FuncionarioDTO funcionarioDTO = this.funcionarioService.buscarFuncionarioPorCodigo(id);
        if (Objects.isNull(funcionarioDTO)){
            response.getErros().add("Nenhum funcionario encontrado.");
            return ResponseEntity.badRequest().body(response);
        }
        response.setDatas(Arrays.asList(funcionarioDTO));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Response<FuncionarioDTO>> deleteById(@PathVariable("id") Long id) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a exclusão do funcionario com o id  "+id);
        this.funcionarioService.deleteFuncionarioPorID(id);
        Response<FuncionarioDTO> response = new Response<>();
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<Response<FuncionarioDTO>> changeFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO, BindingResult bindingResult) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a alteração do funcionario com o id  "+funcionarioDTO.getId());
        Response<FuncionarioDTO> response = new Response<>();
        response.setDatas(Arrays.asList(this.funcionarioService.alterarFuncionario(funcionarioDTO)));
        return ResponseEntity.ok(response);
    }

}
