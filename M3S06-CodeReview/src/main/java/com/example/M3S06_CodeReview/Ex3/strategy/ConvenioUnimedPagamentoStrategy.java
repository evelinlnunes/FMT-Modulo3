package com.example.M3S06_CodeReview.Ex3.strategy;

import com.example.M3S06_CodeReview.Ex3.exceptions.RegraDeNegocioException;
import com.example.M3S06_CodeReview.Ex3.model.FormaPagamento;
import com.example.M3S06_CodeReview.Ex3.model.InformacoesPagamento;
import com.example.M3S06_CodeReview.Ex3.model.PessoaPaciente;
import com.example.M3S06_CodeReview.Ex3.exceptions.services.UnimedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvenioUnimedPagamentoStrategy implements PagamentoStrategy {

  @Autowired private UnimedService unimedService;

  @Override
  public FormaPagamento tipoDePagamento() {
    return FormaPagamento.CONVENIO_UNIMED;
  }

  @Override
  public void processaPagamento(
      PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
    if (paciente.getNumeroConvenio() == null || paciente.getCpf() == null) {
      throw new RegraDeNegocioException(
          "Informações obrigatórias nao preenchidas. Preencha Numero de Convenio e CPF.");
    }
    unimedService.processaPagamento(
        paciente.getCpf(), paciente.getNumeroConvenio(), informacoesPagamento.getCpfMedico());
  }
}
