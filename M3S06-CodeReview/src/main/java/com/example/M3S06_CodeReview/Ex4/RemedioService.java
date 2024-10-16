package com.example.M3S06_CodeReview.Ex4;

import com.example.M3S06_CodeReview.Ex4.useCases.AdicionarEstoqueUseCase;
import com.example.M3S06_CodeReview.Ex4.useCases.SalvarRemedioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemedioService {

    private final SalvarRemedioUseCase salvarRemedioUseCase;
    private final AdicionarEstoqueUseCase adicionarEstoqueUseCase;

    @Autowired
    public RemedioService(SalvarRemedioUseCase salvarRemedioUseCase, AdicionarEstoqueUseCase adicionarEstoqueUseCase) {

        this.salvarRemedioUseCase = salvarRemedioUseCase;
        this.adicionarEstoqueUseCase = adicionarEstoqueUseCase;
    }

    public void salvarRemedio(String nome, Integer dosagemEmMg) {
        salvarRemedioUseCase.salvar(nome, dosagemEmMg);
    }

    public void addEstoque(Integer remedioId, Integer quantidade, String remedioNome, Integer remedioDosagemMg) {
        adicionarEstoqueUseCase.adicionar(quantidade, remedioId, remedioNome, remedioDosagemMg);
    }
}
