package br.com.rsouza8891.buscaCep.service.impl;

import br.com.rsouza8891.buscaCep.exception.CepNotFoundException;
import br.com.rsouza8891.buscaCep.model.CepResposta;
import br.com.rsouza8891.buscaCep.service.ExternalCepService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepServiceImpl implements ExternalCepService {

    private final RestTemplate restTemplate;

    public ViaCepServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${external.cep.api.url}")
    private String apiUrl;

    @Override
    public CepResposta consultarApiExterna(String cep) {
        try {
        ResponseEntity<CepResposta> response = restTemplate.getForEntity(apiUrl
                + "/" + cep + "/json/", CepResposta.class);

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new CepNotFoundException("CEP não encontrado");
        }

        return response.getBody();
        } catch (HttpClientErrorException.NotFound ex) {
            throw new CepNotFoundException("CEP não encontrado");
        }
    }
}
