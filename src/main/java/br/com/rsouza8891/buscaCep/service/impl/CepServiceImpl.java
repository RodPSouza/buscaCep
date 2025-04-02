package br.com.rsouza8891.buscaCep.service.impl;

import br.com.rsouza8891.buscaCep.model.CepLog;
import br.com.rsouza8891.buscaCep.model.CepResposta;
import br.com.rsouza8891.buscaCep.repository.CepLogRepository;
import br.com.rsouza8891.buscaCep.service.CepService;
import br.com.rsouza8891.buscaCep.service.ExternalCepService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CepServiceImpl implements CepService {

    private final ExternalCepService externalCepService;
    private final CepLogRepository cepLogRepository;
    private final ObjectMapper objectMapper;

    @Override
    public CepResposta buscarCep(String cep) {

        CepResposta resposta = externalCepService.consultarApiExterna(cep);

        CepLog log = new CepLog();
        log.setCep(cep);
        log.setDataConsulta(LocalDateTime.now());
        log.setRespostaApi(convertToJson(resposta));

        cepLogRepository.save(log);

        return resposta;
    }

    private String convertToJson(CepResposta resposta) {
        try {
            return objectMapper.writeValueAsString(resposta);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Falha ao converter resposta para JSON", e);
        }
    }
}
