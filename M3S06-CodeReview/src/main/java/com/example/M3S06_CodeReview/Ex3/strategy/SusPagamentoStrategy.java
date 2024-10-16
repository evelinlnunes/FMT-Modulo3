package com.example.M3S06_CodeReview.Ex3.strategy;

import com.example.M3S06_CodeReview.Ex3.exceptions.RegraDeNegocioException;
import com.example.M3S06_CodeReview.Ex3.model.FormaPagamento;
import com.example.M3S06_CodeReview.Ex3.model.InformacoesPagamento;
import com.example.M3S06_CodeReview.Ex3.model.PessoaPaciente;
import com.example.M3S06_CodeReview.Ex3.exceptions.services.SusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SusPagamentoStrategy implements PagamentoStrategy {
  @Autowired private SusService susService;

  @Override
  public FormaPagamento tipoDePagamento() {
    return FormaPagamento.SUS;
  }

  @Override
  public void processaPagamento(
      PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
    if (paciente.getCpf() == null || paciente.getNumeroPis() == null) {
      throw new RegraDeNegocioException(
          "Informações obrigatórias nao preenchidas. Preencha Numero do PIS e CPF.");
    }

    susService.solicitaProcessoPagamento(paciente.getCpf(), paciente.getNumeroPis(), valor);
  }
}
