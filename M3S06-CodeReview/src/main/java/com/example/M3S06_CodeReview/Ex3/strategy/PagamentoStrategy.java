package com.example.M3S06_CodeReview.Ex3.strategy;

import com.example.M3S06_CodeReview.Ex3.model.FormaPagamento;
import com.example.M3S06_CodeReview.Ex3.model.InformacoesPagamento;
import com.example.M3S06_CodeReview.Ex3.model.PessoaPaciente;

public interface PagamentoStrategy {
  FormaPagamento tipoDePagamento();

  void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor);
}
