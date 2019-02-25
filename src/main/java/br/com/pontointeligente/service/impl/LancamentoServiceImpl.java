package br.com.pontointeligente.service.impl;

import br.com.pontointeligente.domain.Lancamento;
import br.com.pontointeligente.dto.LancamentoDTO;
import br.com.pontointeligente.repository.LancamentoRepository;
import br.com.pontointeligente.service.LancamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoServiceImpl implements LancamentoService {

   private Logger logger = LoggerFactory.getLogger(LancamentoServiceImpl.class);

   private LancamentoRepository lancamentoRepository;

   @Autowired
   public LancamentoServiceImpl(LancamentoRepository lancamentoRepository){
      this.lancamentoRepository = lancamentoRepository;
   }

   @Override
   public LancamentoDTO cadastrarLancamento(Lancamento lancamento) {
      return null;
   }

   @Override
   public Optional<LancamentoDTO> buscarLancamentoPorCodigo(Long id) {
      return null;
   }

   @Override
   public void deleteLancamentoPorID(Long id) {

   }

   @Override
   public LancamentoDTO alterarLancamento(Lancamento lancamento) {
      return null;
   }
}
