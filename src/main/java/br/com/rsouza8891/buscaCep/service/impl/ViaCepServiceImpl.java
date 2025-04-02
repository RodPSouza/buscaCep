package br.com.rsouza8891.buscaCep.service.impl;

import br.com.rsouza8891.buscaCep.exception.CepNotFoundException;
import br.com.rsouza8891.buscaCep.model.CepResposta;
import br.com.rsouza8891.buscaCep.service.ExternalCepService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
        String url = String.format("%s/%s/json/", apiUrl, cep);
        ResponseEntity<CepResposta> response = restTemplate.getForEntity(url, CepResposta.class);

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new CepNotFoundException("CEP não encontrado");
        }

        return response.getBody();
    }
}
