package com.example.M3S06_CodeReview.Ex4;

public class ParametroInvalidoException extends RuntimeException {
    public ParametroInvalidoException(String campo, String mensagem) {
        super("Parâmetro invalido: " + campo + ": " + mensagem);
    }
}
