package br.com.pontointeligente.rest;

import br.com.pontointeligente.dto.LancamentoDTO;
import br.com.pontointeligente.response.Response;
import br.com.pontointeligente.service.LancamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
   public ResponseEntity<Response<LancamentoDTO>> cadastrarLancamento(@Valid @RequestBody LancamentoDTO lancamentoDTO, BindingResult bindingResult) throws
           NoSuchAlgorithmException {
      this.logger.info("Iniciando o cadastro do lancamento "+lancamentoDTO.getDescricaoLancamento());
      Response<LancamentoDTO> response = new Response<>();
      return ResponseEntity.ok(response);
   }

   @RequestMapping(value = "/lancamento", method = RequestMethod.GET)
   public ResponseEntity<Response<LancamentoDTO>> getAllLancamento() throws
           NoSuchAlgorithmException {
      this.logger.info("Iniciando a listagem dos lancamento ");
      Response<LancamentoDTO> response = new Response<>();
      return ResponseEntity.ok(response);
   }

   @RequestMapping(value = "/lancamento/{id}", method = RequestMethod.GET, produces="application/json")
   public ResponseEntity<Response<LancamentoDTO>> findByIdLancamento(@PathVariable("id") Long id) throws
           NoSuchAlgorithmException {
      this.logger.info("Iniciando a listagem do lancamento ");
      Response<LancamentoDTO> response = new Response<>();
      response.setDatas(Arrays.asList(this.lancamentoService.buscarLancamentoPorCodigo(id).get()));
      return ResponseEntity.ok(response);
   }

   @RequestMapping(value = "/lancamento/{id}", method = RequestMethod.DELETE,produces="application/json")
   public ResponseEntity<Response<LancamentoDTO>> deleteByIdLancamento(@PathVariable("id") Long id) throws
           NoSuchAlgorithmException {
      this.logger.info("Iniciando a exclusão dolancamento ");
      Response<LancamentoDTO> response = new Response<>();
      this.lancamentoService.deleteLancamentoPorID(id);
      return ResponseEntity.ok(response);
   }

}
