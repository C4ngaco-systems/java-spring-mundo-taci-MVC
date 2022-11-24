package com.springboot.mundotaci.service;

import com.springboot.mundotaci.dto.LojaDTO;

import java.util.List;

public interface LojaService {
    LojaDTO AddLoja(LojaDTO lojaDTO);

    List<LojaDTO> GetLojas();
}
