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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*")
public class PerfilResource {
    private Logger logger = LoggerFactory.getLogger(PerfilResource.class);


    private final PerfilService perfilService;

    @Autowired
    public PerfilResource(PerfilService perfilService){
        this.perfilService = perfilService;
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<Response<PerfilDTO>> createPerfil(@Valid @RequestBody PerfilDTO perfilDTO, BindingResult bindingResult) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando o cadastro do perfil "+perfilDTO.getNome());
        Response<PerfilDTO> response = new Response<>();
        response.setDatas(Arrays.asList(this.perfilService.cadastrarPerfil(perfilDTO)));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.GET,  produces="application/json")
    public ResponseEntity<Response<PerfilDTO>> getAllPerfil() throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a listagem de perfil ");
        Response<PerfilDTO> response = new Response<>();
        response.setDatas(this.perfilService.buscarPerfis());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Response<PerfilDTO>> findByIdPerfil(@PathVariable("id") Long id) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a listagem de empresa ");
        Response<PerfilDTO> response = new Response<>();
        response.setDatas(Arrays.asList(this.perfilService.buscarPerfilPorCodigo(id)));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Response<PerfilDTO>> deleteByIdPerfil(@PathVariable("id") Long id) throws
            NoSuchAlgorithmException {
        this.logger.info("Iniciando a exclusão da empresa ");
        Response<PerfilDTO> response = new Response<>();
        this.perfilService.deletePerfilPorID(id);
        return ResponseEntity.ok(response);
    }
}
