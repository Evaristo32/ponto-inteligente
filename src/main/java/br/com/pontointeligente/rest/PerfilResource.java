package br.com.pontointeligente.rest;

import br.com.pontointeligente.dto.PerfilDTO;
import br.com.pontointeligente.response.Response;
import br.com.pontointeligente.service.PerfilService;
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
public class PerfilResource {
    private Logger logger = LoggerFactory.getLogger(PerfilResource.class);


    private final PerfilService perfilService;

    @Autowired
    public PerfilResource(PerfilService perfilService){
        this.perfilService = perfilService;
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.POST)
    public ResponseEntity<Response<PerfilDTO>> cadastrarEmpresa(@Valid @RequestBody PerfilDTO perfilDTO, BindingResult bindingResult) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando o cadastro do perfil "+perfilDTO.getNome());
        Response<PerfilDTO> response = new Response<>();
        return ResponseEntity.ok(response);
    }


    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public ResponseEntity<Response<PerfilDTO>> listarEmpresa() throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a listagem de perfil ");
        Response<PerfilDTO> response = new Response<>();
        return ResponseEntity.ok(response);
    }
}
