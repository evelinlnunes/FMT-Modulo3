package com.example.M3S06_CodeReview.Ex4.useCases;

import com.example.M3S06_CodeReview.shared.Remedio;

public interface SalvarRemedioUseCase {
    Remedio salvar(String nome, Integer dosagemMg);
}
