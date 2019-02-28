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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@CrossOrigin(origins = "*")
public class FuncionarioResource {
    private Logger logger = LoggerFactory.getLogger(FuncionarioResource.class);

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioResource(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @RequestMapping(value = "/funcionario", method = RequestMethod.POST)
    public ResponseEntity<Response<FuncionarioDTO>> cadastrarEmpresa(@Valid @RequestBody FuncionarioDTO funcionarioDTO, BindingResult bindingResult) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando o cadastro do funcionario "+funcionarioDTO.getNome());
        Response<FuncionarioDTO> response = new Response<>();
        return ResponseEntity.ok(response);
    }


    @RequestMapping(value = "/funcionario", method = RequestMethod.GET)
    public ResponseEntity<Response<FuncionarioDTO>> listarEmpresa() throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a listagem de empresa ");
        Response<FuncionarioDTO> response = new Response<>();
        return ResponseEntity.ok(response);
    }


}
