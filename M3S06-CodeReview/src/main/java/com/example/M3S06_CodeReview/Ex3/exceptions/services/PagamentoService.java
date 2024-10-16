package com.example.M3S06_CodeReview.Ex3.exceptions.services;

import com.example.M3S06_CodeReview.Ex3.factory.PagamentoStrategyFactory;
import com.example.M3S06_CodeReview.Ex3.model.FormaPagamento;
import com.example.M3S06_CodeReview.Ex3.model.InformacoesPagamento;
import com.example.M3S06_CodeReview.Ex3.model.PessoaPaciente;
import com.example.M3S06_CodeReview.Ex3.strategy.PagamentoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

  @Autowired PagamentoStrategyFactory pagamentoStrategyFactory;

  public void processaPagamento(
      PessoaPaciente paciente,
      FormaPagamento formaPagamento,
      InformacoesPagamento informacoesPagamento,
      Float valor) {

    PagamentoStrategy pagamentoStrategy =
        pagamentoStrategyFactory.getStrategyParaPagamento(formaPagamento);
    pagamentoStrategy.processaPagamento(paciente, informacoesPagamento, valor);
  }
}
