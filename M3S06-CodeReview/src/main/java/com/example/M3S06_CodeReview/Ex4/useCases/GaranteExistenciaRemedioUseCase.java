package com.example.M3S06_CodeReview.Ex4.useCases;

import com.example.M3S06_CodeReview.shared.Remedio;

public interface GaranteExistenciaRemedioUseCase {
    Remedio obtenhaRemedio(Integer remedioId, String remedioNome, Integer remedioDosagemMg);
}
