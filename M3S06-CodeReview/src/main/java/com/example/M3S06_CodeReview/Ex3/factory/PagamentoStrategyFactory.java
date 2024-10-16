package com.example.M3S06_CodeReview.Ex3.factory;

import com.example.M3S06_CodeReview.Ex3.model.FormaPagamento;
import com.example.M3S06_CodeReview.Ex3.strategy.PagamentoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PagamentoStrategyFactory {

  @Autowired private List<PagamentoStrategy> strategies;

  public PagamentoStrategy getStrategyParaPagamento(FormaPagamento formaPagamento) {
    for (PagamentoStrategy strategy : strategies) {
      if (strategy.tipoDePagamento().equals(formaPagamento)) {
        return strategy;
      }
    }
    return null;
  }
}
