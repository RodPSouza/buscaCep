package br.com.rsouza8891.buscaCep.service;

import br.com.rsouza8891.buscaCep.model.CepResposta;

public interface ExternalCepService {

    CepResposta consultarApiExterna(String cep);

}
