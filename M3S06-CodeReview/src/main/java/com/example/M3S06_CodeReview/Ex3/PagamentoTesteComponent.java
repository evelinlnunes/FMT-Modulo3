package com.example.M3S06_CodeReview.Ex3;

import com.example.M3S06_CodeReview.Ex3.model.FormaPagamento;
import com.example.M3S06_CodeReview.Ex3.model.InformacoesPagamento;
import com.example.M3S06_CodeReview.Ex3.model.PessoaPaciente;
import com.example.M3S06_CodeReview.Ex3.exceptions.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoTesteComponent {

  @Autowired
  public PagamentoTesteComponent(PagamentoService service) {
    PessoaPaciente paciente1 = new PessoaPaciente();
    InformacoesPagamento pagamento1 = new InformacoesPagamento();
    service.processaPagamento(paciente1, FormaPagamento.CONVENIO_UNIMED, pagamento1, 50.0f);
  }
}
