package com.springboot.mundotaci.dto;

import com.springboot.mundotaci.entity.Lojista;
import lombok.Data;

import javax.persistence.*;

@Data
public class LojaDTO {

    private long id;
    private String nome;
    private String funcionario;
    //private Lojista lojista;
}
