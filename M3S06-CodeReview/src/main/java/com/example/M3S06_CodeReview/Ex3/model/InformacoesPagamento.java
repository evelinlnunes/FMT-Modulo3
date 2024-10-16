package com.example.M3S06_CodeReview.Ex3.model;

public class InformacoesPagamento {

  private String cpfMedico;
  private Long idTransacaoPix;

  public String getCpfMedico() {
    return cpfMedico;
  }

  public void setCpfMedico(String cpfMedico) {
    this.cpfMedico = cpfMedico;
  }

  public Long getIdTransacaoPix() {
    return idTransacaoPix;
  }

  public void setIdTransacaoPix(Long idTransacaoPix) {
    this.idTransacaoPix = idTransacaoPix;
  }
}
