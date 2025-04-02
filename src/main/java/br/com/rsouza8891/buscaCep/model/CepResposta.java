package br.com.rsouza8891.buscaCep.model;


    public record CepResposta(
            String cep,
            String logradouro,
            String complemento,
            String bairro,
            String localidade,
            String uf,
            String ibge,
            String gia,
            String ddd,
            String siafi
    ) {}


