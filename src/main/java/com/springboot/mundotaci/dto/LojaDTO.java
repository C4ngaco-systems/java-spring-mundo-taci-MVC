package com.springboot.mundotaci.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class LojaDTO {

    private long id;

    private String cnpj;

    private String nome;

    private String endereco;

    private String cidade;

    private String estado;

    private String telefone;

    private String cep;

    private String propietario;

    private String celular;

    private String email;

    private String imagem;

}
