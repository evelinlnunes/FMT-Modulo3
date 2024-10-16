package com.example.M3S06_CodeReview.Ex4.useCases;

public interface AdicionarEstoqueUseCase {
    void adicionar(Integer quantidade, Integer remedioId, String remedioNome, Integer remedioDosagemMg);
}
