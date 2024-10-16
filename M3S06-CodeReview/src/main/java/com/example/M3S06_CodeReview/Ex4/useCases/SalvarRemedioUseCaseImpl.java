package com.example.M3S06_CodeReview.Ex4.useCases;

import com.example.M3S06_CodeReview.Ex4.ParametroInvalidoException;
import com.example.M3S06_CodeReview.shared.Remedio;
import com.example.M3S06_CodeReview.shared.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarRemedioUseCaseImpl implements SalvarRemedioUseCase {

    @Autowired
    private RemedioRepository remedioRepository;

    @Override
    public Remedio salvar(String nome, Integer dosagemEmMg) {
        validaExistenciaDeNome(nome);
        validaExistenciaDeDosagem(dosagemEmMg);
        validaDosagemPositiva(dosagemEmMg);

        Remedio remedio = new Remedio();
        remedio.setNome(nome);
        remedio.dosagemMg(dosagemEmMg);

        remedioRepository.save(remedio);

        return remedio;
    }

    private void validaExistenciaDeNome(String nome) {
        if (nome == null || nome.isEmpty() || nome.trim().isEmpty()) {
            throw new ParametroInvalidoException("quantidade", "Nome do remédio não pode ser vazio");
        }
    }

    private void validaExistenciaDeDosagem(Integer dosagemEmMg) {
        if (dosagemEmMg == null) {
            throw new ParametroInvalidoException("dosagemEmMg", "Remédio precisa possuir dosagem");
        }
    }

    private void validaDosagemPositiva(Integer dosagemEmMg) {
        if (dosagemEmMg < 0) {
            throw new ParametroInvalidoException("dosagemEmMg", "Dosagem não pode ser negativa");
        }
    }
}
