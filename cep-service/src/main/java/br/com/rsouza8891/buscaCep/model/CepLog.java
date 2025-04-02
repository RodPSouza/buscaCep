package br.com.rsouza8891.buscaCep.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
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
