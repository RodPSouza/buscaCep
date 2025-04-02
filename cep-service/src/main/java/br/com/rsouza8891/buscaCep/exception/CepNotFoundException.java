package br.com.rsouza8891.buscaCep.exception;

public class CepNotFoundException extends RuntimeException {

    public CepNotFoundException(String message) {
        super(message);
    }

}
