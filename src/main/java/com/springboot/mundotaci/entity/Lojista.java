package com.springboot.mundotaci.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
    name = "Lojista", uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})}
)
public class Lojista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "lojista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loja> lojas;

}
