package br.com.pontointeligente.rest;

import br.com.pontointeligente.dto.LancamentoDTO;
import br.com.pontointeligente.response.Response;
import br.com.pontointeligente.service.LancamentoService;
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
public class LancamentoResource {
   private Logger logger = LoggerFactory.getLogger(LancamentoResource.class);

   private final LancamentoService lancamentoService;

   @Autowired
   public LancamentoResource(LancamentoService lancamentoService) {
      this.lancamentoService = lancamentoService;
   }

   @RequestMapping(value = "/lancamento", method = RequestMethod.POST)
   public ResponseEntity<Response<LancamentoDTO>> cadastrarEmpresa(@Valid @RequestBody LancamentoDTO lancamentoDTO, BindingResult bindingResult) throws
           NoSuchAlgorithmException {
      this.logger.info("Iniciando o cadastro do lancamento "+lancamentoDTO.getDescricaoLancamento());
      Response<LancamentoDTO> response = new Response<>();
      return ResponseEntity.ok(response);
   }


   @RequestMapping(value = "/lancamento", method = RequestMethod.GET)
   public ResponseEntity<Response<LancamentoDTO>> listarEmpresa() throws
           NoSuchAlgorithmException {
      this.logger.info("Iniciando a listagem dos lancamento ");
      Response<LancamentoDTO> response = new Response<>();
      return ResponseEntity.ok(response);
   }

}
