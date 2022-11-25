package com.springboot.mundotaci.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "loja")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String cnpj;
    @Column
    private String nome;
    @Column
    private String endereco;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Column
    private String telefone;
    @Column
    private String cep;
    @Column
    private String propietario;
    @Column
    private String celular;
    @Column
    private String email;
    @Column
    private String imagem;

}
