package br.com.rsouza8891.buscaCep.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class CepLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dataConsulta;

    @Column(columnDefinition = "JSON")
    private String respostaApi;


}
