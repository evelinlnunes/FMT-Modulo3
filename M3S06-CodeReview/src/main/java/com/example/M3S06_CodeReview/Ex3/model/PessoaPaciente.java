package com.example.M3S06_CodeReview.Ex3.model;

public class PessoaPaciente {

  private String cpf;
  private String numeroConvenio;
  private String numeroPis;
  private String chavePix;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNumeroConvenio() {
    return numeroConvenio;
  }

  public void setNumeroConvenio(String numeroConvenio) {
    this.numeroConvenio = numeroConvenio;
  }

  public String getNumeroPis() {
    return numeroPis;
  }

  public void setNumeroPis(String numeroPis) {
    this.numeroPis = numeroPis;
  }

  public String getChavePix() {
    return chavePix;
  }

  public void setChavePix(String chavePix) {
    this.chavePix = chavePix;
  }
}
