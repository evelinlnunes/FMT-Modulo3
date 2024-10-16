package com.example.M3S06_CodeReview.shared;

import org.springframework.stereotype.Component;

@Component
public class RemedioRepository {
  public Integer save(Remedio remedio) {

    return null;
  }

  public boolean existe(Integer idR) {
    return false;
  }

  public Remedio getRemedioPorId(Integer idR) {
    return null;
  }

  public boolean existePorNome(String nomeR) {
    return false;
  }

  public Remedio getRemedioPorNome(String nomeR) {
    return null;
  }
}
